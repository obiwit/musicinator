import java.util.*;

public class Scope {
	private Scope parent;
	private ArrayList<Scope> children;
	private Map<String, Variable> scopeMap;

	private int accessedChildren;

	// constructors
	public Scope(Scope s) {
		parent = s;
		scopeMap = new HashMap<>();
		children = new ArrayList<>();

		accessedChildren = 0;
	}
	public Scope() {
		this(null);
	}

	// variable related methods
	public Variable getVariable(String key) {
		assert isVariable(key);
		
		return getVarScope(key).scopeMap.get(key);
	}
	public void setVariable(String key, Variable var) {
		Scope s = getVarScope(key);
		if (s != null) {
			// if variable already exists in scope, update existing entry
			getVarScope(key).scopeMap.put(key, var);
		} else {
			// create new entry in current scope
			scopeMap.put(key, var);
		}
	}
	public boolean isVariable(String key) {
		return getVarScope(key) != null;
	}

	// scope related methods
	public Scope createChildScope() {
		children.add(new Scope(this));
		return children.get(children.size()-1);
	}
	public Scope getChildScope(int index) {
		assert index < children.size();

		return children.get(index);
	}
	public Scope getNextChildScope() {
		assert accessedChildren < children.size();

		return children.get(accessedChildren++);
	}
	public Scope getParentScope() {
		return parent;
	}
		

	// private methods
	private Scope getVarScope(String key) {
		Scope s = this;
		while(s != null) { 
			if (s.isLocalVariable(key)) {
				return s;
			}
			s = s.parent;
		}
		return null;
	}

	private boolean isLocalVariable(String key) {
		return scopeMap.containsKey(key);
	}
}

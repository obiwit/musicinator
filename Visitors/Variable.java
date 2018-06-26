import org.antlr.v4.runtime.ParserRuleContext;

public class Variable {
	private String name;
	private Type type;
	//private ParserRuleContext nodeDefined;

	public Variable(String n, Type t) {//, ParserRuleContext node) {
		name = n;
		type = t;
		//nodeDefined = node;
	}

	public String name() {
		return name;
	}

	public Type type() {
		return type;
	}
}
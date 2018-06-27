import org.antlr.v4.runtime.ParserRuleContext;

public class Variable {
	private String name;
	private Type type;

	public Variable(String n, Type t) {
		name = n;
		type = t;
	}

	public String name() {
		return name;
	}

	public Type type() {
		return type;
	}
}
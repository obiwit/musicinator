import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.antlr.v4.runtime.ParserRuleContext;

public class ErrorHandling {

	boolean flag;
	PrintWriter printer;

	public ErrorHandling(String filepath) {
		this.flag = false;
		this.printer = new PrintWriter(new FileOutputStream(new File(filepath)));
	}

	public void error(String details, ParserRuleContext ctx) {
		flag = true;
		String error = "ERROR! Line " + ctx.start.getLine() + ": " + details + "\n";
		System.err.println(error);
		printer.append(error);

	}

	public void error(String details){
		flag = true;
		String error = "ERROR!" + details + "\n";
		System.err.println(error);
		printer.append(error);
	}

	public boolean errorsDetected() {
		if (flag) {
			printer.printf("[%s%s%s] %s\n", "\033[0;31m", printer.toString());
			printer.flush();
		}else{
			printer.printf("[%s%s%s] %s\n", "\033[0;32m", "Compilation Started sucessfully");
		}
		return flag;

	}

}
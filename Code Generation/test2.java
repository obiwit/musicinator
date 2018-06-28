import java.io.PrintWriter;
import java.io.*;

import org.antlr.v4.parse.ANTLRParser.notSet_return;
import org.stringtemplate.v4.*;
import org.stringtemplate.v4.compiler.STParser.namedArg_return;

public class test2{

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String output = "";
        String toadd = "[1,(60,1,2),(62,1,25),(64,1,64),(65,1,53),(67,1,32),(69,1,14),(71,1,87),(72,1,69),2]";
        String toadd1 = "[1,(72,1,5),(71,1,55),(69,1,31),(67,1,45),(65,1,115),(64,1,54),(62,1,87),(60,1,69),2]";
        STGroup group = new STGroupFile("/home/toms/Desktop/lfaprojlocal/generator.stg");
        //Creating the header file
        ST gen1 = group.getInstanceOf("getInt");
        output += gen1.render() + "\n";

        gen1 = group.getInstanceOf("u_getint");
        gen1.add("varname", "testvar");
        gen1.add("str", "repeat times");

        output += gen1.render()+"\n";
        



        //exporting the code to a python file. 
        PrintWriter writer = new PrintWriter("test.py", "UTF-8");
        writer.println(output);
        writer.close();



        
    }



}
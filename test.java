import java.io.PrintWriter;
import java.io.*;

import org.antlr.v4.parse.ANTLRParser.notSet_return;
import org.stringtemplate.v4.*;
import org.stringtemplate.v4.compiler.STParser.namedArg_return;

public class test{

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String output = "";
        String toadd = "[1,(60,1,2),(62,1,25),(64,1,64),(65,1,53),(67,1,32),(69,1,14),(71,1,87),(72,1,69),2]";
        String toadd1 = "[1,(72,1,5),(71,1,55),(69,1,31),(67,1,45),(65,1,115),(64,1,54),(62,1,87),(60,1,69),2]";
        STGroup group = new STGroupFile("/home/toms/Desktop/lfaprojlocal/lfa-1718-g12/generator.stg");
        //Creating the header file
        ST gen1 = group.getInstanceOf("header");
        output += gen1.render() + "\n";
        //Injecting user defined variables
        ST gen2 = group.getInstanceOf("createmidi");
        int bpm = 60;
        int varTrack = 3;
        gen2.add("varbpm", bpm);
        gen2.add("vartrack", varTrack);
        output += "\n" + gen2.render() + "\n";
        //Creating the body
        ST gen3 = group.getInstanceOf("body");
        output += "\n" + gen3.render() + "\n";

        //creating performace
        ST gen4 = group.getInstanceOf("createperformance");
        gen4.add("name", "randomName");
        gen4.add("notes", toadd);
        output += "\n" + gen4.render() + "\n";

        //I have to get a new instance of the pattern or the information would over lap. Example: name would be equal o randomNamerandomName2
        gen4 = group.getInstanceOf("createperformance");
        gen4.add("name", "randomName2");
        gen4.add("notes", toadd1);
        output += "\n" + gen4.render() + "\n";

        //Adding the performances, again, have to create two instances so that the info would not overlap, this will be easy in for loop
    
        ST gen5 = group.getInstanceOf("addperformance");
        gen5.add("name", "randomName");
        output += "\n" + gen5.render() + "\n";
        gen5 = group.getInstanceOf("addperformance");
        gen5.add("name", "randomName2");
        output += "\n" + gen5.render() + "\n";

        //exporting the file
        ST gen6 = group.getInstanceOf("exportfile");
        gen6.add("name", "testfile");
        output += "\n" + gen6.render() + "\n";
        
        //exporting the code to a python file. 
        PrintWriter writer = new PrintWriter("test.py", "UTF-8");
        writer.println(output);
        writer.close();



        
    }



}
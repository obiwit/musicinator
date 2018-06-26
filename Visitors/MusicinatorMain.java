import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class MusicinatorMain {
   public static void main(String[] args) throws Exception {

      // get input streams for aux and main files
      InputStream aux_in = null, main_in = null;
      try { 
         aux_in = new FileInputStream(new File(args[0])); 
      }
      catch(FileNotFoundException e) {
         System.err.println("ERROR: reading aux file!"); 
         System.exit(1);
      }
      catch(ArrayIndexOutOfBoundsException e) {
         System.err.println("ERROR! Usage: java MusicinatorMain <aux file> <main file>"); 
         System.exit(1);
      }
      try {
         main_in = new FileInputStream(new File(args[1]));
      }
      catch(FileNotFoundException e) {
         System.err.println("ERROR: reading main file!"); 
         System.exit(1);
      }
      catch(ArrayIndexOutOfBoundsException e) {
         System.err.println("ERROR! Usage: java MusicinatorMain <aux file> <main file>"); 
         System.exit(1);
      }

      // generate output filename
      String filename =  args[1].split("\\.")[0] + ".py";
      if (args.length > 2)
         filename = args[2] + ".py";

      // create a parser from the aux file
      CharStream aux_input = CharStreams.fromStream(aux_in);
      AuxinatorLexer aux_lexer = new AuxinatorLexer(aux_input);
      CommonTokenStream aux_tokens = new CommonTokenStream(aux_lexer);
      AuxinatorParser aux_parser = new AuxinatorParser(aux_tokens);

      // create a parser from the main file
      CharStream main_input = CharStreams.fromStream(main_in);
      MusicinatorLexer main_lexer = new MusicinatorLexer(main_input);
      CommonTokenStream main_tokens = new CommonTokenStream(main_lexer);
      MusicinatorParser main_parser = new MusicinatorParser(main_tokens);

      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());

      // begin parsing at main rule
      ParseTree aux_tree = aux_parser.main();
      ParseTree main_tree = main_parser.main();

      if (aux_parser.getNumberOfSyntaxErrors() == 0 && 
         main_parser.getNumberOfSyntaxErrors() == 0) {

         // walk aux file's tree
         ParseTreeWalker aux_walker = new ParseTreeWalker();
         AuxPhase aux = new AuxPhase();
         aux_walker.walk(aux, aux_tree);


         // visit main file's tree;
         SemanticAnalysis semanticVisitor = new SemanticAnalysis(aux.music);
         semanticVisitor.visit(main_tree);
         Compiler compilerVisitor = new Compiler(aux.music, semanticVisitor.globalScope, filename);
         compilerVisitor.visit(main_tree);
      }
   }
}

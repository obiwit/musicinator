import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class MusicinatorMain {
    public static void main(String[] args) throws Exception {
        ErrorHandler errors = new ErrorHandler("main.txt");
        boolean debugflag = false;
        // looking for files
        int size = args.length;
        String muxName = null, auxName = null;
        Music m = new Music();
        for (int i = 0; i < size; i++) {
            if (args[i].contains(".mux")) {
                muxName = args[i];
            }
            if (args[i].contains("-d") || args[i].contains("--debug")) {
                debugflag = true;
            }
            if (args[i].contains(".aux")) {
                auxName = args[i];
            }
        }

        if (muxName == null) {
            errors.error("ERROR! Usage: java MusicinatorMain <main file> [aux file] [-d | --debug] ");
            System.exit(1);
        }
        if (auxName != null) {
            // get input streams for aux file
            InputStream aux_in = null;
            try {
                aux_in = new FileInputStream(new File(auxName));
            } catch (FileNotFoundException e) {
                errors.error("ERROR: reading aux file!");
                System.exit(1);
            }

            // create a parser from the aux file
            CharStream aux_input = CharStreams.fromStream(aux_in);
            AuxinatorLexer aux_lexer = new AuxinatorLexer(aux_input);
            CommonTokenStream aux_tokens = new CommonTokenStream(aux_lexer);
            AuxinatorParser aux_parser = new AuxinatorParser(aux_tokens);

            // begin parsing at main rule
            ParseTree aux_tree = aux_parser.main();

            if (aux_parser.getNumberOfSyntaxErrors() == 0) {

                AuxVisitor aux = new AuxVisitor();
                aux.visit(aux_tree);

                m = aux.music;
            } else {
                errors.error("Aborting... Syntax errors in " + auxName);
                System.exit(1);
            }
        }

        // get input streams for main file
        InputStream main_in = null;
        try {
            main_in = new FileInputStream(new File(muxName));
        } catch (FileNotFoundException e) {
            errors.error("ERROR: reading main file!");
            System.exit(1);
        }

        // generate output filename
        String[] path = muxName.split("\\.")[0].split("\\\\");
        path = path[path.length-1].split("/");
        String filename = path[path.length-1];

        // create a parser from the main file
        CharStream main_input = CharStreams.fromStream(main_in);
        MusicinatorLexer main_lexer = new MusicinatorLexer(main_input);
        CommonTokenStream main_tokens = new CommonTokenStream(main_lexer);
        MusicinatorParser main_parser = new MusicinatorParser(main_tokens);

        // begin parsing at main rule
        ParseTree main_tree = main_parser.main();

        if (main_parser.getNumberOfSyntaxErrors() == 0) {

            // visit main file's tree
            SemanticAnalysis semanticVisitor = new SemanticAnalysis(m);
            semanticVisitor.visit(main_tree);

            // check there were no semantic errors
            if (semanticVisitor.errors.errorsDetected()) {
                System.exit(1);
            }

            // start compilation
            Compiler compilerVisitor = new Compiler(m, semanticVisitor.globalScope, filename, debugflag);
            compilerVisitor.visit(main_tree);
        }
    }
}

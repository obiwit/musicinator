// Generated from AuxinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.*;

//javac *.java && java MusicinatorMain ex.aux ex.mux

/**
 * This class provides an empty implementation of {@link AuxinatorParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <Instrument> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class AuxVisitor extends AuxinatorParserBaseVisitor<Instrument> {
	/*
	Music music = new Music();
	Map<String, Integer> noteMap = new HashMap<>(); // Map - noteName to Pitch


	//@Override public Instrument visitMain(AuxinatorParser.MainContext ctx) { 
	//	return visitChildren(ctx); 
	//}
	
	@Override public Instrument visitBpm(AuxinatorParser.BpmContext ctx) { 
		music.bpm(Integer.parseInt(ctx.INT().getText()));
		return visitChildren(ctx); 
	}
	
	@Override public Instrument visitNoteMap(AuxinatorParser.NoteMapContext ctx) { 
		noteMap.put(ctx.WORD().getText(), Note.noteToPitch(ctx.NOTE().getText()));
		return visitChildren(ctx); 
	}
	
	@Override public Instrument visitInstAssign(AuxinatorParser.InstAssignContext ctx) {
		//music.getInstrument(....) nao vai funcionar
		String word = ctx.WORD().getText();
		
		Instrument inst = visit(ctx.instrumentDef());
		inst.name(word);
		
		if(music.isInstrument(word)){
			music.getInstrument(word).concatenate(inst, -1);	
		}
		else{
			music.addInstrument(word, inst);
		}


		return visitChildren(ctx); 
	}
	
	@Override public Instrument visitDefInheritance(AuxinatorParser.DefInheritanceContext ctx) { 
		Instrument inst = new Instrument("DefInheritance", -1);

		for(int i = 0; i < ctx.instrumentInheritance().size(); i++) {
			Instrument temp = visit(ctx.instrumentInheritance(i));
			inst.concatenate(temp, -1);
		}
		return inst; 
	}
	
	@Override public Instrument visitDefWord(AuxinatorParser.DefWordContext ctx) { 
		
		String word = ctx.WORD().getText();

		if(!music.isInstrument(word)){
			System.err.println("ERROR: the instrument \""+word+"\" is not defined!");
			System.exit(1);	
		}

		Instrument inst = new Instrument("DefWord", -1);
		inst.concatenate(music.getInstrument(word), -1);
		return inst; 
	}
	
	@Override public Instrument visitDefInt(AuxinatorParser.DefIntContext ctx) {
		int val = Integer.parseInt(ctx.INT().getText());

		Instrument inst = new Instrument("DefWord", -1);

		return inst; 
	}
	
	@Override public Instrument visitInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx) {
		Instrument inst = new Instrument("block", -1);

		String word = ctx.WORD().getText();

		if (!music.isInstrument(word)) {
			System.err.println("ERROR: the instrument \""+word+"\" is not defined!");
			System.exit(1);
		}

		if(ctx.n != null){
			int val = Note.noteToPitch(ctx.n.getText());
			inst.redefineNote(val, music.getInstrument(word).value(val));
			return inst; 
		}else{
			int val1 = Note.noteToPitch(ctx.n1.getText());
			int val2 = Note.noteToPitch(ctx.n2.getText());
			inst.redefineRange(val1, val2, music.getInstrument(word).value(val1));
			return inst;
		}
	}*/
}
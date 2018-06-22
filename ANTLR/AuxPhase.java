// Generated from AuxinatorParser.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.*;

public class AuxPhase extends AuxinatorParserBaseListener {
	ParseTreeProperty<Instrument> instruments = new ParseTreeProperty<>();

	Music music = new Music();
	Map<String, Integer> noteMap = new HashMap<>(); // Map - noteName to Pitch

	// @Override public void enterMain(AuxinatorParser.MainContext ctx) { }
	@Override public void exitMain(AuxinatorParser.MainContext ctx) {
		/*
		noteMap.forEach((k,v) -> System.out.println("key: " + k + " value:" + v));

		Map<String, Instrument> np = music.getMap();
		System.out.println("-----");
		np.forEach((k,v) -> System.out.println("key: " + k + " value:" + v.baseValue()));
		*/
	}

	// @Override public void enterBpm(AuxinatorParser.BpmContext ctx) { }
	@Override public void exitBpm(AuxinatorParser.BpmContext ctx) {
		music.setBPM(Integer.parseInt(ctx.INT().getText()));
	}

	//@Override public void enterInstAssign(AuxinatorParser.InstAssignContext ctx) { }
	@Override public void exitInstAssign(AuxinatorParser.InstAssignContext ctx) {
		music.addInstrument(ctx.WORD().getText(), instruments.get(ctx.instrumentDef()));
	}

	//@Override public void enterDefInheritance(AuxinatorParser.DefInheritanceContext ctx) { }
	@Override public void exitDefInheritance(AuxinatorParser.DefInheritanceContext ctx) {
		instruments.put(ctx, instruments.get(ctx.instrumentInheritanceList()));
	}

	//@Override public void enterDefWord(AuxinatorParser.DefWordContext ctx) { }
	@Override public void exitDefWord(AuxinatorParser.DefWordContext ctx) {
		// TODO check word exists in music
		// (adicionar-se um metodo em Music.java tipo
		//  isInstrument(String s), que devolve boolean,
		// i.e. return instruments.containsKey(s) ou assim)
		instruments.put(ctx, music.getInstrument(ctx.WORD().getText()));
	}
	//@Override public void enterDefInt(AuxinatorParser.DefIntContext ctx) { }
	@Override public void exitDefInt(AuxinatorParser.DefIntContext ctx) {
		instruments.put(ctx, new Instrument(Integer.parseInt(ctx.INT().getText())));
	}

	// @Override public void enterNoteMap(AuxinatorParser.NoteMapContext ctx) { }
	@Override public void exitNoteMap(AuxinatorParser.NoteMapContext ctx) {
		noteMap.put(ctx.WORD().getText(), Note.noteToPitch(ctx.NOTE().getText()));
	}


	@Override public void enterInstrumentInheritanceList(AuxinatorParser.InstrumentInheritanceListContext ctx) {
		// check if exists, else create new instrument, with value -1
		//music.getInstrument(ctx.WORD().getText())
		
		AuxinatorParser.InstAssignContext assignCtx = (AuxinatorParser.InstAssignContext)(ctx.getParent().getParent().getRuleContext());
		System.out.println(assignCtx.WORD().getText());
		

		if(!music.isInstrument(assignCtx.WORD().getText())) {
			instruments.put(ctx, new Instrument(-1));
			System.out.println("OLA");
		}else{

			System.out.println("t1  " + music.getInstrument(assignCtx.WORD().getText()));	
			instruments.put(ctx, music.getInstrument(assignCtx.WORD().getText()));
		}
	}
	@Override public void exitInstrumentInheritanceList(AuxinatorParser.InstrumentInheritanceListContext ctx) {
		
		// add inst to music

	}

	// @Override public void enterInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx) { }
	@Override public void exitInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx) {
		// get created instrument by parent ctx.parent()
		Instrument instrument = instruments.get((AuxinatorParser.InstrumentInheritanceListContext)ctx.getParent().getRuleContext());

		AuxinatorParser.InstAssignContext ah = (AuxinatorParser.InstAssignContext)(ctx.getParent().getParent().getParent().getRuleContext());
		System.out.println("t2 " + ah.getText());


		if(ctx.NOTE() != null){
			// É uma NOTE
			int pitch = Note.noteToPitch(ctx.NOTE().getText());
			int a = music.getInstrument(ctx.WORD().getText()).value(pitch);
			instrument.redefineNote(pitch, a);

		}else{
			// É um range de NOTE's
			int pitch1 = Note.noteToPitch(ctx.noteRange().NOTE(0).getText());
			int pitch2 = Note.noteToPitch(ctx.noteRange().NOTE(1).getText());

			//Se a WORD não for um dos instrumentos predefenidos, então irá ter que verificar, nota a nota
			// do instrumento pretendido
			//Se a WORD não for um dos instrumentos predefinidos, quer dizer que são instrumentos feitos pelo utilizador
			// e com o seu array de notas(0->108) modificado
			for(int i = pitch1; i <= pitch2; i++){
				instrument.redefineNote(i, music.getInstrument(ctx.WORD().getText()).value(i));				
			}

		}
	
		
		//instruments.put(ctx, ));

	}

	// @Override public void enterNoteRange(AuxinatorParser.NoteRangeContext ctx) { }
	@Override public void exitNoteRange(AuxinatorParser.NoteRangeContext ctx) { }

	// @Override public void enterEveryRule(ParserRuleContext ctx) { }
	// @Override public void exitEveryRule(ParserRuleContext ctx) { }
	// @Override public void visitTerminal(TerminalNode node) { }
	// @Override public void visitErrorNode(ErrorNode node) { }
}
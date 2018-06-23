import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.*;

/*
 * A listener that walks the auxiliary file's tree.
 * 
 * Creates the noteMap (map which contains defined non-standard
 * notes and their standard conterparts) and the music object 
 * (object which contains information about the BPM and available
 * instruments).
 */
public class AuxPhase extends AuxinatorParserBaseListener {
	ParseTreeProperty<Instrument> instruments = new ParseTreeProperty<>();

	Music music = new Music();
	Map<String, Integer> noteMap = new HashMap<>(); // Map - noteName to Pitch

	// @Override public void enterMain(AuxinatorParser.MainContext ctx) { }
	// @Override public void exitMain(AuxinatorParser.MainContext ctx) { }

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
		
		String word = ctx.WORD().getText();

		// check word defines an instrument present in music
		if (music.isInstrument(word)) {
			instruments.put(ctx, music.getInstrument(word));

		} else {
			System.err.println("ERROR: the instrument \""+word+"\" is not defined!");
			System.exit(1);
		}

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
		
		// check if instrument already exists (is being redefined), or if it is a
		// new instrument (with base value -1, since it wasn't created from any instrument)
		
		AuxinatorParser.InstAssignContext assignCtx = (AuxinatorParser.InstAssignContext)(ctx.getParent().getParent().getRuleContext());
		// System.out.println(assignCtx.WORD().getText());
		

		if(!music.isInstrument(assignCtx.WORD().getText())) {
			instruments.put(ctx, new Instrument(-1));
		} else {
			//System.out.println("t1  " + music.getInstrument(assignCtx.WORD().getText()));	
			instruments.put(ctx, music.getInstrument(assignCtx.WORD().getText()));
		}
	}
	// @Override public void exitInstrumentInheritanceList(AuxinatorParser.InstrumentInheritanceListContext ctx) { }


	// @Override public void enterInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx) { }
	@Override public void exitInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx) {
		// get created instrument by parent ctx.parent()
		Instrument instrument = instruments.get((AuxinatorParser.InstrumentInheritanceListContext)ctx.getParent().getRuleContext());

		// AuxinatorParser.InstAssignContext ah = (AuxinatorParser.InstAssignContext)(ctx.getParent().getParent().getParent().getRuleContext());
		// System.out.println("t2 " + ah.getText());

		// redefine instrument where appropriate
		if(ctx.NOTE() != null) {
			// redefine only a NOTE
			int pitch = Note.noteToPitch(ctx.NOTE().getText());
			int a = music.getInstrument(ctx.WORD().getText()).value(pitch);
			instrument.redefineNote(pitch, a);

		} else {
			// redefine a range of NOTEs
			int pitch1 = Note.noteToPitch(ctx.noteRange().NOTE(0).getText());
			int pitch2 = Note.noteToPitch(ctx.noteRange().NOTE(1).getText());

			// because an instrument can have various timbres, depending on its definition
			// and on the value currently being played, must iterate through all the pertinent
			// NOTE value 
			for(int i = pitch1; i <= pitch2; i++){
				instrument.redefineNote(i, music.getInstrument(ctx.WORD().getText()).value(i));				
			}

		}
	
		//instruments.put(ctx, instrument);

	}

	// @Override public void enterNoteRange(AuxinatorParser.NoteRangeContext ctx) { }
	// @Override public void exitNoteRange(AuxinatorParser.NoteRangeContext ctx) { }

	// @Override public void enterEveryRule(ParserRuleContext ctx) { }
	// @Override public void exitEveryRule(ParserRuleContext ctx) { }
	// @Override public void visitTerminal(TerminalNode node) { }
	// @Override public void visitErrorNode(ErrorNode node) { }
}
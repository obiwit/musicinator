// Generated from AuxinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.*;

/**
 * This class provides an empty implementation of {@link AuxinatorParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class AuxVisitor<T> extends AuxinatorParserBaseVisitor<T> {
	
	Music music = new Music();
	Map<String, Integer> noteMap = new HashMap<>(); // Map - noteName to Pitch
/*
	@Override public T visitMain(AuxinatorParser.MainContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public T visitBpm(AuxinatorParser.BpmContext ctx) { 
		music.bpm(Integer.parseInt(ctx.INT().getText()));
		return visitChildren(ctx); 
	}
	
	@Override public T visitNoteMap(AuxinatorParser.NoteMapContext ctx) { 
		noteMap.put(ctx.WORD().getText(), Note.noteToPitch(ctx.NOTE().getText()));
		return visitChildren(ctx); 
	}
	
	@Override public T visitInstAssign(AuxinatorParser.InstAssignContext ctx) { 
		music.addInstrument(ctx.WORD().getText(), instruments.get(ctx.instrumentDef()));
		return visitChildren(ctx); 
	}
	
	@Override public T visitDefInheritance(AuxinatorParser.DefInheritanceContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public T visitDefWord(AuxinatorParser.DefWordContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public T visitDefInt(AuxinatorParser.DefIntContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public T visitInstrumentInheritanceList(AuxinatorParser.InstrumentInheritanceListContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public T visitInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public T visitNoteRange(AuxinatorParser.NoteRangeContext ctx) { 
		return visitChildren(ctx); 
	}*/
}
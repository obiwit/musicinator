// Generated from AuxinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AuxinatorParser}.
 */
public interface AuxinatorParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(AuxinatorParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(AuxinatorParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#bpm}.
	 * @param ctx the parse tree
	 */
	void enterBpm(AuxinatorParser.BpmContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#bpm}.
	 * @param ctx the parse tree
	 */
	void exitBpm(AuxinatorParser.BpmContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#instAssign}.
	 * @param ctx the parse tree
	 */
	void enterInstAssign(AuxinatorParser.InstAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#instAssign}.
	 * @param ctx the parse tree
	 */
	void exitInstAssign(AuxinatorParser.InstAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#instrumentDef}.
	 * @param ctx the parse tree
	 */
	void enterInstrumentDef(AuxinatorParser.InstrumentDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#instrumentDef}.
	 * @param ctx the parse tree
	 */
	void exitInstrumentDef(AuxinatorParser.InstrumentDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#noteMap}.
	 * @param ctx the parse tree
	 */
	void enterNoteMap(AuxinatorParser.NoteMapContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#noteMap}.
	 * @param ctx the parse tree
	 */
	void exitNoteMap(AuxinatorParser.NoteMapContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#noteMapList}.
	 * @param ctx the parse tree
	 */
	void enterNoteMapList(AuxinatorParser.NoteMapListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#noteMapList}.
	 * @param ctx the parse tree
	 */
	void exitNoteMapList(AuxinatorParser.NoteMapListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#instrumentInheritance}.
	 * @param ctx the parse tree
	 */
	void enterInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#instrumentInheritance}.
	 * @param ctx the parse tree
	 */
	void exitInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#instrumentInheritanceList}.
	 * @param ctx the parse tree
	 */
	void enterInstrumentInheritanceList(AuxinatorParser.InstrumentInheritanceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#instrumentInheritanceList}.
	 * @param ctx the parse tree
	 */
	void exitInstrumentInheritanceList(AuxinatorParser.InstrumentInheritanceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AuxinatorParser#noteRange}.
	 * @param ctx the parse tree
	 */
	void enterNoteRange(AuxinatorParser.NoteRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AuxinatorParser#noteRange}.
	 * @param ctx the parse tree
	 */
	void exitNoteRange(AuxinatorParser.NoteRangeContext ctx);
}
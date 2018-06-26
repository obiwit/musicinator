// Generated from AuxinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AuxinatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AuxinatorParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AuxinatorParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(AuxinatorParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuxinatorParser#bpm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBpm(AuxinatorParser.BpmContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuxinatorParser#noteMap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteMap(AuxinatorParser.NoteMapContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuxinatorParser#instAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstAssign(AuxinatorParser.InstAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defInheritance}
	 * labeled alternative in {@link AuxinatorParser#instrumentDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefInheritance(AuxinatorParser.DefInheritanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defWord}
	 * labeled alternative in {@link AuxinatorParser#instrumentDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefWord(AuxinatorParser.DefWordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defInt}
	 * labeled alternative in {@link AuxinatorParser#instrumentDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefInt(AuxinatorParser.DefIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuxinatorParser#instrumentInheritanceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrumentInheritanceList(AuxinatorParser.InstrumentInheritanceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuxinatorParser#instrumentInheritance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrumentInheritance(AuxinatorParser.InstrumentInheritanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link AuxinatorParser#noteRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteRange(AuxinatorParser.NoteRangeContext ctx);
}
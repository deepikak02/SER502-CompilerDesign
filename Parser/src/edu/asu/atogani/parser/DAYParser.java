// Generated from DAY.g4 by ANTLR 4.5.3
package edu.asu.atogani.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DAYParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, IDENTIFIER=28, NUMBVALUE=29, STRINGVALUE=30, 
		WS=31;
	public static final int
		RULE_prog = 0, RULE_declaration = 1, RULE_vardeclaration = 2, RULE_mainblock = 3, 
		RULE_statement = 4, RULE_stringdecl = 5, RULE_intdecl = 6, RULE_booldecl = 7, 
		RULE_print = 8, RULE_expr = 9, RULE_additionExp = 10, RULE_multiplyExp = 11, 
		RULE_atomExp = 12, RULE_funccall = 13, RULE_funcdeclaration = 14, RULE_argument = 15, 
		RULE_block = 16, RULE_ret = 17, RULE_loop = 18, RULE_condnstatement = 19, 
		RULE_condn = 20, RULE_parameter = 21, RULE_type = 22, RULE_boolvalue = 23;
	public static final String[] ruleNames = {
		"prog", "declaration", "vardeclaration", "mainblock", "statement", "stringdecl", 
		"intdecl", "booldecl", "print", "expr", "additionExp", "multiplyExp", 
		"atomExp", "funccall", "funcdeclaration", "argument", "block", "ret", 
		"loop", "condnstatement", "condn", "parameter", "type", "boolvalue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'START'", "'END'", "'string'", "'='", "';'", "'numb'", "'boolean'", 
		"'print'", "'-'", "'+'", "'*'", "'/'", "'('", "')'", "'method'", "'<-'", 
		"'void'", "','", "'{'", "'}'", "'return'", "'while('", "'if('", "'else'", 
		"'=='", "'true'", "'false'", null, null, "'\"text\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "IDENTIFIER", "NUMBVALUE", "STRINGVALUE", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DAY.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DAYParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public MainblockContext mainblock() {
			return getRuleContext(MainblockContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__14) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(48);
				declaration();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			mainblock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public VardeclarationContext vardeclaration() {
			return getRuleContext(VardeclarationContext.class,0);
		}
		public FuncdeclarationContext funcdeclaration() {
			return getRuleContext(FuncdeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(58);
			switch (_input.LA(1)) {
			case T__2:
			case T__5:
			case T__6:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				vardeclaration();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				funcdeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclarationContext extends ParserRuleContext {
		public IntdeclContext intdecl() {
			return getRuleContext(IntdeclContext.class,0);
		}
		public BooldeclContext booldecl() {
			return getRuleContext(BooldeclContext.class,0);
		}
		public StringdeclContext stringdecl() {
			return getRuleContext(StringdeclContext.class,0);
		}
		public VardeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitVardeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardeclarationContext vardeclaration() throws RecognitionException {
		VardeclarationContext _localctx = new VardeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardeclaration);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				intdecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				booldecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				stringdecl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainblockContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MainblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainblock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitMainblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainblockContext mainblock() throws RecognitionException {
		MainblockContext _localctx = new MainblockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mainblock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__0);
			setState(66);
			statement();
			setState(67);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Vdec_statementContext extends StatementContext {
		public VardeclarationContext vardeclaration() {
			return getRuleContext(VardeclarationContext.class,0);
		}
		public Vdec_statementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitVdec_statement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CstateContext extends StatementContext {
		public CondnstatementContext condnstatement() {
			return getRuleContext(CondnstatementContext.class,0);
		}
		public CstateContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitCstate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Label_loopContext extends StatementContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public Label_loopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitLabel_loop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Label_printContext extends StatementContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public Label_printContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitLabel_print(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatementContext {
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FcallContext extends StatementContext {
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public FcallContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitFcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new Vdec_statementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				vardeclaration();
				}
				break;
			case 2:
				_localctx = new Label_printContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				print();
				}
				break;
			case 3:
				_localctx = new FcallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				funccall();
				}
				break;
			case 4:
				_localctx = new CstateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				condnstatement();
				}
				break;
			case 5:
				_localctx = new Label_loopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				loop();
				}
				break;
			case 6:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				ret();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringdeclContext extends ParserRuleContext {
		public Token var;
		public Token val;
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public TerminalNode STRINGVALUE() { return getToken(DAYParser.STRINGVALUE, 0); }
		public StringdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringdecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitStringdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringdeclContext stringdecl() throws RecognitionException {
		StringdeclContext _localctx = new StringdeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stringdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(77);
				match(T__2);
				}
			}

			setState(80);
			((StringdeclContext)_localctx).var = match(IDENTIFIER);
			setState(83);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(81);
				match(T__3);
				setState(82);
				((StringdeclContext)_localctx).val = match(STRINGVALUE);
				}
			}

			setState(85);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntdeclContext extends ParserRuleContext {
		public Token var;
		public Token numb_val;
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public TerminalNode NUMBVALUE() { return getToken(DAYParser.NUMBVALUE, 0); }
		public IntdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intdecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitIntdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntdeclContext intdecl() throws RecognitionException {
		IntdeclContext _localctx = new IntdeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_intdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(87);
				match(T__5);
				}
			}

			setState(90);
			((IntdeclContext)_localctx).var = match(IDENTIFIER);
			setState(97);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(91);
				match(T__3);
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(92);
					((IntdeclContext)_localctx).numb_val = match(NUMBVALUE);
					}
					break;
				case 2:
					{
					setState(93);
					expr();
					}
					break;
				case 3:
					{
					setState(94);
					funccall();
					}
					break;
				}
				}
			}

			setState(99);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooldeclContext extends ParserRuleContext {
		public Token var;
		public BoolvalueContext val;
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public BooldeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booldecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitBooldecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooldeclContext booldecl() throws RecognitionException {
		BooldeclContext _localctx = new BooldeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_booldecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(101);
				match(T__6);
				}
			}

			setState(104);
			((BooldeclContext)_localctx).var = match(IDENTIFIER);
			setState(107);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(105);
				match(T__3);
				setState(106);
				((BooldeclContext)_localctx).val = boolvalue();
				}
			}

			setState(109);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NUMBVALUE() { return getToken(DAYParser.NUMBVALUE, 0); }
		public TerminalNode STRINGVALUE() { return getToken(DAYParser.STRINGVALUE, 0); }
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__7);
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(112);
				expr();
				}
				break;
			case 2:
				{
				setState(113);
				match(NUMBVALUE);
				}
				break;
			case 3:
				{
				setState(114);
				match(STRINGVALUE);
				}
				break;
			case 4:
				{
				setState(115);
				boolvalue();
				}
				break;
			}
			setState(118);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AdditionExpContext additionExp() {
			return getRuleContext(AdditionExpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(120);
				match(T__8);
				}
			}

			setState(123);
			additionExp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditionExpContext extends ParserRuleContext {
		public List<MultiplyExpContext> multiplyExp() {
			return getRuleContexts(MultiplyExpContext.class);
		}
		public MultiplyExpContext multiplyExp(int i) {
			return getRuleContext(MultiplyExpContext.class,i);
		}
		public AdditionExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitAdditionExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionExpContext additionExp() throws RecognitionException {
		AdditionExpContext _localctx = new AdditionExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_additionExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			multiplyExp();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==T__9) {
				{
				setState(130);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(126);
					match(T__9);
					setState(127);
					multiplyExp();
					}
					break;
				case T__8:
					{
					setState(128);
					match(T__8);
					setState(129);
					multiplyExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplyExpContext extends ParserRuleContext {
		public List<AtomExpContext> atomExp() {
			return getRuleContexts(AtomExpContext.class);
		}
		public AtomExpContext atomExp(int i) {
			return getRuleContext(AtomExpContext.class,i);
		}
		public MultiplyExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitMultiplyExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyExpContext multiplyExp() throws RecognitionException {
		MultiplyExpContext _localctx = new MultiplyExpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_multiplyExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			atomExp();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10 || _la==T__11) {
				{
				setState(140);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(136);
					match(T__10);
					setState(137);
					atomExp();
					}
					break;
				case T__11:
					{
					setState(138);
					match(T__11);
					setState(139);
					atomExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomExpContext extends ParserRuleContext {
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public TerminalNode NUMBVALUE() { return getToken(DAYParser.NUMBVALUE, 0); }
		public AdditionExpContext additionExp() {
			return getRuleContext(AdditionExpContext.class,0);
		}
		public AtomExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitAtomExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomExpContext atomExp() throws RecognitionException {
		AtomExpContext _localctx = new AtomExpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atomExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(145);
				funccall();
				}
				break;
			case 2:
				{
				setState(146);
				match(IDENTIFIER);
				}
				break;
			case 3:
				{
				setState(147);
				match(NUMBVALUE);
				}
				break;
			case 4:
				{
				setState(148);
				match(T__12);
				setState(149);
				additionExp();
				setState(150);
				match(T__13);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunccallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public FunccallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funccall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitFunccall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funccall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(IDENTIFIER);
			setState(155);
			match(T__12);
			setState(156);
			parameter();
			setState(157);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncdeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitFuncdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdeclarationContext funcdeclaration() throws RecognitionException {
		FuncdeclarationContext _localctx = new FuncdeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_funcdeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__14);
			setState(160);
			match(IDENTIFIER);
			setState(161);
			match(T__12);
			setState(162);
			argument();
			setState(163);
			match(T__13);
			setState(164);
			match(T__15);
			setState(167);
			switch (_input.LA(1)) {
			case T__2:
			case T__5:
			case T__6:
				{
				setState(165);
				type();
				}
				break;
			case T__16:
				{
				setState(166);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(169);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argument);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			type();
			setState(172);
			match(IDENTIFIER);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(173);
					match(T__17);
					setState(174);
					argument();
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__18);
			setState(181);
			statement();
			setState(182);
			match(T__19);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NUMBVALUE() { return getToken(DAYParser.NUMBVALUE, 0); }
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__20);
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(185);
				expr();
				}
				break;
			case 2:
				{
				setState(186);
				match(NUMBVALUE);
				}
				break;
			case 3:
				{
				setState(187);
				funccall();
				}
				break;
			}
			setState(190);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public CondnContext condn() {
			return getRuleContext(CondnContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__21);
			setState(193);
			condn();
			setState(194);
			match(T__13);
			setState(195);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondnstatementContext extends ParserRuleContext {
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<CondnstatementContext> condnstatement() {
			return getRuleContexts(CondnstatementContext.class);
		}
		public CondnstatementContext condnstatement(int i) {
			return getRuleContext(CondnstatementContext.class,i);
		}
		public CondnContext condn() {
			return getRuleContext(CondnContext.class,0);
		}
		public CondnstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condnstatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitCondnstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondnstatementContext condnstatement() throws RecognitionException {
		CondnstatementContext _localctx = new CondnstatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condnstatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__22);
			setState(200);
			switch (_input.LA(1)) {
			case T__22:
				{
				setState(198);
				condnstatement();
				}
				break;
			case T__8:
			case T__12:
			case IDENTIFIER:
			case NUMBVALUE:
				{
				setState(199);
				condn();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(202);
			match(T__13);
			setState(203);
			block();
			setState(209);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(204);
				match(T__23);
				setState(207);
				switch (_input.LA(1)) {
				case T__22:
					{
					setState(205);
					condnstatement();
					}
					break;
				case T__18:
					{
					setState(206);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondnContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public TerminalNode NUMBVALUE() { return getToken(DAYParser.NUMBVALUE, 0); }
		public TerminalNode STRINGVALUE() { return getToken(DAYParser.STRINGVALUE, 0); }
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public CondnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitCondn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondnContext condn() throws RecognitionException {
		CondnContext _localctx = new CondnContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_condn);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(IDENTIFIER);
				setState(213);
				match(T__24);
				setState(217);
				switch (_input.LA(1)) {
				case NUMBVALUE:
					{
					setState(214);
					match(NUMBVALUE);
					}
					break;
				case STRINGVALUE:
					{
					setState(215);
					match(STRINGVALUE);
					}
					break;
				case T__25:
				case T__26:
					{
					setState(216);
					boolvalue();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode NUMBVALUE() { return getToken(DAYParser.NUMBVALUE, 0); }
		public TerminalNode STRINGVALUE() { return getToken(DAYParser.STRINGVALUE, 0); }
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(DAYParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(221);
				match(NUMBVALUE);
				}
				break;
			case 2:
				{
				setState(222);
				match(STRINGVALUE);
				}
				break;
			case 3:
				{
				setState(223);
				boolvalue();
				}
				break;
			case 4:
				{
				setState(224);
				match(IDENTIFIER);
				}
				break;
			case 5:
				{
				setState(225);
				expr();
				}
				break;
			}
			setState(232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(228);
					match(T__17);
					setState(229);
					parameter();
					}
					} 
				}
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolvalueContext extends ParserRuleContext {
		public BoolvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolvalue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DAYVisitor ) return ((DAYVisitor<? extends T>)visitor).visitBoolvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolvalueContext boolvalue() throws RecognitionException {
		BoolvalueContext _localctx = new BoolvalueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_boolvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u00f2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\5\3=\n\3\3\4\3\4\3\4"+
		"\5\4B\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6N\n\6\3\7\5\7Q\n"+
		"\7\3\7\3\7\3\7\5\7V\n\7\3\7\3\7\3\b\5\b[\n\b\3\b\3\b\3\b\3\b\3\b\5\bb"+
		"\n\b\5\bd\n\b\3\b\3\b\3\t\5\ti\n\t\3\t\3\t\3\t\5\tn\n\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\5\nw\n\n\3\n\3\n\3\13\5\13|\n\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u0085\n\f\f\f\16\f\u0088\13\f\3\r\3\r\3\r\3\r\3\r\7\r\u008f"+
		"\n\r\f\r\16\r\u0092\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009b"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00aa\n\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00b2\n\21\f\21\16"+
		"\21\u00b5\13\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00bf\n\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u00cb\n\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u00d2\n\25\5\25\u00d4\n\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\5\26\u00dc\n\26\5\26\u00de\n\26\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u00e5\n\27\3\27\3\27\7\27\u00e9\n\27\f\27\16\27\u00ec\13\27\3\30"+
		"\3\30\3\31\3\31\3\31\2\2\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\2\4\4\2\5\5\b\t\3\2\34\35\u0104\2\65\3\2\2\2\4<\3\2\2\2\6A\3"+
		"\2\2\2\bC\3\2\2\2\nM\3\2\2\2\fP\3\2\2\2\16Z\3\2\2\2\20h\3\2\2\2\22q\3"+
		"\2\2\2\24{\3\2\2\2\26\177\3\2\2\2\30\u0089\3\2\2\2\32\u009a\3\2\2\2\34"+
		"\u009c\3\2\2\2\36\u00a1\3\2\2\2 \u00ad\3\2\2\2\"\u00b6\3\2\2\2$\u00ba"+
		"\3\2\2\2&\u00c2\3\2\2\2(\u00c7\3\2\2\2*\u00dd\3\2\2\2,\u00e4\3\2\2\2."+
		"\u00ed\3\2\2\2\60\u00ef\3\2\2\2\62\64\5\4\3\2\63\62\3\2\2\2\64\67\3\2"+
		"\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\5\b\5\29"+
		"\3\3\2\2\2:=\5\6\4\2;=\5\36\20\2<:\3\2\2\2<;\3\2\2\2=\5\3\2\2\2>B\5\16"+
		"\b\2?B\5\20\t\2@B\5\f\7\2A>\3\2\2\2A?\3\2\2\2A@\3\2\2\2B\7\3\2\2\2CD\7"+
		"\3\2\2DE\5\n\6\2EF\7\4\2\2F\t\3\2\2\2GN\5\6\4\2HN\5\22\n\2IN\5\34\17\2"+
		"JN\5(\25\2KN\5&\24\2LN\5$\23\2MG\3\2\2\2MH\3\2\2\2MI\3\2\2\2MJ\3\2\2\2"+
		"MK\3\2\2\2ML\3\2\2\2N\13\3\2\2\2OQ\7\5\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2"+
		"\2RU\7\36\2\2ST\7\6\2\2TV\7 \2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\7\2"+
		"\2X\r\3\2\2\2Y[\7\b\2\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\c\7\36\2\2]a\7"+
		"\6\2\2^b\7\37\2\2_b\5\24\13\2`b\5\34\17\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2"+
		"\2bd\3\2\2\2c]\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\7\2\2f\17\3\2\2\2gi\7\t"+
		"\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2\2jm\7\36\2\2kl\7\6\2\2ln\5\60\31\2mk"+
		"\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\7\2\2p\21\3\2\2\2qv\7\n\2\2rw\5\24\13"+
		"\2sw\7\37\2\2tw\7 \2\2uw\5\60\31\2vr\3\2\2\2vs\3\2\2\2vt\3\2\2\2vu\3\2"+
		"\2\2wx\3\2\2\2xy\7\7\2\2y\23\3\2\2\2z|\7\13\2\2{z\3\2\2\2{|\3\2\2\2|}"+
		"\3\2\2\2}~\5\26\f\2~\25\3\2\2\2\177\u0086\5\30\r\2\u0080\u0081\7\f\2\2"+
		"\u0081\u0085\5\30\r\2\u0082\u0083\7\13\2\2\u0083\u0085\5\30\r\2\u0084"+
		"\u0080\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\27\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u0090"+
		"\5\32\16\2\u008a\u008b\7\r\2\2\u008b\u008f\5\32\16\2\u008c\u008d\7\16"+
		"\2\2\u008d\u008f\5\32\16\2\u008e\u008a\3\2\2\2\u008e\u008c\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\31\3\2\2"+
		"\2\u0092\u0090\3\2\2\2\u0093\u009b\5\34\17\2\u0094\u009b\7\36\2\2\u0095"+
		"\u009b\7\37\2\2\u0096\u0097\7\17\2\2\u0097\u0098\5\26\f\2\u0098\u0099"+
		"\7\20\2\2\u0099\u009b\3\2\2\2\u009a\u0093\3\2\2\2\u009a\u0094\3\2\2\2"+
		"\u009a\u0095\3\2\2\2\u009a\u0096\3\2\2\2\u009b\33\3\2\2\2\u009c\u009d"+
		"\7\36\2\2\u009d\u009e\7\17\2\2\u009e\u009f\5,\27\2\u009f\u00a0\7\20\2"+
		"\2\u00a0\35\3\2\2\2\u00a1\u00a2\7\21\2\2\u00a2\u00a3\7\36\2\2\u00a3\u00a4"+
		"\7\17\2\2\u00a4\u00a5\5 \21\2\u00a5\u00a6\7\20\2\2\u00a6\u00a9\7\22\2"+
		"\2\u00a7\u00aa\5.\30\2\u00a8\u00aa\7\23\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\5\"\22\2\u00ac\37\3\2\2"+
		"\2\u00ad\u00ae\5.\30\2\u00ae\u00b3\7\36\2\2\u00af\u00b0\7\24\2\2\u00b0"+
		"\u00b2\5 \21\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4!\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7"+
		"\7\25\2\2\u00b7\u00b8\5\n\6\2\u00b8\u00b9\7\26\2\2\u00b9#\3\2\2\2\u00ba"+
		"\u00be\7\27\2\2\u00bb\u00bf\5\24\13\2\u00bc\u00bf\7\37\2\2\u00bd\u00bf"+
		"\5\34\17\2\u00be\u00bb\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2"+
		"\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\7\2\2\u00c1%\3\2\2\2\u00c2\u00c3\7"+
		"\30\2\2\u00c3\u00c4\5*\26\2\u00c4\u00c5\7\20\2\2\u00c5\u00c6\5\"\22\2"+
		"\u00c6\'\3\2\2\2\u00c7\u00ca\7\31\2\2\u00c8\u00cb\5(\25\2\u00c9\u00cb"+
		"\5*\26\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\7\20\2\2\u00cd\u00d3\5\"\22\2\u00ce\u00d1\7\32\2\2\u00cf\u00d2"+
		"\5(\25\2\u00d0\u00d2\5\"\22\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2"+
		"\u00d2\u00d4\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4)\3"+
		"\2\2\2\u00d5\u00de\5\24\13\2\u00d6\u00d7\7\36\2\2\u00d7\u00db\7\33\2\2"+
		"\u00d8\u00dc\7\37\2\2\u00d9\u00dc\7 \2\2\u00da\u00dc\5\60\31\2\u00db\u00d8"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00d5\3\2\2\2\u00dd\u00d6\3\2\2\2\u00de+\3\2\2\2\u00df\u00e5\7\37\2\2"+
		"\u00e0\u00e5\7 \2\2\u00e1\u00e5\5\60\31\2\u00e2\u00e5\7\36\2\2\u00e3\u00e5"+
		"\5\24\13\2\u00e4\u00df\3\2\2\2\u00e4\u00e0\3\2\2\2\u00e4\u00e1\3\2\2\2"+
		"\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00ea\3\2\2\2\u00e6\u00e7"+
		"\7\24\2\2\u00e7\u00e9\5,\27\2\u00e8\u00e6\3\2\2\2\u00e9\u00ec\3\2\2\2"+
		"\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb-\3\2\2\2\u00ec\u00ea\3"+
		"\2\2\2\u00ed\u00ee\t\2\2\2\u00ee/\3\2\2\2\u00ef\u00f0\t\3\2\2\u00f0\61"+
		"\3\2\2\2\36\65<AMPUZachmv{\u0084\u0086\u008e\u0090\u009a\u00a9\u00b3\u00be"+
		"\u00ca\u00d1\u00d3\u00db\u00dd\u00e4\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
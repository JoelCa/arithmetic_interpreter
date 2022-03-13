package parser;

import ast.DivideNode;
import ast.IArithmeticNode;
import ast.IntLiteralNode;
import ast.MinusNode;
import ast.PlusNode;
import ast.TimesNode;
import lexer.Lexer;
import token.ArithmeticToken;
import token.ArithmeticTokenType;

public class Parser {
	private ArithmeticToken currentToken;
	private Lexer lexer;
	
	public Parser(Lexer lexer) {
		this.currentToken = null;
		this.lexer = lexer;
	}
	
	private void eat(ArithmeticTokenType tokenType) throws Exception {
		if (tokenType.equals(currentToken.getTokenType())) {
			currentToken = lexer.get_next_token();
		}
		else {
			throw new Exception("error de parseo");
		}
	}
	
	private IArithmeticNode factor() throws Exception {
		ArithmeticToken token = currentToken;
		if (token.isDigit()) {
			eatInteger();
			int value = (int) token.getTokenValue();
			return new IntLiteralNode(value);
		}
		else if (token.isLeftParen()) {
			eatLeftParen();
			IArithmeticNode node = expr();
			eatRightParen();
			return node;
		}
		return null;
	}
	
	private IArithmeticNode term() throws Exception {
		IArithmeticNode node = factor();
		
		while (isMultOrDivToken(currentToken)) {
			ArithmeticToken token = currentToken;
			if (token.isTimes()) {
				eatTimes();
				node = new TimesNode(node, factor());
			}
			else if (token.isDiv()) {
				eatDiv();
				node = new DivideNode(node, factor());
			}
		}
		return node;
	}
	
	private IArithmeticNode expr() throws Exception {
		IArithmeticNode node = term();
		while (isPlusOrMinusToken(currentToken)) {
			ArithmeticToken token = currentToken;
			if (token.isPlus()) {
				eatPlus();
				node = new PlusNode(node, term());
			}
			else if (token.isMinus()) {
				eatMinus();
				node = new MinusNode(node, term());
			}
		}
		return node;
	}
	
	public IArithmeticNode parse(String text) throws Exception {
		lexer.setText(text);
		currentToken = lexer.get_next_token();
		return expr();
	}

	private boolean isPlusOrMinusToken(ArithmeticToken token) {
		return token.isPlus() || token.isMinus();
	}
	
	private boolean isMultOrDivToken(ArithmeticToken token) {
		return token.isTimes() || token.isDiv();
	}
	
	private void eatInteger() throws Exception {
		eat(ArithmeticTokenType.INTEGER);
	}

	private void eatPlus() throws Exception {
		eat(ArithmeticTokenType.PLUS);
	}

	private void eatMinus() throws Exception {
		eat(ArithmeticTokenType.MINUS);
	}

	private void eatTimes() throws Exception {
		eat(ArithmeticTokenType.TIMES); }

	private void eatDiv() throws Exception {
		eat(ArithmeticTokenType.DIV);
	}

	private void eatLeftParen() throws Exception {
		eat(ArithmeticTokenType.LPAREN);
	}

	private void eatRightParen() throws Exception {
		eat(ArithmeticTokenType.RPAREN);
	}
}
package lexer;

import token.ArithmeticToken;
import token.ArithmeticTokenType;

public class Lexer {
	private int position;
	private Character currentChar;
	private String text;
	
	public Lexer() {
		this.text = null;
		this.position = 0;
		this.currentChar = null;
	}
	
	public void setText(String text) {
		this.position = 0;
		this.currentChar = text.charAt(position);
		this.text = text;
	}
	
	public void advance() {
		position += 1;
		if (position > text.length() - 1) {
			currentChar = null;
		}
		else {
			currentChar = text.charAt(position);
		}
	}
	
	public void skip_withespace() {
		while (currentChar != null && Character.isWhitespace(currentChar)) {
			advance();
		}
	}
	
	public int integer() {
		String result = "";
		while (currentChar != null && Character.isDigit(currentChar)) {
			result += currentChar;
			advance();
		}
		return Integer.parseInt(result);
	}
	
	public ArithmeticToken get_next_token () throws Exception {
		while (currentChar != null) {
			if (Character.isWhitespace(currentChar)) {
				skip_withespace();
				continue;
			}
			if (Character.isDigit(currentChar)) {
				return new ArithmeticToken(ArithmeticTokenType.INTEGER, integer());
			}
			if (Character.compare(currentChar, '+') == 0) {
				advance();
				return new ArithmeticToken(ArithmeticTokenType.PLUS);
			}
			if (Character.compare(currentChar, '-') == 0) {
				advance();
				return new ArithmeticToken(ArithmeticTokenType.MINUS);
			}
			if (Character.compare(currentChar, '*') == 0) {
				advance();
				return new ArithmeticToken(ArithmeticTokenType.TIMES);
			}
			if (Character.compare(currentChar, '/') == 0) {
				advance();
				return new ArithmeticToken(ArithmeticTokenType.DIV);
			}
			if (Character.compare(currentChar, '(') == 0) {
				advance();
				return new ArithmeticToken(ArithmeticTokenType.LPAREN);
			}
			if (Character.compare(currentChar, ')') == 0) {
				advance();
				return new ArithmeticToken(ArithmeticTokenType.RPAREN);
			}
			throw new Exception("error de sintaxis");
		}
		return new ArithmeticToken(ArithmeticTokenType.EOF);
	}

}



















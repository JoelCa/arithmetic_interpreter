package token;

public class ArithmeticToken extends AbstractToken {

	public ArithmeticToken(ArithmeticTokenType tokenType) {
		super(tokenType);
	}

	public ArithmeticToken(ArithmeticTokenType tokenType, Object tokenValue) {
		super(tokenType, tokenValue);
	}

	public boolean isDigit() {
		return ArithmeticTokenType.INTEGER.equals(getTokenType());
	}
	
	public boolean isPlus() {
		return ArithmeticTokenType.PLUS.equals(getTokenType());
	}
	
	public boolean isMinus() {
		return ArithmeticTokenType.MINUS.equals(getTokenType());
	}

	public boolean isTimes() {
		return ArithmeticTokenType.TIMES.equals(getTokenType());
	}

	public boolean isDiv() {
		return ArithmeticTokenType.DIV.equals(getTokenType());
	}
	
	public boolean isEOF() {
		return ArithmeticTokenType.EOF.equals(getTokenType());
	}
	
	public boolean isRightParen() {
		return ArithmeticTokenType.RPAREN.equals(getTokenType());
	}

	public boolean isLeftParen() {
		return ArithmeticTokenType.LPAREN.equals(getTokenType());
	}
}

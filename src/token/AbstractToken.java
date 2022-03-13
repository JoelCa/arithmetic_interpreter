package token;

abstract class AbstractToken {
	ITokenType myTokenType;
	Object myTokenValue;

	public AbstractToken(ITokenType tokenType) {
		this.myTokenType = tokenType;
		this.myTokenValue = null;
	}

	public AbstractToken(ITokenType tokenType, Object tokenValue) {
		this.myTokenType = tokenType;
		this.myTokenValue = tokenValue;
	}
	
	public ITokenType getTokenType() {
		return myTokenType;
	}
	
	public Object getTokenValue() {
		return myTokenValue;
	}
}

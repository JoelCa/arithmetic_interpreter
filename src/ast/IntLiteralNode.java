package ast;

import evaluator.IArithmeticEvaluatorVisitor;

public class IntLiteralNode extends AbstractArithmeticNode {
	int myIntValue;

	public IntLiteralNode(int intValue) {
		this.myIntValue = intValue;
	}
	
	public int getValue() {
		return myIntValue;
	}

	@Override
	public Integer accept(IArithmeticEvaluatorVisitor<Integer> visitor) {
		return visitor.visit(this);
	}
}

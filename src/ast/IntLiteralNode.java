package ast;

import evaluator.EvaluatorVisitor;
import evaluator.IEvaluatorVisitor;

public class IntLiteralNode implements IArithmeticNode {
	int myIntValue;

	public IntLiteralNode(int intValue) {
		this.myIntValue = intValue;
	}
	
	public int getValue() {
		return myIntValue;
	}

	@Override
	public int accept(EvaluatorVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public int accept(IEvaluatorVisitor visitor) {
		return visitor.visit(this);
	}
}

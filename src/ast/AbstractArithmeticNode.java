package ast;

import evaluator.IArithmeticEvaluatorElement;
import evaluator.IArithmeticEvaluatorVisitor;

public abstract class AbstractArithmeticNode implements IArithmeticEvaluatorElement<Integer> {
	
	public AbstractArithmeticNode() {;}

	public Integer accept(IArithmeticEvaluatorVisitor<Integer> visitor) {
		return visitor.visit(this);
	}
}

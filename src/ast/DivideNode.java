package ast;

import evaluator.IArithmeticEvaluatorVisitor;

public class DivideNode extends BinaryNode {

    public DivideNode(AbstractArithmeticNode exp1, AbstractArithmeticNode exp2) {
        super(exp1, exp2);
    }

	@Override
	public Integer accept(IArithmeticEvaluatorVisitor<Integer> visitor) {
		return visitor.visit(this);
	}
}

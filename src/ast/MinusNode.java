package ast;

import evaluator.EvaluatorVisitor;
import evaluator.IEvaluatorVisitor;

public class MinusNode extends BinaryNode {
    public MinusNode(IArithmeticNode exp1, IArithmeticNode exp2) {
        super(exp1, exp2);
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

package ast;

import evaluator.IEvaluatorElement;
import evaluator.IEvaluatorVisitor;

public interface IArithmeticNode extends IEvaluatorElement {

    public int accept(IEvaluatorVisitor visitor);
}

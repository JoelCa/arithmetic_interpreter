package evaluator;

public interface IArithmeticEvaluatorElement<T> {
	public T accept(IArithmeticEvaluatorVisitor<T> visitor);
}

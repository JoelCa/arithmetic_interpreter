package evaluator;

import ast.AbstractArithmeticNode;
import ast.DivideNode;
import ast.IntLiteralNode;
import ast.MinusNode;
import ast.PlusNode;
import ast.TimesNode;

public class ArithmeticEvaluatorVisitor implements IArithmeticEvaluatorVisitor<Integer> {

	@Override
	public Integer visit(AbstractArithmeticNode node) {
		return node.accept(this);
	}

	@Override
	public Integer visit(IntLiteralNode node) {
		return node.getValue();
	}

	@Override
	public Integer visit(DivideNode node) {
		int left = node.getLeft().accept(this);
		int right = node.getRight().accept(this);
		return left / right;
	}

	@Override
	public Integer visit(PlusNode node) {
		int left = node.getLeft().accept(this);
		int right = node.getRight().accept(this);
		return left + right;
	}

	@Override
	public Integer visit(MinusNode node) {
		int left = node.getLeft().accept(this);
		int right = node.getRight().accept(this);
		return left - right;
	}

	@Override
	public Integer visit(TimesNode node) {
		int left = node.getLeft().accept(this);
		int right = node.getRight().accept(this);
		return left * right;
	}
}

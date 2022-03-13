package evaluator;

import ast.DivideNode;
import ast.IntLiteralNode;
import ast.MinusNode;
import ast.PlusNode;
import ast.TimesNode;

public class EvaluatorVisitor implements IEvaluatorVisitor {

	@Override
	public int visit(IntLiteralNode node) {
		return node.getValue();
	}

	@Override
	public int visit(DivideNode node) {
		int left = node.getLeft().accept(this);
		int right = node.getRight().accept(this);
		return left / right;
	}

	@Override
	public int visit(PlusNode node) {
		int left = node.getLeft().accept(this);
		int right = node.getRight().accept(this);
		return left + right;
	}

	@Override
	public int visit(MinusNode node) {
		int left = node.getLeft().accept(this);
		int right = node.getRight().accept(this);
		return left - right;
	}

	@Override
	public int visit(TimesNode node) {
		int left = node.getLeft().accept(this);
		int right = node.getRight().accept(this);
		return left * right;
	}
}

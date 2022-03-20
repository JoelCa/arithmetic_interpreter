package evaluator;

import ast.AbstractArithmeticNode;
import ast.DivideNode;
import ast.IntLiteralNode;
import ast.MinusNode;
import ast.PlusNode;
import ast.TimesNode;

public interface IArithmeticEvaluatorVisitor<T> {

	T visit(AbstractArithmeticNode node);

	T visit(IntLiteralNode node);

	T visit(DivideNode node);

	T visit(PlusNode node);

	T visit(MinusNode node);

	T visit(TimesNode node);
}

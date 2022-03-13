package evaluator;

import ast.DivideNode;
import ast.IntLiteralNode;
import ast.MinusNode;
import ast.PlusNode;
import ast.TimesNode;

public interface IEvaluatorVisitor {
	int visit(IntLiteralNode node);
	int visit(DivideNode node);
	int visit(PlusNode node);
	int visit(MinusNode node);
	int visit(TimesNode node);
}
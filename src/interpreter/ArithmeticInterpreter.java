package interpreter;

import ast.IArithmeticNode;
import ast.MinusNode;
import ast.PlusNode;
import ast.TimesNode;
import ast.DivideNode;
import ast.IntLiteralNode;
import evaluator.EvaluatorVisitor;
import evaluator.IEvaluatorVisitor;
import parser.Parser;

public class ArithmeticInterpreter {
	IEvaluatorVisitor evaluator;
	Parser parser;
	
	public ArithmeticInterpreter(Parser parser) {
		this.parser = parser;
		this.evaluator = new EvaluatorVisitor();
	}
	
	public int interpret(String text) throws Exception {
		IArithmeticNode tree = parser.parse(text);
		if (tree instanceof PlusNode plusNode)
			return evaluator.visit(plusNode);
		else if (tree instanceof MinusNode minusNode) {
			return evaluator.visit(minusNode);
		}
		else if (tree instanceof IntLiteralNode intNode) {
			return evaluator.visit(intNode);
		}
		else if (tree instanceof TimesNode prodNode) {
			return evaluator.visit(prodNode);
		}
		else if (tree instanceof DivideNode divNode) {
			return evaluator.visit(divNode);
		}
		else {
			throw new Error("no deberia pasar");
		}
	}
}

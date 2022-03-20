package interpreter;

import ast.AbstractArithmeticNode;
import evaluator.ArithmeticEvaluatorVisitor;
import evaluator.IArithmeticEvaluatorVisitor;
import parser.Parser;

public class ArithmeticInterpreter {
	IArithmeticEvaluatorVisitor<Integer> evaluator;
	Parser parser;
	
	public ArithmeticInterpreter(Parser parser) {
		this.parser = parser;
		this.evaluator = new ArithmeticEvaluatorVisitor();
	}
	
	public int interpret(String text) throws Exception {
		AbstractArithmeticNode tree = parser.parse(text);
		return evaluator.visit(tree);
	}
}

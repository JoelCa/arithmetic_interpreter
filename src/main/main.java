package main;

import java.util.Scanner;

import interpreter.ArithmeticInterpreter;
import lexer.Lexer;
import parser.Parser;

public class main {
	public static void main(String[] args) {
		ArithmeticInterpreter interpreter = createInterpreter();
		while (true) {
			String text = getInput();
			System.out.println("Ingrese una expresión algebraica");
			int result;
			try {
				result = interpreter.interpret(text);
				System.out.println("resultado: " + result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	private static ArithmeticInterpreter createInterpreter() {
		Lexer lexer = new Lexer();
		Parser parser = new Parser(lexer);
		ArithmeticInterpreter interpreter = new ArithmeticInterpreter(parser);
		return interpreter;
	}

	private static String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}

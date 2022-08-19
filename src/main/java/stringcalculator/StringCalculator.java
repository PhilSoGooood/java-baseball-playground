package stringcalculator;

import java.util.Scanner;

public class StringCalculator {

	public static void main(String[] args) {
		StringCalculator calculator = new StringCalculator();
		calculator.run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println(calculate(input));
		scanner.close();
	}

	public int calculate(String value) {
		String[] values = value.split(" ");
		int result = Integer.parseInt(values[0]);

		for (int i = 1; i < values.length - 1; i += 2) {
			String operator = values[i];
			int number = Integer.parseInt(values[i+1]);
			result = process(result, operator, number);
		}
		return result;
	}

	private int process(int x, String operator, int y) {
		if (operator.equals("+")) {
			return add(x, y);
		}
		if (operator.equals("-")) {
			return subtract(x, y);
		}
		if (operator.equals("*")) {
			return multiply(x, y);
		}
		return divide(x, y);
	}

	private int add(int x, int y) {
		return x + y;
	}

	private int subtract(int x, int y) {
		return x - y;
	}

	private int multiply(int x, int y) {
		return x * y;
	}

	private int divide(int x, int y) {
		return x / y;
	}
}

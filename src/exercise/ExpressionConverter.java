package exercise;

import java.util.Stack;

/**
 * date: 2024/5/8
 *
 * @author wmk
 * @version 1.0.0
 * @since 1.0.0
 */
public class ExpressionConverter {
    public static void main(String[] args) {
        String expression = "3 * ( ( 2 + 5 ) + 8 / ( 2 * 2 + 2 * 2 ) )";
        String simplifiedExpression = removeBrackets(expression);
        System.out.println("Simplified expression: " + simplifiedExpression);
    }

    public static String removeBrackets(String expression) {
        Stack<String> operatorStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                operatorStack.push("(");
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    result.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop(); // Remove the "("
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && priority(c) <= priority(operatorStack.peek().charAt(0))) {
                    result.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(String.valueOf(c));
            } else {
                result.append(c).append(" ");
            }
        }

        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static int priority(char operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }
}
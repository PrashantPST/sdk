import java.util.EmptyStackException;
import java.util.Stack;

public class ExpressionConversion {
    public static void main(String[] args) {
        String prefixExpr = "*-562";
        String infixExpr = "(A+B^C)*D+E^5";
        String postExpr = "23+79/-";

        System.out.println("====================================================");
        System.out.println("Infix Expression => "+prefixToInfix(prefixExpr.replaceAll("\\s", "")));
        System.out.println("Postfix Expression => "+prefixToPostfix(prefixExpr.replaceAll("\\s", "")));
        System.out.println("====================================================");
        System.out.println("Prefix Expression => "+infixToPrefix(infixExpr.replaceAll("\\s", "")));
        System.out.println("Postfix Expression => "+infixToPostfix(infixExpr.replaceAll("\\s", "")));
        System.out.println("====================================================");
        System.out.println("Prefix Expression => "+postfixToPrefix(postExpr.replaceAll("\\s", "")));
        System.out.println("Infix Expression => "+postfixToInfix(postExpr.replaceAll("\\s", "")));
        System.out.println("====================================================");

    }
    private static String prefixToInfix(String expr) {
        System.out.println("Prefix Expression => "+expr);
        try {
            Stack<String> infixExpr = new Stack<>();
            for (int i = expr.length() - 1; i >= 0; i--) {
                if (isOperator(expr.charAt(i))) {
                    String operand1 = infixExpr.pop();
                    String operand2 = infixExpr.pop();
                    infixExpr.push("(" + operand1 + " " + expr.charAt(i) + " " + operand2 + ")");
                } else
                    infixExpr.push(String.valueOf(expr.charAt(i)));
            }
            if(infixExpr.size() != 1) throw new InvalidInputExpression();
            return infixExpr.pop();
        }
        catch (EmptyStackException | InvalidInputExpression e) {
            return "INVALID PREFIX EXPRESSION";
        }
    }

    private static String prefixToPostfix(String expr) {
        try {
            Stack<String> postfixExpr = new Stack<>();
            for (int i = expr.length() - 1; i >= 0; i--) {
                if (isOperator(expr.charAt(i)))
                    postfixExpr.push(postfixExpr.pop() + postfixExpr.pop() + expr.charAt(i));
                else
                    postfixExpr.push(String.valueOf(expr.charAt(i)));
            }
            if(postfixExpr.size() != 1) throw new InvalidInputExpression();
            return postfixExpr.pop();
        }
        catch (EmptyStackException | InvalidInputExpression e) {
            return "INVALID PREFIX EXPRESSION";
        }
    }
    private static StringBuilder infixToPrefix(String infixExpr) {
        System.out.println("Infix Expression = "+infixExpr);
        StringBuilder sb = new StringBuilder(infixExpr).reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')')
                sb.setCharAt(i, '(');
        }
        return new StringBuilder(infixToPostfix(sb.toString())).reverse();
    }
    private static String infixToPostfix(String infixExpr) {
            Stack<Character> operator = new Stack<>();
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < infixExpr.length(); i++) {
                char ch = infixExpr.charAt(i);
                if (Character.isLetterOrDigit(ch))
                    result.append(ch);
                else if (ch == '(')
                    operator.push(ch);
                else if (ch == ')') {
                    while (!operator.isEmpty() && operator.peek() != '(')
                        result.append(operator.pop());
                    if (operator.isEmpty() || operator.peek() != '(')
                        return "Invalid Infix Expression";
                    else
                        operator.pop();
                } else {
                    while (!operator.isEmpty() && precedence(ch) <= precedence(operator.peek())) {
                        if (operator.peek() == '(')
                            return "Invalid Infix Expression";
                        result.append(operator.pop());
                    }
                    operator.push(ch);
                }
            }
            while(!operator.isEmpty())
                result.append(operator.pop());
                return result.toString();
    }
    private static String postfixToPrefix(String expr) {
        System.out.println("Postfix Expression => "+expr);
        Stack<String> prefixExpr = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            if (isOperator(expr.charAt(i))) {
                String operand2 = prefixExpr.pop();
                String operand1 = prefixExpr.pop();
                prefixExpr.push(expr.charAt(i) + operand1 + operand2);
            }
            else
                prefixExpr.push(String.valueOf(expr.charAt(i)));
        }
        return prefixExpr.pop();
    }
    private static String postfixToInfix(String expr) {
            Stack<String> infixExpr = new Stack<>();
            for (int i = 0; i < expr.length(); i++) {
                if (isOperator(expr.charAt(i))) {
                    String operand2 = infixExpr.pop();
                    String operand1 = infixExpr.pop();
                    infixExpr.push("(" + operand1 + " " + expr.charAt(i) + " " + operand2 + ")");
                } else
                    infixExpr.push(String.valueOf(expr.charAt(i)));
            }
            return infixExpr.pop();
    }

    private static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    }

    private static class InvalidInputExpression extends Throwable {
    }
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}

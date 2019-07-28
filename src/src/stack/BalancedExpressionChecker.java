package stack;

import java.util.Stack;

public class BalancedExpressionChecker {
    public static void main(String[] args) {
        String expr = "{()}}]}";
        if (balanced(expr.toCharArray()))
            System.out.println("Balanced Expression");
        else
            System.out.println("Unbalanced Expression");
    }

    private static boolean balanced(char[] exp) {
        Stack<Character> stack= new Stack<>();
        for (char ch: exp) {
            if (ch == '{' || ch == '(' || ch == '[')
                stack.push(ch);
            if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty())
                    return false;
                else if (!matchingPair(stack.pop(), ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    private static boolean matchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else return character1 == '[' && character2 == ']';
    }
}

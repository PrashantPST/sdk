package stack;

import java.util.Stack;

public class BalancedExpressionChecker {
    public static void main(String[] args) {
        char[] exp = {'{', '(', ')', '}', '}', ']'};
        if (areParenthesisBalanced(exp))
            System.out.println("Balanced ");
        else
            System.out.println("UnBalanced ");
    }

    private static boolean areParenthesisBalanced(char[] exp) {
        Stack<Character> st = new Stack<>();
        for (char c : exp) {
            if (c == '{' || c == '(' || c == '[')
                st.push(c);
            if (c == '}' || c == ')' || c == ']') {
                if (st.isEmpty())
                    return false;
                else if (!isMatchingPair(st.pop(), c))
                    return false;
            }
        }
        return st.isEmpty();
    }
    private static boolean isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else return character1 == '[' && character2 == ']';
    }
}

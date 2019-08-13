package datastructures.linear.stack;

import java.util.Stack;

public class StackADT {

    private static boolean balanced(char[] exp) {
        Stack<Character> stack= new Stack<>();
        for (char ch: exp) {
            if (ch == '{' || ch == '(' || ch == '[')
                stack.push(ch);
            if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty())
                    return false;
                else if (!_matchingPair(stack.pop(), ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    private static boolean _matchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else return character1 == '[' && character2 == ']';
    }
}

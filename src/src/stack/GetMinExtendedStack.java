package stack;

/*
 * Design a Data Structure GetMinExtendedStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation min() which should return the minimum element.
 * All these operations must be O(1).
 */

import java.util.Stack;

class GetMinExtendedStack extends Stack<Integer> {
    private static int MIN_VALUE = Integer.MAX_VALUE;
    private static Stack<Integer> extendedStack = new Stack<>();
    private static void extendedPush(Integer item) {
        if(item >= MIN_VALUE)
            extendedStack.push(item);
        else {
            extendedStack.push(2 * item - MIN_VALUE);
            MIN_VALUE = item;
        }
    }
    private static void extendedPop() {
        int top = extendedStack.pop();
        if(top < MIN_VALUE)
            MIN_VALUE = 2 * MIN_VALUE - top;
    }
    private static Integer min() {
        return MIN_VALUE;
    }

    public static void main(String[] args) {
        extendedPush(5);
        extendedPush(13);
        extendedPush(2);
        extendedPush(5);
        System.out.println(min());
        extendedPop();
        extendedPop();
        System.out.println(min());
        extendedPush(1);
        extendedPop();
        System.out.println(min());
        extendedPop();
        extendedPop();

    }
}

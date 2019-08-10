package ds.linear.stack;

/*
 * Design a Data Structure GetMaxExtendedStack that supports all the linear.stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation max() which should return the minimum element.
 * All these operations must be O(1).
 */

import java.util.Stack;

class GetMaxExtendedStack extends Stack<Integer> {
    private static int MAX_VALUE = Integer.MIN_VALUE;
    private static Stack<Integer> extendedStack = new Stack<>();
    private static void extendedPush(Integer item) {
        if (item <= MAX_VALUE)
            extendedStack.push(item);
        else {
            extendedStack.push(2 * item + MAX_VALUE);
            MAX_VALUE = item;
        }
    }
    private static void  extendedPop() {
        int top = extendedStack.pop();
        if (top > MAX_VALUE)
            MAX_VALUE = top - 2 * MAX_VALUE;
    }
    private static Integer max() {
        return MAX_VALUE;
    }

    public static void main(String[] args) {
        extendedPush(3);
        extendedPush(5);
        System.out.print(max()+" ");
        extendedPush(2);
        extendedPush(11);
        System.out.print(max()+" ");
        extendedPop();
        System.out.print(max()+" ");
        extendedPop();
        extendedPop();
        System.out.print(max()+" ");
        extendedPop();
        extendedPush(12);
        extendedPush(2);
        extendedPush(23);
        System.out.print(max()+" ");
        extendedPop();
        System.out.print(max()+" ");
        System.out.println();
    }
}

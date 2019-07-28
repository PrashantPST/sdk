package stack;

/*
 * Design a Data Structure GetMaxExtendedStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation max() which should return the minimum element.
 * All these operations must be O(1).
 */

import java.util.Stack;

class GetMaxExtendedStack extends Stack<Integer> {
    private static void extendedPush(Integer item) {

    }
    private static void  extendedPop() {

    }
    private static Integer max() {
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        extendedPush(3);
        extendedPush(5);
        System.out.println(max());
        extendedPush(2);
        extendedPush(1);
        System.out.println(max());
        extendedPop();
        System.out.println(max());
        extendedPop();
    }
}

package stack;

/*
 * Design a Data Structure GetMinExtendedStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation min() which should return the minimum element.
 * All these operations must be O(1).
 */

import java.util.Stack;

class GetMinExtendedStack extends Stack<Integer> {
    private static void extendedPush(Integer item) {
        
    }
    private static void  extendedPop() {

    }
    private static Integer min() {
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        extendedPush(3);
        extendedPush(5);
        System.out.println(min());
        extendedPush(2);
        extendedPush(1);
        System.out.println(min());
        extendedPop();
        System.out.println(min());
        extendedPop();
    }
}

package stack;

/*
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation getMin() which should return minimum element.
 * All these operations of SpecialStack must be O(1).
 */

import java.util.Stack;

class SpecialStack extends Stack<Integer> {
    private Stack<Integer> min = new Stack<>();
    private void push(int x) {
        if(isEmpty()) {
            super.push(x);
            min.push(x);
        }
        else {
            super.push(x);
            int y = min.peek();
            min.push(x < y ? x : y);
        }
    }
    public Integer pop() {
        min.pop();
        return super.pop();
    }
    private int getMin() {
        return min.peek();
    }
    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
        s.pop();
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        s.push(34);
        System.out.println(s.getMin());
        s.pop();
    }
}

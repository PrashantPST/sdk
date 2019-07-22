package stack;

/*
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation getMin() which should return minimum element.
 * All these operations of SpecialStack must be O(1).
 */

import java.util.EmptyStackException;
import java.util.Stack;

class SpecialStack extends Stack<Integer> {
    private Stack<Integer> min = new Stack<>();
    private void push(int x) {
        super.push(x);
        if(min.isEmpty())
            min.push(x);
        else {
            int y = min.peek();
            if(x <= y)
                min.push(x);
        }
    }
    public Integer pop() {
        if(isEmpty())
            throw new EmptyStackException();
        Integer a = peek();
        if(a <= min.peek())
            min.pop();
        return super.pop();
    }
    private int getMin() { return min.peek(); }

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
        s.push(12);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        s.push(34);
        System.out.println(s.getMin());
        s.pop();
    }
}

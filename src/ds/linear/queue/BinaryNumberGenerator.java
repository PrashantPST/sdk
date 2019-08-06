package ds.linear.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {
    public static void main(String[] args) {
        int n = 7;
        generate(n);
        System.out.println();
    }
    private static void generate(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-- > 0) {
            String s1 = q.remove();
            System.out.print(s1+" ");
            q.add(s1 + "0");
            q.add(s1 + "1");
        }
    }
}
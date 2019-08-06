package ds.non_linear.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {
    private int data;
    private Node left;
    private Node right;

    Node(int val) {
        this.data = val;
    }
    private static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    private void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return;
        int levelNodes;
        q.add(root);
        while (!q.isEmpty()) {
            levelNodes = q.size();
            while (levelNodes-- > 0) {
                Node n = q.remove();
                System.out.print(" " + n.data);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            System.out.println();
        }
    }
    public static void spiralTraversal(Node root) {
        if (root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);

        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                Node temp = s1.pop();
                System.out.print(temp.data + " ");

                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }
            while (!s2.empty()) {
                Node temp = s2.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }
    private static boolean identical(Node p, Node q) {
        if (p == null && q == null) { return true; }
        return ((p != null && q != null) && p.data == q.data && identical(p.left, q.left) && identical(p.right, q.right));
    }
    private static boolean isBalanced(Node root) {
        if(root == null) return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1) { return false; }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
}

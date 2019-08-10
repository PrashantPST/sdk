package ds.nonlinear.tree;

/*
 * @author Prashant
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    private int data;
    public TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.data = val;
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        return (1 + Math.max(height(root.left), height(root.right)));
    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    private void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return;
        int levelNodes;
        q.add(root);
        while (!q.isEmpty()) {
            levelNodes = q.size();
            while (levelNodes-- > 0) {
                TreeNode n = q.remove();
                System.out.print(" " + n.data);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            System.out.println();
        }
    }
    public static void spiralOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                TreeNode temp = s1.pop();
                System.out.print(temp.data + " ");

                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }
            while (!s2.empty()) {
                TreeNode temp = s2.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }
    private static boolean identical(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        return ((p != null && q != null) && p.data == q.data && identical(p.left, q.left) && identical(p.right, q.right));
    }
    private static int balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = balanced(root.left);
        System.out.println("left height = "+lHeight);
        if (lHeight == -1) {
            return -1;
        }
        int rHeight = balanced(root.right);
        System.out.println("right height = "+rHeight);
        if (rHeight == -1) {
            return -1;
        }
        if (Math.abs(lHeight - rHeight) > 1)
            return -1;
        return Math.max(lHeight, rHeight) + 1;
    }
    public static boolean isBalanced(TreeNode root) {
        return balanced(root) > -1;
    }

    private static void topView(TreeNode root) {

    }
    private static void bottomView(TreeNode root) {

    }
    private static void leftView(TreeNode root) {

    }
    private static void rightView(TreeNode root) {

    }
}

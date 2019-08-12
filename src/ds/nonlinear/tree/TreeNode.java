package ds.nonlinear.tree;

/*
 * @author Prashant
 */

import java.util.*;

public class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
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

    public static void verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> horizontalDistances = _verticalOrder(root, 0);
        if (horizontalDistances != null) {
            horizontalDistances.forEach((k, v) -> System.out.println("Nodes at distance " + k + " = " + v));
        }
    }

    private static TreeMap<Integer, List<Integer>> _verticalOrder(TreeNode root, int hd) {
        if (null == root)
            return null;

    }

    private static boolean identical(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        return ((p != null && q != null) && p.data == q.data && identical(p.left, q.left) && identical(p.right, q.right));
    }

    private static int _balanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = _balanced(root.left);
        System.out.println("left height = "+lHeight);
        if (lHeight == -1) {
            return -1;
        }
        int rHeight = _balanced(root.right);
        System.out.println("right height = "+rHeight);
        if (rHeight == -1) {
            return -1;
        }
        if (Math.abs(lHeight - rHeight) > 1)
            return -1;
        return Math.max(lHeight, rHeight) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        return _balanced(root) > -1;
    }

    public static void topView(TreeNode root) {

    }

    private static void bottomView(TreeNode root) {

    }

    private static void leftView(TreeNode root) {

    }

    private static void rightView(TreeNode root) {

    }

    private static boolean isValidBST(TreeNode root) {
        return false;
    }
    private static void leastCommonAncestor(TreeNode root) {

    }
    private static int verticalOrderSum(TreeNode root) {
        int sum = 0;
        return sum;
    }
}

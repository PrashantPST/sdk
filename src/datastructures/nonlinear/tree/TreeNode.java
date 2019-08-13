package datastructures.nonlinear.tree;

/*
 * @author Prashant
 */

import java.util.*;

class _ExtendedTree {
    TreeNode node;
    int hd;

    _ExtendedTree(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

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

    public static void levelOrder(TreeNode root) {
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

    public static void spiralTraversal(TreeNode root) {
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

    private static Map<Integer, List<Integer>> verticalTraversal(TreeNode root) {
        Queue<_ExtendedTree> q = new LinkedList<>();
        Map<Integer, List<Integer>> verticalView = new TreeMap<>();

        if (root == null) {
            return verticalView;
        } else {
            q.add(new _ExtendedTree(root, 0));
        }

        while (!q.isEmpty()) {
            _ExtendedTree tmpNode = q.poll();
            if (!verticalView.containsKey(tmpNode.hd)) {
                List<Integer> l = new ArrayList<>();
                l.add(tmpNode.node.data);
                verticalView.put(tmpNode.hd, l);
            }
            else {
                verticalView.get(tmpNode.hd).add(tmpNode.node.data);
            }
            if (tmpNode.node.left != null) {
                q.add(new _ExtendedTree(tmpNode.node.left, tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new _ExtendedTree(tmpNode.node.right, tmpNode.hd + 1));
            }

        }
        return verticalView;
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
        if (lHeight == -1) {
            return -1;
        }
        int rHeight = _balanced(root.right);
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

    public static List<Integer> topView(TreeNode root) {
        Map<Integer, List<Integer>> verticalView = verticalTraversal(root);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> m: verticalView.entrySet()) {
            List<Integer> temp = m.getValue();
            res.add(temp.get(0));
        }
        return res;
    }

    public static List<Integer> bottomView(TreeNode root) {
        Map<Integer, List<Integer>> verticalView = verticalTraversal(root);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> m: verticalView.entrySet()) {
            List<Integer> temp = m.getValue();
            res.add(temp.get(temp.size() - 1));
        }
        return res;
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        if(root == null) return res;
        int levelNodes;
        boolean flag;
        while (!queue.isEmpty()) {
            flag = true;
            levelNodes = queue.size();
            while (levelNodes-- > 0) {
                TreeNode curr = queue.poll();
                if (flag)
                    res.add(curr.data);
                flag = false;
                if (null != curr) {
                    if (curr.left != null) queue.add(curr.left);
                    if (curr.right != null) queue.add(curr.right);
                }
            }
        }
        return res;
    }

    public static List<Integer> rightView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int queueSize = q.size();
            while(queueSize > 0) {
                TreeNode current = q.poll();
                if (current != null) {
                    if (queueSize == 1)
                        res.add(current.data);
                    if (current.left != null) {
                        q.add(current.left);
                    }
                    if (current.right != null) {
                        q.add(current.right);
                    }
                    queueSize--;
                }
            }
        }
        return res;
    }

    // lowest common ancestor is also known as the least common ancestor.
    public static TreeNode lowestCommonAncestor(TreeNode root, int v, int w) {

    }

    private static int verticalOrderSum(TreeNode root) {
        return 0;
    }
}

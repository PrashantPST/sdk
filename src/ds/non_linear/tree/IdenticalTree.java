package src.ds.non_linear.tree;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.value = val;
    }
}

public class IdenticalTree {
    public static void main(String[] args) {
        // construct first tree
        TreeNode x = new TreeNode(15);
        x.left = new TreeNode(10);
        x.right = new TreeNode(20);
        x.left.left = new TreeNode(8);
        x.left.right = new TreeNode(12);
        x.right.left = new TreeNode(16);
        x.right.right = new TreeNode(25);

        // construct second tree
        TreeNode y = new TreeNode(15);
        y.left = new TreeNode(10);
        y.right = new TreeNode(20);
        y.left.left = new TreeNode(8);
        y.left.right = new TreeNode(12);
        y.right.left = new TreeNode(16);
        y.right.right = new TreeNode(25);

        if (identicalTree(x, y)) {
            System.out.println("Given binary Trees are identical");
        } else {
            System.out.println("Given binary Trees are not identical");
        }
    }

    private static boolean identicalTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        return ((p != null && q != null) && p.value == q.value && identicalTree(p.left, q.left) && identicalTree(p.right, q.right));
    }
}

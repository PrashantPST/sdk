import ds.nonlinear.tree.TreeNode;
import static ds.nonlinear.tree.TreeNode.isBalanced;

public class Runner {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1   = new TreeNode(1);
        TreeNode n2   = new TreeNode(2);
        TreeNode n3   = new TreeNode(3);
        TreeNode n4   = new TreeNode(4);
        TreeNode n5   = new TreeNode(5);

        root.left  = n1;
        n1.left  = n2;
        n2.left  = n3;
        n3.left = n4;
        n4.left = n5;
        System.out.println(isBalanced(root));
    }
}

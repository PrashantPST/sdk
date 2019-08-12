import ds.nonlinear.tree.TreeNode;

import static ds.nonlinear.tree.TreeNode.*;

public class Runner {
    public static void main(String[] args) {
        TreeNode root   = new TreeNode(1);
        TreeNode n2   = new TreeNode(2);
        TreeNode n3   = new TreeNode(3);
        TreeNode n4   = new TreeNode(4);
        TreeNode n5   = new TreeNode(5);
        TreeNode n6   = new TreeNode(6);
        TreeNode n7   = new TreeNode(7);
        TreeNode n8   = new TreeNode(8);
        TreeNode n9   = new TreeNode(9);
        TreeNode n10   = new TreeNode(10);
        TreeNode n11   = new TreeNode(11);
        TreeNode n12   = new TreeNode(12);

        root.left  = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n6.right = n8;
        n7.right = n9;
        n8.right = n10;
        n10.right = n11;
        n11.right = n12;

        System.out.println(verticalTraversal(root));
        System.out.println(topView(root));
        System.out.println(bottomView(root));
    }
}

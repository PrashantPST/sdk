package datastructures.nonlinear.tree;

import java.util.ArrayList;
import java.util.List;

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
        TreeNode n13   = new TreeNode(13);
        TreeNode n14   = new TreeNode(14);
        TreeNode n15   = new TreeNode(15);
        TreeNode n16   = new TreeNode(16);
        TreeNode n17   = new TreeNode(17);


        root.left  = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.right = n16;
        n16.right = n17;
        n3.left = n6;
        n3.right = n7;
        n6.right = n8;
        n7.right = n9;
        n8.right = n10;
        n10.right = n11;
        n11.right = n12;
        n9.left = n14;
        n9.right = n13;
        n13.right = n15;

        List<Integer> preorderTraversal = root.preorderTraversal(root, new ArrayList<>());
        List<Integer> inorderTraversal = root.inorderTraversal(root, new ArrayList<>());
        List<Integer> postorderTraversal = root.postorderTraversal(root, new ArrayList<>());

        System.out.println(preorderTraversal);
        System.out.println(inorderTraversal);
        System.out.println(postorderTraversal);
    }
}

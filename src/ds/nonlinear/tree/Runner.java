package ds.nonlinear.tree;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        BinaryTree root   = new BinaryTree(1);

        BinaryTree n2   = new BinaryTree(2);
        BinaryTree n3   = new BinaryTree(3);
        BinaryTree n4   = new BinaryTree(4);
        BinaryTree n5   = new BinaryTree(5);
        BinaryTree n6   = new BinaryTree(6);
        BinaryTree n7   = new BinaryTree(7);
        BinaryTree n8   = new BinaryTree(8);
        BinaryTree n9   = new BinaryTree(9);
        BinaryTree n10   = new BinaryTree(10);
        BinaryTree n11   = new BinaryTree(11);
        BinaryTree n12   = new BinaryTree(12);
        BinaryTree n13   = new BinaryTree(13);
        BinaryTree n14   = new BinaryTree(14);
        BinaryTree n15   = new BinaryTree(15);
        BinaryTree n16   = new BinaryTree(16);
        BinaryTree n17   = new BinaryTree(17);


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

        int[] nums = { 8, 2, 4, 3, 8, 7, 6, 5 };
        System.out.println(Arrays.toString(BinarySearchTree.countSmaller(nums)));
    }
}

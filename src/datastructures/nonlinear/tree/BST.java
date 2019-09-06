package datastructures.nonlinear.tree;


import java.util.SortedSet;
import java.util.TreeSet;

public class BST {
    private int data;
    private BST left;
    private BST right;

    private BST(int val) {
        data = val;
        left = null;
        right = null;
    }

    public static BST lowestCommonAncestor(BST root, BST p, BST q) {
        while (root != null) {
            if (p.data < root.data && q.data < root.data)
                root = root.left;
            else if (root.data < p.data && root.data < q.data)
                root = root.right;
            else break;
        }
        return root;
    }

    // Get minimum element in binary search tree
    private static BST minimumElement(BST root) {
        if (root.left == null)
            return root;
        BST min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    private BST insertNode(BST root, int key) {
        // if the root is null, create a new node an return it
        if (root == null) {
            return new BST(key);
        }

        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insertNode(root.left, key);
        }

        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    private BST deleteNode(BST root, int key) {
        if (root == null)
            return null;

        if (root.data > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.data < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;

        // current node have both left and right subtree.
        else {
            BST successorParent = root;
            BST successor = root.right;
            if (successor.left == null) {
                root.data = successor.data;
                successorParent.right = successor.right;
                return root;
            }
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            root.data = successor.data;
            successorParent.left = successor.right;
            return root;
        }
    }

    /**
     * @param nums integer array
     * @return a count array where count[i] is the number of smaller elements to the right of nums[i]
     */
    static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[nums.length];
        SortedSet<Integer> set = new TreeSet<>();
        for (int index = n - 1; index >= 0; index--) {
            set.add(nums[index]);
            count[index] = set.headSet(nums[index]).size();
        }
        return count;
    }

    private boolean isValidBST(BST root) {
        return false;
    }
}

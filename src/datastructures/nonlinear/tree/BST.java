package datastructures.nonlinear.tree;


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
        BST curr = root;
        BST parent = null;

        if (root == null) {
            return new BST(key);
        }

        while (curr != null) {
            parent = curr;

            if (key < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (key < parent.data) {
            parent.left = new BST(key);
        } else {
            parent.right = new BST(key);
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

    private boolean isValidBST(BST root) {

    }
}

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

    private BST insert(BST root, int key) {
        BST curr = root;
        BST parent = null;

        if (root == null) {
            return new BST(key);
        }

        while (curr != null) {
            parent = curr;

            if (key < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        if (key < parent.data) {
            parent.left = new BST(key);
        }
        else {
            parent.right = new BST(key);
        }
        return root;
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

    private boolean isValidBST(BST root) {

    }

    private BST inorderPredecessor(BST root) {

    }

    private BST inorderSuccessor(BST root) {

    }
}

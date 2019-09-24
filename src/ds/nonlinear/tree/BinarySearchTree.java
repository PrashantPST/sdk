package ds.nonlinear.tree;


import java.util.SortedSet;
import java.util.TreeSet;

public class BinarySearchTree {
    private int data;
    private BinarySearchTree left;
    private BinarySearchTree right;

    private BinarySearchTree(int val) {
        data = val;
        left = null;
        right = null;
    }

    public static BinarySearchTree lowestCommonAncestor(BinarySearchTree root, BinarySearchTree p, BinarySearchTree q) {
        while (root != null) {
            if (p.data < root.data && q.data < root.data) {
                root = root.left;
            } else if (root.data < p.data && root.data < q.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    // Get minimum element in binary search tree
    private static BinarySearchTree minimumElement(BinarySearchTree root) {
        if (root.left == null)
            return root;
        BinarySearchTree min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
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

    private BinarySearchTree insertNode(BinarySearchTree root, int key) {
        if (root == null) {
            return new BinarySearchTree(key);
        }
        if (key < root.data) {
            root.left = insertNode(root.left, key);
        }
        else {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    private BinarySearchTree deleteNode(BinarySearchTree root, int key) {
        if (root == null)
            return null;

        if (key < root.data) {
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
            BinarySearchTree successorParent = root;
            BinarySearchTree successor = root.right;
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

    private boolean isBinarySearchTree(BinarySearchTree root) {
        return _bstChecker(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean _bstChecker(BinarySearchTree root, long min, long max) {
        if (root == null) {
            return true;
        }
        if ((long) root.data < min || (long) root.data > max) {
            return false;
        }
        return _bstChecker(root.left, min, (long) root.data - 1) && _bstChecker(root.right, (long) root.data + 1, max);
    }

    private BinarySearchTree floor(BinarySearchTree root, int key) {
        if (root == null) {
            return root;
        }
        BinarySearchTree floor;
        if (root.data == key) {
            floor = root;
        } else if (root.data < key) {
            floor = floor(root.right, key);
            if (floor == null) {
                floor = root;
            }
        } else {
            floor = floor(root.left, key);
        }
        return floor;
    }

    private BinarySearchTree ceil(BinarySearchTree root, int key) {
        if (root == null)
            return root;
        if (root.data == key) {
            return root;
        }
        BinarySearchTree ceil;
        if (key < root.data) {
            ceil = ceil(root.left, key);
            if (ceil == null) {
                ceil = root;
            }
        }
        else {
            ceil = ceil(root.right, key);
        }
        return ceil;
    }
}

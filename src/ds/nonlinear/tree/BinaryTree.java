package ds.nonlinear.tree;

import java.util.*;
import java.util.stream.IntStream;

public class BinaryTree {
    private int data;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int val) {
        data = val;
        left = null;
        right = null;
    }

    private static int _d = 0;
    private static int _preOrderIndex = 0;
    private static int _postOrderIndex = -1;
    private static int _maxSum;
    private static int _maxAncestorDiff;

    /**
     * @return height/depth Time Complexity: O(n)
     */
    private int height(BinaryTree root) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /*
     * Diameter of tree is defined as a longest path/route between any two s in a tree.
     * The path may or may not pqss through the root.
     * The length of path between two s is represented by the number of edges between them.
     */
    public int diameter(BinaryTree root) {
        _diameter(root);
        int temp = _d;
        _d = 0;
        return temp;
    }

    private static int _diameter(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        int lHeight = _diameter(root.left);
        int rHeight = _diameter(root.right);
        _d = Math.max(_d, (lHeight + rHeight + 1));
        return 1 + Math.max(lHeight, rHeight);
    }

    /**
     * DFS of a tree can be attained by either of (preorder, inorder, postorder) traversal
     * The inorder traversal of a BST produces the elements in sorted (non-decreasing) order.
     */
    static List<Integer> preorderTraversal(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree> stack = new Stack<>();

        if (root == null) {
            return result;
        }
        stack.push(root);

        while (!stack.empty()) {
            BinaryTree node = stack.pop();
            result.add(node.data);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    static List<Integer> inorderTraversal(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree> stack = new Stack<>();

        if (root == null) {
            return result;
        }
        while(root != null) {
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()) {
            BinaryTree t = stack.pop();
            result.add(t.data);

            t = t.right;
            while(t != null) {
                stack.push(t);
                t = t.left;
            }
        }
        return result;
    }

    static List<Integer>  postorderTraversal(BinaryTree root, List<Integer> result) {
        if (root != null) {
            postorderTraversal(root.left, result);
            postorderTraversal(root.right, result);
            result.add(root.data);
        }
        return result;
    }

    /*
     * You can perform a BFS on a tree using a level order traversal.
     */
    List<List<Integer>> levelOrderTraversal(BinaryTree root) {
        Queue<BinaryTree> q = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();

        if (root == null) return traversal;
        int levelNodes;
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            levelNodes = q.size();
            while (levelNodes-- > 0) {
                BinaryTree current = q.remove();
                temp.add(current.data);
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            traversal.add(temp);
        }
        return traversal;
    }

    public void spiralorder(BinaryTree root) {
        if (root == null)
            return;

        Stack<BinaryTree> s1 = new Stack<>();
        Stack<BinaryTree> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                BinaryTree temp = s1.pop();
                System.out.print(temp.data + " ");

                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }
            while (!s2.empty()) {
                BinaryTree temp = s2.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }

    private Map<Integer, List<Integer>> verticalorder(BinaryTree root) {
        class _VerticalInfo {
            private BinaryTree node;
            private int horizontalDistance;

            private _VerticalInfo(BinaryTree node, int horizontalDistance) {
                this.node = node;
                this.horizontalDistance = horizontalDistance;
            }
        }
        Queue<_VerticalInfo> q = new LinkedList<>();
        Map<Integer, List<Integer>> verticalView = new TreeMap<>();

        if (root == null) {
            return verticalView;
        } else {
            q.add(new _VerticalInfo(root, 0));
        }

        while (!q.isEmpty()) {
            _VerticalInfo current = q.poll();
            if (!verticalView.containsKey(current.horizontalDistance)) {
                verticalView.put(current.horizontalDistance, new ArrayList<>());
            }
            verticalView.get(current.horizontalDistance).add(current.node.data);
            if (current.node.left != null) {
                q.add(new _VerticalInfo(current.node.left, current.horizontalDistance - 1));
            }
            if (current.node.right != null) {
                q.add(new _VerticalInfo(current.node.right, current.horizontalDistance + 1));
            }
        }
        return verticalView;
    }

    private static boolean identical(BinaryTree p, BinaryTree q) {
        // If both are NULL, then Identical
        if (p == null && q == null)
            return true;
        // If only one tree is NULL, then not Identical
        if (p == null || q == null)
            return false;
        return p.data == q.data && identical(p.left, q.left) && identical(p.right, q.right);
    }

    public static boolean isBalanced(BinaryTree root) {
        return _balanced(root) > -1;
    }

    private static int _balanced(BinaryTree root) {
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

    public List<Integer> topView(BinaryTree root) {
        Map<Integer, List<Integer>> verticalView = verticalorder(root);
        List<Integer> res = new ArrayList<>();
        verticalView.forEach((key, value) -> res.add(value.get(0)));
        return res;
    }

    public List<Integer> bottomView(BinaryTree root) {
        Map<Integer, List<Integer>> verticalView = verticalorder(root);
        List<Integer> result = new ArrayList<>();
        verticalView.forEach((key, value) -> result.add(value.get(value.size() - 1)));
        return result;
    }

    public static List<Integer> leftView(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        if (root == null) return res;
        int levelNodes;
        boolean flag;
        while (!queue.isEmpty()) {
            flag = true;
            levelNodes = queue.size();
            while (levelNodes-- > 0) {
                BinaryTree curr = queue.poll();
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

    public static List<Integer> rightView(BinaryTree root) {
        Queue<BinaryTree> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int queueSize = q.size();
            while (queueSize > 0) {
                BinaryTree current = q.poll();
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

    private static BinaryTree lowestCommonAncestor(BinaryTree root, BinaryTree p, BinaryTree q) {

        if (root == null) return root;
        if (root.data == p.data || root.data == q.data) return root;

        BinaryTree leftSearchResult = lowestCommonAncestor(root.left, p, q);
        BinaryTree rightSearchResult = lowestCommonAncestor(root.right, p, q);

        if (leftSearchResult == null) return rightSearchResult;
        if (rightSearchResult == null) return leftSearchResult;
        return root;
    }

    /*
     * O(n) solution to construct binary tree from its parent array representation.
     */
    static BinaryTree createTreeFromParentArray(int[] parent) {
        Map<Integer, BinaryTree> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            map.put(i, new BinaryTree(i));
        }
        BinaryTree root = null;

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                root = map.get(i);
            }
            else {
                BinaryTree ptr = map.get(parent[i]);
                if (ptr.left != null) {
                    ptr.right = map.get(i);
                }
                else {
                    ptr.left = map.get(i);
                }
            }
        }
        return root;
    }

    /*
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * @param preorder preorder traversal of tree
     * @param inorder inorder traversal of tree
     * @return root of the constructed tree
     */
    static BinaryTree buildTreeFromPreorderAndInorder(int[] preorder, int[] inorder) {
        BinaryTree root = _makeBTreev1(preorder, inorder, 0, preorder.length - 1);
        _preOrderIndex = 0;
        return root;
    }

    private static BinaryTree _makeBTreev1(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) {
            return null;
        }
        BinaryTree root = new BinaryTree(preorder[_preOrderIndex++]);

        if(start == end) {
            return root;
        }

        int index = _getInorderIndex(inorder, start, end, root.data);
        root.left = _makeBTreev1(preorder, inorder, start, index-1);
        root.right = _makeBTreev1(preorder, inorder, index+1, end);
        return root;
    }

    /*
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     */
    static BinaryTree buildTreeFromInorderAndPostorder(int[] inorder, int[] postorder) {
        _postOrderIndex = postorder.length - 1;
        return _makeBTreev2(inorder, postorder, 0, postorder.length - 1);
    }

    private static BinaryTree _makeBTreev2(int[] inorder, int[] postorder, int start, int end) {
        if(start > end) {
            return null;
        }
        BinaryTree root = new BinaryTree(postorder[_postOrderIndex--]);

        if(start == end) {
            return root;
        }

        int index = _getInorderIndex(inorder, start, end, root.data);
        root.right = _makeBTreev2(inorder, postorder, index + 1, end);
        root.left = _makeBTreev2(inorder, postorder, start, index - 1);
        return root;
    }

    private static int _getInorderIndex(int[] inOrder, int start, int end, int target) {
        return IntStream.range(start, end + 1).
                filter(i -> target == inOrder[i]).
                findFirst().
                orElse(-1);
    }

    /**
     * Given a non-empty binary tree, find the maximum path sum.
     * @param root The first and the only argument contains a pointer to the root.
     * @return maximum path sum
     */
    private int maxPathSum(BinaryTree root) {
        _maxSum = Integer.MIN_VALUE;
        _findMaxUtil(root);
        return _maxSum;
    }

    private int _findMaxUtil(BinaryTree node) {
        if (node == null)
            return 0;

        int l = _findMaxUtil(node.left);
        int r = _findMaxUtil(node.right);
        int curr = Math.max(Math.max(l, r) + node.data, node.data);
        _maxSum = Math.max(Math.max(_maxSum, curr), l + r + node.data);
        return curr;
    }

    /**
     * @param root pointer to the root of a Binary tree
     * @return maximum difference between node and its ancestor
     */
    private static int maxAncestorDiff(BinaryTree root) {
        _maxAncestorDiff= Integer.MIN_VALUE;
        _maxDiffUtil(root);
        return _maxAncestorDiff;
    }
    private static int _maxDiffUtil(BinaryTree root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int l = _maxDiffUtil(root.left);
        int r = _maxDiffUtil(root.right);
        int val = root.data - Math.min(l, r);
        _maxAncestorDiff = Math.max(_maxAncestorDiff, val);
        return Math.min(Math.min(root.data, l), r);
    }
}

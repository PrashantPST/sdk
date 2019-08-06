package src.ds.non_linear.tree.traversals;

import src.ds.non_linear.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    private void levelOrderQueue(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return;
        int levelNodes;
        q.add(root);
        while (!q.isEmpty()) {
            levelNodes = q.size();
            while (levelNodes-- > 0) {
                TreeNode n = q.remove();
                System.out.print(" " + n.data);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            System.out.println();
        }
    }
    public static void main (String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);
        new LevelOrderTraversal().levelOrderQueue(root);
    }
}
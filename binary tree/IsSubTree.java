/*

Problem Statement

Given two binary trees root and subRoot, determine if subRoot is a subtree of root.

A subtree of root is a tree that consists of a node in root and all of its descendants.

root can also be identical to subRoot.


root:
      3
     / \
    4   5
   / \
  1   2

subRoot:
    4
   / \
  1   2



  Output: true
Explanation: subRoot matches the left subtree of root.

Approach

Traverse root tree (DFS or BFS).

At each node, check if the subtree starting there is identical to subRoot.

Helper function isSameTree(TreeNode a, TreeNode b) checks if two trees are exactly the same.

*/


// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    // Optional: main method to test
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)
                ),
                new TreeNode(5)
        );

        TreeNode subRoot = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2)
        );

        Solution solution = new Solution();
        System.out.println(solution.isSubtree(root, subRoot)); // Output: true
    }
}
















/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class hasPathSum {

    /*
    LeetCode 112 – Path Sum

    QUESTION:
    Given the root of a binary tree and an integer targetSum,
    return true if the tree has a root-to-leaf path such that
    the sum of the node values along the path equals targetSum.

    IMPORTANT:
    - The path must end at a LEAF node.
    */

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Step 1: If the current node is null
        // No path exists, so return false
        if (root == null) {
            return false;
        }

        // Step 2: If this is a leaf node (no children)
        // Check if remaining targetSum equals the node value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        /*
        Step 3: Recursive calls

        We subtract the current node's value from targetSum
        and check if either left OR right subtree has a valid path.

        Example trace (targetSum = 22):

        hasPathSum(5, 22)
            → hasPathSum(4, 17)
                → hasPathSum(11, 13)
                    → hasPathSum(7, 2)  → false
                    → hasPathSum(2, 2)  → true
        */

        return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
    }
}

/*
TIME COMPLEXITY:
O(n) → each node is visited once

SPACE COMPLEXITY:
O(h) → recursion stack, where h is the height of the tree

INTERVIEW TIP:
✔ Always check for LEAF node before comparing the sum
❌ Do NOT return true in the middle of the tree
*/

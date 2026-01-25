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

class IsBalancedTree {

    /*
    LeetCode 110 – Balanced Binary Tree

    QUESTION:
    Given a binary tree, determine if it is height-balanced.

    A binary tree is height-balanced if:
    For every node, the height difference between
    the left and right subtrees is at most 1.
    */

    public boolean isBalanced(TreeNode root) {
        /*
        We use a helper function that returns:
        - the height of the subtree if it is balanced
        - -1 if the subtree is NOT balanced

        This allows us to detect imbalance early
        and avoid recomputing heights.
        */
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {

        // Step 1: Empty tree has height 0
        if (node == null) {
            return 0;
        }

        /*
        Step 2: Recursively get height of left subtree
        If left subtree is already unbalanced, return -1
        */
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        /*
        Step 3: Recursively get height of right subtree
        If right subtree is already unbalanced, return -1
        */
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        /*
        Step 4: Check height difference
        If difference > 1 → tree is unbalanced
        */
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        /*
        Step 5: Return height of current node
        height = max(left, right) + 1
        */
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

/*
TRACE EXAMPLE:

Tree:
        3
       / \
      9  20
         / \
        15  7

checkHeight(3)
    → leftHeight = 1
    → rightHeight = 2
    → |1 - 2| = 1 → balanced

Final result: true

Unbalanced Example:
        1
       /
      2
     /
    3

At node 1:
leftHeight = 3, rightHeight = 0
|3 - 0| = 3 → unbalanced → return false
*/

/*
TIME COMPLEXITY:
O(n) → each node visited once

SPACE COMPLEXITY:
O(h) → recursion stack (h = tree height)

INTERVIEW TIP:
✔ Use -1 to signal imbalance (optimized)
❌ Avoid calculating height separately (O(n²) mistake)
*/

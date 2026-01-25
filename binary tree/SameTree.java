/*
LeetCode 100 – Same Tree

QUESTION:
Given the roots of two binary trees p and q, write a function to check if they are the same.

Two binary trees are considered the same if:
1. They have the same structure
2. They have the same node values at every position

Example:
Tree p:        1
               / \
              2   3

Tree q:        1
               / \
              2   3

Output: true
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SameTree {

    /*
    HOW IT WORKS (Recursive Logic):

    Step 1:
    If both nodes are null → trees are same at this position → return true

    Step 2:
    If one node is null and the other is not → structure differs → return false

    Step 3:
    If values of nodes are different → return false

    Step 4:
    Recursively compare:
      - left subtree of p with left subtree of q
      - right subtree of p with right subtree of q

    If both comparisons return true → trees are the same
    */

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Step 1: Both nodes are null
        // Example: p = null, q = null
        if (p == null && q == null) {
            return true;
        }

        // Step 2: One node is null, the other is not
        // Example: p = null, q = 2
        if (p == null || q == null) {
            return false;
        }

        // Step 3: Node values are different
        // Example: p.val = 1, q.val = 2
        if (p.val != q.val) {
            return false;
        }

        /*
        Step 4: Recursive calls

        Example trace for trees:
                1
               / \
              2   3

        Call stack:
        isSameTree(1,1)
            → isSameTree(2,2)
                → isSameTree(null,null) → true
                → isSameTree(null,null) → true
            → isSameTree(3,3)
                → isSameTree(null,null) → true
                → isSameTree(null,null) → true

        All return true → final result is true
        */
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        SameTree checker = new SameTree();

        // Tree p
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree q
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // Output
        System.out.println("Are the two trees the same? " + checker.isSameTree(p, q));
    }
}

/*
TIME COMPLEXITY:
O(n) → each node is visited once

SPACE COMPLEXITY:
O(h) → recursion stack (h = height of tree)

INTERVIEW TIP:
Always handle null cases first before comparing values.
*/

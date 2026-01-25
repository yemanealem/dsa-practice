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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both null
        if (p == null && q == null) {
            return true;
        }

        // Case 2: one null
        if (p == null || q == null) {
            return false;
        }

        // Case 3: values differ
        if (p.val != q.val) {
            return false;
        }

        // Case 4: check left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    // Main method
    public static void main(String[] args) {
        SameTree checker = new SameTree();

        // Tree 1
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // Check if trees are the same
        boolean result = checker.isSameTree(p, q);
        System.out.println("Are the two trees the same? " + result);
    }
}

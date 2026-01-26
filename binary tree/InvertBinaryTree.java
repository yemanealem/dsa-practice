public class InvertBinaryTree {

    // Definition for a binary tree node
    static class TreeNode {
        int val;           // value of the node
        TreeNode left;     // reference to left child
        TreeNode right;    // reference to right child

        // Constructor to initialize node value
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Method to invert (mirror) the binary tree
    public static TreeNode invertTree(TreeNode root) {

        // Base case: if tree or subtree is empty
        if (root == null) {
            return null;
        }

        // Step 1: swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Step 2: recursively invert left subtree
        invertTree(root.left);

        // Step 3: recursively invert right subtree
        invertTree(root.right);

        // Return root of inverted subtree
        return root;

  /*
  
  
          4
       / \
      7   2
     / \ / \
    9  6 3  1

  
  
  */
        
    }

    // Inorder traversal (Left → Root → Right)
    // Used to print tree structure
    public static void inorderTraversal(TreeNode root) {

        // Stop if node is null
        if (root == null) {
            return;
        }

        // Visit left subtree
        inorderTraversal(root.left);

        // Print current node value
        System.out.print(root.val + " ");

        // Visit right subtree
        inorderTraversal(root.right);
    }

    // Main method (program execution starts here)
    public static void main(String[] args) {

        /*
            Original Binary Tree Structure:

                    4
                   / \
                  2   7
                 / \ / \
                1  3 6  9
        */

        // Creating nodes and building the tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Print inorder traversal before inversion
        System.out.print("Inorder before inversion: ");
        inorderTraversal(root);

        // Invert the binary tree
        invertTree(root);

        // Print inorder traversal after inversion
        System.out.print("\nInorder after inversion: ");
        inorderTraversal(root);
    }
}

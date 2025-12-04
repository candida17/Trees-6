// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Using DFS approach calculate the sum if node value falls in between the given range
//Perform inorder or preorder or postorder traversal

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
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);

    }

    private int dfs(TreeNode root, int low, int high) {
        //base
        int sum = 0;
        if (root == null)
            return 0;

        //logic
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if(root.val > low) {
            sum += dfs(root.left, low, high);
        }
        if(root.val < high) {
            sum += dfs(root.right, low, high);
        }

        return sum;
    }
}

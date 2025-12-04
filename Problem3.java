// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Perform BFS/Level order traversal, while traversing through right node increase the column count by 1 and while traversing through left node decrease the count by 1
//Store the column indices in the hashmap and using bucket sort return the result from min to max

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> colq = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;
        q.add(root);
        colq.add(0);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int col = colq.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(cur.val);
            min = Math.min(min, col);
            max = Math.max(max, col);
            if (cur.left != null) {
                q.add(cur.left);
                colq.add(col - 1);
            }
            if (cur.right != null) {
                q.add(cur.right);
                colq.add(col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

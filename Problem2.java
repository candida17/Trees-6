// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Using BFS we serailise the Tree by processing the root node and adding its children to the final string
//We deserialise the given string by taking the inital element to be the root and process the left and right by increementing the index inside the array and adding the current
//processed element inside the queue.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("#");
            } else {
                sb.append(cur.val);
                q.add(cur.left);
                q.add(cur.right);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        if (data.length() == 0)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        //add the first idx of array as root node
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strArr[idx]));
        q.add(root);
        idx++;
        while (!q.isEmpty() || idx < strArr.length) {
            TreeNode cur = q.poll();
            //idx is now pointing at left node so create a left node
            if (!strArr[idx].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(strArr[idx]));
                //add this node to q
                q.add(cur.left);
            }
            idx++;
            //idx now points at right node so create right node
            if (!strArr[idx].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(strArr[idx]));
                q.add(cur.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

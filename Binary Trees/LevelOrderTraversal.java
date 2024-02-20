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
 import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            //calculating the current queue , which will be the current level size
            //dry run this to understand it clearly
            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                   //only adding the non-null nodes
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }

                  //then adding the current node after adding its left and right 
                //childs in queue
                subList.add(q.poll().val);
            }
            list.add(subList);  
        }
        return list;
    }
}

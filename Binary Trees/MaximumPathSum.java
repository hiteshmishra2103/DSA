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

    int maxSum=Integer.MIN_VALUE;
 
     TreeNode root;
     public int maxPathSum(TreeNode root) {
         calculateMaxPathSum(root);
         return maxSum;
     }
     private int calculateMaxPathSum(TreeNode root){
         if(root ==null){
             return 0;
         }
         int leftMax = Math.max(0, calculateMaxPathSum(root.left));
         int rightMax = Math.max(0, calculateMaxPathSum(root.right));
         // Update the global maxSum considering all four possibilities
         maxSum = Math.max(maxSum, 
             Math.max(root.val, 
                 Math.max(root.val + leftMax, 
                     Math.max(root.val + rightMax, 
                         root.val + leftMax + rightMax))));
 
         // Return the maximum path sum that includes the current node (for the parent)
         return root.val + Math.max(leftMax, rightMax);
     }
 }
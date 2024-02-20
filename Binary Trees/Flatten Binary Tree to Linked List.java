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

//  ////////////////////////------------Brute force approach-------------------//////////////////////////////////
//  ////////////////recursive approach: t(n), s(n)=o(n) due to recursion stack
// class Solution {
//     public void flatten(TreeNode root) {
//                if(root==null || (root.left ==null && root.right==null)){
//                    return;
//                }
//                if(root.left!=null){
//                    flatten(root.left);
//                    //storing the right subtree in temp
//                    TreeNode temp=root.right;
//                    //pointing root.right to right of root
//                    root.right=root.left;
//                    //setting the left pointer to null
//                    root.left=null;
                   
//                    TreeNode t=root.right;
//                  //finding left tail
//                    while(t.right!=null){
//                        t=t.right;
//                    }

//                    //joining left tail with right subtree
//                    t.right=temp;
//                }
//                flatten(root.right);
               

//     }
// }


// OPTIMISED APPROACH

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
    public void flatten(TreeNode root) {
          // traverse till root is not NULL
        while (root != null) {
          // if root->left is not NULL
          if (root.left != null) {
            // set curr node as root->left;
            TreeNode curr = root.left;
            // traverse to the extreme right of curr
            while (curr.right != null) {
              curr = curr.right;
            }
            // join curr->right to root->right
            curr.right = root.right;
            // put root->left to root->right
            root.right = root.left;
            // make root->left as NULL
            root.left = null;
          }
          // now go to the right of the root
          root = root.right;
        }
    }
    
    }
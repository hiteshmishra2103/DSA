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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val<key){
            //go to right subtree and the changed right subtree we will get from there, we will put it 
            //into the right pointer
            root.right=deleteNode(root.right,key);
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else{
            //voila
            //case1: leaf node

            if(root.left==null && root.right==null){
                return null;
            }
            //case2: single child
            if(root.left==null){
                return root.right;
            }
//here👇, now root.right having null value can't go to line to "eqn:1"" line
            if(root.right==null){
                return root.left;
            }

            

            
            //case3:if the node to be deleted has both children
//inorder successor for this node will be the leftmost element in right subtree
TreeNode inorderSuccessor = InorderSuccessor(root.right);//"eqn:1"
root.val = inorderSuccessor.val;
root.right = deleteNode(root.right, inorderSuccessor.val);

        }
        return root;
    }
   public static TreeNode InorderSuccessor(TreeNode root){
    //we don't need to write the case for "if root ==null " because we have already handled that case in 
    while(root.left!=null){
        root=root.left;
    }
    return root;
}

}
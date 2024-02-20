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

    ///-----------------------------Unoptimised approach-------------------------------///
    // public void isSorted(ArrayList<Integer> list,TreeNode root){
    //     if(root==null){
    //         return;
    //     }
    //   isSorted(list,root.left);
    //    list.add(root.val);
    //     isSorted(list,root.right);
    // }
    //     public boolean isValidBST(TreeNode root) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     isSorted(list, root);
    //     for (int i = 1; i < list.size(); i++) {
    //         if (list.get(i) <= list.get(i - 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }


    //////////----------------------Optimised approach-----------------------////////////
    ///following approach is used as a helper function in another questions------------///
    public boolean isBst(TreeNode root, TreeNode min, TreeNode max){
        if(root==null){
return true;
        }

if(min!=null && root.val <= min.val){
    return false;
}

if(max!=null && root.val>=max.val){
return false;
}
        return isBst(root.left, min,root) && isBst(root.right, root, max);
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode min=null, max=null;
            boolean result=isBst(root, min,max);
            return result;

    }

}
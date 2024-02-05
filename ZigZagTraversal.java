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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        } 
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean reverse=false;
        while(!q.isEmpty()){
            int currLevel=q.size();
            List<Integer> subList=new ArrayList<>();
            for(int i=0;i<currLevel;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                subList.add(q.poll().val);
            }
            if(reverse==true){
            Collections.reverse(subList);
                reverse=false;
            }else{
                reverse=true;
            }
            list.add(subList);
        }
        return list;
    }
}
//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public void getInorder(Node root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    public Node createSortedArrayToBST(int start, int end, ArrayList<Integer> nums){
        if(start>end){
            return null;
        }

        int mid=start+(end-start)/2;

        Node root=new Node(nums.get(mid));
        root.left=createSortedArrayToBST(start, mid-1, nums);
        root.right=createSortedArrayToBST(mid+1, end, nums);
        return root;
    }
    
    public  Node mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2){
        int l1=list1.size();
        int l2=list2.size();
        ArrayList<Integer> list3=new ArrayList<>();
        
        int i=0, j=0;
        while(i<l1 && j<l2){
            if(list1.get(i)<=list2.get(j)){
                list3.add(list1.get(i));
                i++;
            }
            if(list2.get(j)<=list1.get(i)){
                list3.add(list2.get(j));
                j++;
            }
        }
        
        for(;i<l1;i++){
            list3.add(list1.get(i));
        }
        for(;j<l2;j++){
            list3.add(list2.get(j));
        }
        return list3;
    }
    public List<Integer> merge(Node root1,Node root2)
    {
ArrayList<Integer> list1=new ArrayList<>();
ArrayList<Integer> list2=new ArrayList<>();
getInorder(root1, list1);
getInorder(root2, list2);
ArrayList<Integer> list3=mergeLists(list1, list2);
return createSortedArrayToBST(0, list3.size()-1, list3);
    }
}

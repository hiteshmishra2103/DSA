/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {


    //following is the brute force approach to merge k sorted lists 
    //Worst Time complexity: O(n^3)
    //Space complexity: O(1)
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     ListNode temp1 = l1;
    //     ListNode temp2 = l2;

    //     ListNode head3 = new ListNode();
    //     ListNode temp3 = head3;

    //     while (temp1 != null && temp2 != null) {
    //         if (temp1.val < temp2.val) {
    //             temp3.next = new ListNode(temp1.val);
    //             temp1 = temp1.next;
    //         } else {
    //             temp3.next = new ListNode(temp2.val);
    //             temp2 = temp2.next;
    //         }
    //         temp3 = temp3.next;
    //     }

    //     while (temp1 != null) {
    //         temp3.next = new ListNode(temp1.val);
    //         temp1 = temp1.next;
    //         temp3 = temp3.next;
    //     }

    //     while (temp2 != null) {
    //         temp3.next = new ListNode(temp2.val);
    //         temp2 = temp2.next;
    //         temp3 = temp3.next;
    //     }

    //     return head3.next;
    // }
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists.length==0){
    //         return null;
    //     }
    //     ListNode head=lists[0];
    //     for(int i=1;i<lists.length;i++){
    //        head= mergeTwoLists(head, lists[i]);
    //     }
    //     return head;
    // }

    //following is optimised 
    //t(n)=O(n^2logn)
    //s(n)=O(n)

    class Pair implements Comparable<Pair> {
        int val;
        ListNode node;

        public Pair(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        // Add head nodes of each list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(new Pair(node.val, node));
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {

            //remove the top node, which is the node with least value
            Pair current = pq.poll();
            //temp.next will point to the current node
            temp.next = current.node;
            temp = temp.next;

            // Move to the next node in the current list
            if (current.node.next != null) {
                pq.add(new Pair(current.node.next.val, current.node.next));
            }
        }

        return dummy.next;
    }
}

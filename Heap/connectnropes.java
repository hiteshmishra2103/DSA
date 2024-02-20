import java.util.*;

public class Solution {
    
    public static long connectRopes(int[] arr) {
        // Create a priority queue to store the lengths of ropes
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add the ropes to the priority queue
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        // Initialize the minimum cost
        long minCost = 0;

        // Merge the ropes until there is only one rope left
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int newLength = first + second;
            minCost += newLength;
            pq.add(newLength); // Add the merged rope back to the priority queue
        }
        
        return minCost;
    }
}


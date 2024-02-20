import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public boolean isAnagram(String s, String t) {
// //Brute force solution
//         // Time complexity: O(nlogn)
//         // Space complexity: O(n)

//         // If the length of the strings is different, they can't be anagrams
//         if (s.length() != t.length()) {
//             return false;
//         }
         
//         // Convert strings to char arrays
//         char[] sArray = s.toCharArray();
//         char[] tArray = t.toCharArray();
         
//         // Sort char arrays
//         Arrays.sort(sArray);
//         Arrays.sort(tArray);

//         // Compare sorted char arrays
//         return Arrays.equals(sArray, tArray);


        //optimised solution
        // Time complexity: O(n)
        // Space complexity: O(n)
        
  int l1 = s.length();
        int l2 = t.length();

        if (l1 != l2) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count character occurrences in string s
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Check character occurrences in string t
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            int count = map.get(ch);
            if (count == 1) {
                map.remove(ch);
            } else {
                map.put(ch, count - 1);
            }
        }

        // If map is empty, strings are anagrams
        return map.isEmpty();
       
    }
}

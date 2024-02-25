package HashMaps;

 import java.util.*;

 public class Solution {
    public String frequencySort(String s) {
        // //Brute force:
        // // Create a hashmap to store character frequencies
        // HashMap<Character, Integer> charCount = new HashMap<>();
        
        // // Count the frequency of each character
        // for (char c : s.toCharArray()) {
        //     charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        // }
        
        // // Create a list of characters sorted by their frequencies
        // List<Character> sortedChars = new ArrayList<>(charCount.keySet());
        // //nlogn time for sorting
        // Collections.sort(sortedChars, (a, b) -> charCount.get(b) - charCount.get(a));
        
        // // Construct the result string
        // StringBuilder result = new StringBuilder();
        // for (char c : sortedChars) {
        //     int frequency = charCount.get(c);
        //     for (int i = 0; i < frequency; i++) {
        //         result.append(c);
        //     }
        // }
        
        // return result.toString();

        // //Optimised: t(n)=o(n), s(n)=o(n)

        char[] ch = s.toCharArray();
        //as there are 128 characters, 

        int[] freqs = new int[128];
        int n = ch.length;
        //creating a frequency array of characters for storing the frequency
        for (int i = 0; i < n; i++) {
            freqs[ch[i]]++;
        }

        int i = 0;


        while (i < n) {
            int max = 0;

            //finding the max frequency of characters, if it is found then update it and store it in max
            for (int j = 0; j < 128; ++j) {
                if (freqs[j] > freqs[max]) max = j;
            }
            //creating a resulting array of characters
            while (freqs[max]-- > 0) {
                ch[i++] = (char)(max);
            }
            
        }

        //converting the resulting character to string
        return String.valueOf(ch);


    }
    
}
 {
    
}

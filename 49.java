import java.util.*;

    // Time Complexity: O(n * k * log k)
    // n: number of strings
    // k: maximum length of a string
    // Sorting each string takes O(k log k), and there are n strings to process.
    
    // Space Complexity: O(n * k)
    // The space is used by the HashMap and the lists to store the strings and keys.
    // Storing all the strings in the output will take O(n * k), where k is the average length of the strings.
    
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store the groups of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        // Loop through each string in the input array
        for (String s : strs) {
            // Convert the string to a character array, sort it, and convert it back to a string
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            
            // If the sorted version is not already a key in the map, add it with an empty list
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            // Add the original string to the corresponding anagram group
            map.get(sorted).add(s);
        }
        
        // Return the values (grouped anagrams) as a list
        return new ArrayList<>(map.values());
    }
}

import java.util.*;

class Solution {

    // Time Complexity: O(n), where n is the length of the string s.
    // We slide over the string once and process each 10-letter substring in constant time.
    
    // Space Complexity: O(n), since we store substrings in the sets.
    
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        // Only process if the string has at least 10 characters
        if (s.length() < 10) {
            return result;
        }
        
        // Slide over the string to get every 10-letter-long sequence
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            
            // If the substring has been seen before and not already added to the result, add it
            if (seen.contains(substring)) {
                repeated.add(substring);
            } else {
                seen.add(substring);
            }
        }
        
        // Convert the repeated sequences to a list
        result.addAll(repeated);
        return result;
    }
}


import java.util.ArrayList;
import java.util.List;

// Time Complexity Analysis:
// The time complexity is O(4^n / sqrt(n)), which is 
// derived from the nth Catalan number because the valid 
// strings of parentheses correspond to Catalan numbers.

// Space Complexity: 
// O(4^n / sqrt(n) Due to storage of valid combinations and recursion depth

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start the backtracking process
        backtrack(result, "", 0, 0, n);
        return result;
    }

    // Helper function for backtracking
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: when the current string has used up all n pairs of parentheses
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If we can still add an opening parenthesis, do so
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // If we can add a closing parenthesis without exceeding the number of opening parentheses, do so
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
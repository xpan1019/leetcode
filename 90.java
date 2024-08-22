import java.util.*;

class Solution {

    // Time Complexity: O(2^n), where n is the number of elements in nums.
    // Each element can either be included or excluded, generating 2^n subsets.
    
    // Space Complexity: O(2^n), as we store all subsets in the result.

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        // Sort the array to handle duplicates
        Arrays.sort(nums);
        
        // Start the backtracking process
        backtrack(result, subset, nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int index) {
        // Add the current subset to the result
        result.add(new ArrayList<>(subset));
        
        // Explore subsets that include elements from the current index onwards
        for (int i = index; i < nums.length; i++) {
            // If current element is the same as the previous one, skip it to avoid duplicates
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Include the current element
            subset.add(nums[i]);
            
            // Recursively add other elements
            backtrack(result, subset, nums, i + 1);
            
            // Backtrack by removing the last element added
            subset.remove(subset.size() - 1);
        }
    }
}

import java.util.*;

class Solution {

    // Time Complexity: O(2^n), where n is the number of elements in the array nums.
    // Each element can either be included or not, generating 2^n subsets.
    
    // Space Complexity: O(2^n), as we store all the subsets in the result list.

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(result, subset, nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int index) {
        // Add the current subset to the result
        result.add(new ArrayList<>(subset));

        // Explore subsets that include elements from the current index onwards
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]); // Include current element
            backtrack(result, subset, nums, i + 1); // Recursively add other elements
            subset.remove(subset.size() - 1); // Backtrack by removing the last element
        }
    }
}

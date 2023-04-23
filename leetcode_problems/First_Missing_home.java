class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers and numbers greater than n with a placeholder (n+1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n+1;
            }
        }

        // Step 2: Use the array as a hash table to mark numbers as present
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }

        // Step 3: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }

        // If all numbers from 1 to n are present, return n+1
        return n+1;
    }
}
 
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // sort to avoid duplicates
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                // skip duplicates or already used numbers
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums, used, curr, res);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}

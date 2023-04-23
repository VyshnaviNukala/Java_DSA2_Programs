
   class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> currentList, List<List<Integer>> result){
        if(currentList.size() == nums.length){
            result.add(new ArrayList<>(currentList));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(currentList.contains(nums[i]))
                continue;
            currentList.add(nums[i]);
            backtrack(nums, currentList, result);
            currentList.remove(currentList.size() - 1);
        }
    }
}
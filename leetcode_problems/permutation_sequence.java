class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i-1] * i;
        }
        
        StringBuilder sb = new StringBuilder();
        k--;
        
        for (int i = n; i >= 1; i--) {
            int index = k / factorials[i-1];
            sb.append(nums.get(index));
            nums.remove(index);
            k %= factorials[i-1];
        }
        
        return sb.toString();
    }
}

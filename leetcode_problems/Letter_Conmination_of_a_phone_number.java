class Solution {
    private final String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> combinations = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        backtrack(digits, new StringBuilder(), 0);
        return combinations;
    }
    
    private void backtrack(String digits, StringBuilder sb, int index) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
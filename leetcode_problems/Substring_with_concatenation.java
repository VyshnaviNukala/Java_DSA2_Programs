
    import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }
        int wordLength = words[0].length();
        int windowLength = wordLength * words.length;
        if (windowLength > s.length()) {
            return result;
        }
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - windowLength; i++) {
            Map<String, Integer> temp = new HashMap<>(wordCount);
            for (int j = i; j < i + windowLength; j += wordLength) {
                String word = s.substring(j, j + wordLength);
                if (!temp.containsKey(word)) {
                    break;
                }
                int count = temp.get(word);
                if (count == 1) {
                    temp.remove(word);
                } else {
                    temp.put(word, count - 1);
                }
            }
            if (temp.isEmpty()) {
                result.add(i);
            }
        }
        return result;
    }
}

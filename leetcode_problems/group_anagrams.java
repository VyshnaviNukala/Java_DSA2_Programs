import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
 
        Map<String, List<String>> map = new HashMap<>();
        
        
        for (String s : strs) {
         
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            
            
            List<String> group = map.getOrDefault(key, new ArrayList<String>());
            group.add(s);
            map.put(key, group);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
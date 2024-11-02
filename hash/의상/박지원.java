import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] cloth : clothes) {
            map.getOrDefault(cloth[1], new ArrayList<String>());
            map.get(cloth[1]).add(cloth[0]);
        }
        
        int answer = 1;
        for(List<String> value : map.values()) {
            answer = answer * (value.size() + 1);
        }
        return answer - 1;
    }
}

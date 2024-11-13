import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i< clothes.length; i++) {
            String key = clothes[i][1];
            
            hm.put(key, hm.getOrDefault(key,0)+1);
 //         답을 봐도 수식을 도저히 어떻게 넣는지 모르겠다
            System.out.println(key+hm.get(key));
        }
        return answer;
    }
}

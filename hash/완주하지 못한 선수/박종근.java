import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        String answer = "";

        for(int i=0; i<participant.length; i++) {
            hashmap.put(participant[i], hashmap.getOrDefault(participant[i],0)+1);
        }
        
        for(int i=0; i<completion.length; i++) {
            hashmap.put(completion[i], hashmap.get(completion[i])-1);
        }
        
        for(int i=0; i < hashmap.keySet().size(); i++) {
            if(hashmap.get(participant[i]) > 0) {
                answer = participant[i];
                break;
            }
        }
        
        return answer;
    }
}

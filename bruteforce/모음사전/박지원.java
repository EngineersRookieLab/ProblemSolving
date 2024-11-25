import java.util.*;
class Solution {
    ArrayList<String> dic = new ArrayList<>();
    String[] arr = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        for(int i = 0; i < 5; i++) {
            makeWord(arr[i]);
        }
        return dic.indexOf(word) + 1;
    }
    
    
    public void makeWord(String cur){
        if(cur.length() > 5) return;
        dic.add(cur);
        
        for(int i = 0; i < 5; i++) 
            makeWord(cur + arr[i]);
    }
}

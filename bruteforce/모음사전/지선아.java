import java.util.*;
class Solution {
    private static final String[] DICTIONARY = {"A", "E", "I", "O", "U"};
    private int count = 0;
    private int result = 0;

    public int solution(String word) {
        dfs(word, "");
        return result;
    }

    private void dfs(String target, String currentWord) {
        if (currentWord.length() > 5) {
            return;
        }
      
        if (currentWord.equals(target)) {
            result = count;
            return;
        }
        
        count++;
        
        for (String letter : DICTIONARY) {
            dfs(target, currentWord + letter);
        }
    }
}

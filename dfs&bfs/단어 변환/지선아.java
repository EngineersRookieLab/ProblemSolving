import java.util.*;

class Solution {
      
    public int solution(String begin, String target, String[] words) {
        // 그래프 생성
        Map<String, List<String>> graph = new HashMap<>();
        for (String word : words) {
            graph.put(word, new ArrayList<>());
        }
        graph.put(begin, new ArrayList<>());
        // 그래프에 인접 단어 연결
        for (String word1 : graph.keySet()) {
            for (String word2 : graph.keySet()) {
                if (isSimilar(word1, word2)) {
                    graph.get(word1).add(word2);
                }
            }
        }
        return bfs(begin, target, graph);
    }
    
    private boolean isSimilar(String word1, String word2) {
        if (word1 == word2) return false;
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1) return false;
        }
        return true;
    }
    
    private int bfs(String begin, String target, Map<String, List<String>> graph) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distances = new HashMap<>();
        queue.offer(begin);
        distances.put(begin, 0);
        
        while(!queue.isEmpty()) {
            String current = queue.poll();
            int currentDistance = distances.get(current);
            
            if (current.equals(target)) return currentDistance;
            
            for (String neighbor : graph.get(current)) {
                if (!distances.containsKey(neighbor)) { // 방문 여부 확인
                    distances.put(neighbor, currentDistance + 1);
                    queue.offer(neighbor);
                }
            }
        }
        return 0;
    }

}

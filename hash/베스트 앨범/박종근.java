import java.util.*;

        // 1. 장르, 총합 해시맵을 만들고 총합을 넣는다.
            // 장르, 인트배열[]의 인트배열에 제일 높은 판매수의 인덱스  2개만 넣는다.
    // 2. 장르 총합 헤시맵을 정렬한다.
    // 3. 총합이 높은 장르의 배열에서 앞 2개를 꺼내서 정답 배열에넣는다.

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, PriorityQueue<Integer>> mapQueue = new HashMap<>();
        
        for(int i=0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
            
            mapQueue.putIfAbsent(genres[i],new PriorityQueue<Integer>(Comparator.reverseOrder()));
            PriorityQueue<Integer> queue = mapQueue.get(genres[i]);
            queue.offer(plays[i]);
            if(queue.size() > 2) queue.poll();            
            mapQueue.putIfAbsent(genres[i],queue);
            System.out.println(queue);
            }
        
        // value 기준으로 내림차순 정렬하여 key만 배열로 추출
        String[] sortedKeysArray = map.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // 값 기준 내림차순 정렬
            .map(Map.Entry::getKey)  // key만 추출
            .toArray(String[]::new); // 배열로 변환
            
        // for(int i=0; i<sortedKeysArray.length; i++) {
        //     for(int j=0; j< mapQueue.get(sortedKeysArray[i]).length; j++) {
        //         answer.put(map.get(sortedKeysArray[i]);
        //     }
        // }
        
        return answer;
    }
}

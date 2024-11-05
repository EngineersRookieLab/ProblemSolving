iiiiiimport java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {    
        HashMap<String, HashMap<Integer, Integer>> album = new HashMap<>();
         for (int i = 0; i < genres.length; i++) {
            album.computeIfAbsent(genres[i], k -> new HashMap<>())
                 .put(i, plays[i]);
        }
        
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        for (String genre : album.keySet()) {
            // "genre" 로 검색한 값들의 values의 sum을 구함
            int total = album.get(genre).values().stream().mapToInt(Integer::intValue).sum();
            genrePlayCount.put(genre, total);
        }
        
        List<Integer> answerList = genrePlayCount.entrySet().stream()
            .sorted((a, b) -> 
                    b.getValue() - a.getValue())                        // 총 재생 수로 정렬
            .flatMap(entry -> 
                     album.get(entry.getKey()).entrySet().stream()
                    .sorted((a, b) -> 
                            b.getValue()                                // 재생 수 내림차순, 고유번호 오름차순 정렬
                            .equals(a.getValue()) ? a.getKey() - b.getKey() : b.getValue() - a.getValue()
                           ) 
                     .limit(2)                                          // 2개씩 수록
                     .map(Map.Entry::getKey)                            // 고유번호만 모음
                    )
            .collect(Collectors.toList());
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}

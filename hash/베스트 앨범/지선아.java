import java.util.*;
import java.util.stream.*;

class Solution {
    private static final Integer LIMIT = 2;
    public int[] solution(String[] genres, int[] plays) {
       // 장르별 총 재생 횟수 계산
        HashMap<String, Integer> genreMap = new HashMap<>();
        LinkedHashSet<Integer> playList = new LinkedHashSet<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 재생 횟수로 정렬
        List<String> sortedGenre = genreMap.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        // 장르 - [고유번호, 재생 수]
        HashMap<String, List<int[]>> play = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            play.putIfAbsent(genres[i], new ArrayList<>());
            play.get(genres[i]).add(new int[]{i, plays[i]});
        }
        // 앨범 생성
        List<Integer> album = new ArrayList<>();
        for (String genre : sortedGenre) {
            List<int[]> genreSongs = play.get(genre);
            // 재생수가 같으면 고유 번호 순서로 정렬하고 재생수가 다르면 재생수로 정렬
            genreSongs.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
            for (int j = 0; j < Math.min(LIMIT, genreSongs.size()); j++) {
                album.add(genreSongs.get(j)[0]);
            }
        }
        return album.stream().mapToInt(Integer::intValue).toArray();
    }
}

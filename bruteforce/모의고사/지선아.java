import java.util.*;
import java.util.stream.*;
class Solution {
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one_pattern = new int[] {1, 2, 3, 4, 5};
        int[] two_pattern = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three_pattern = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int one_score = (int) IntStream.range(0, answers.length)
                .filter(i -> answers[i] == one_pattern[i % one_pattern.length])
                .count();
        int two_score  = (int) IntStream.range(0, answers.length)
                .filter(i -> answers[i] == two_pattern[i % two_pattern.length])
                .count();
        int three_score = (int) IntStream.range(0, answers.length)
                .filter(i -> answers[i] == three_pattern[i % three_pattern.length])
                .count();


        int max_score = Math.max(one_score, Math.max(two_score, three_score));

        // 최대 점수를 가진 사람 찾기
        List<Integer> winners = new ArrayList<>();
        if (one_score == max_score) winners.add(1);
        if (two_score == max_score) winners.add(2);
        if (three_score == max_score) winners.add(3);

        Collections.sort(winners);
        return winners.stream().mapToInt(winner -> winner).toArray();
    }
}

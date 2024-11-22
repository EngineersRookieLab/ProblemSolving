import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] answers) {
        int[] points = {0, 0, 0};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i % 5]) points[0]++;
            if(answers[i] == second[i % 8]) points[1]++;
            if(answers[i] == third[i % 10]) points[2]++;
        }
        
        int maxPoint = IntStream.of(points).max().orElse(0);
        return IntStream.range(0, points.length)
                        .filter(i -> points[i] == maxPoint)
                        .map(i -> i + 1)
                        .toArray();
    }
}

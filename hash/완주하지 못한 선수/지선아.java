package programmers.review.hash;

import java.util.Arrays;
import java.util.HashMap;

public class Sol42576 {
    
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> result = new HashMap<>();
        Arrays.stream(participant).forEach(p -> result.put(p, result.getOrDefault(p, 0) + 1));
        for (String name : completion) {
            Integer count = result.get(name);
            result.replace(name, count - 1);
        }
        return result.entrySet().stream().filter(entry -> entry.getValue() > 0).findFirst().get().getKey();
    }

    public static void main(String[] args) {
        Sol42576 sol42576 = new Sol42576();
        String[] participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[] {"josipa", "filipa", "marina", "nikola"};
        String solution = sol42576.solution(participant, completion);
        System.out.println("solution = " + solution);
    }

}

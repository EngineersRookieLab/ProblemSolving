import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int[] command : commands) {
            List<Integer> list = new ArrayList<>();
            for(int i = command[0] - 1 ; i < command[1] ; i++) {
                list.add(array[i]);
            }
            Collections.sort(list);
            answer.add(list.get(command[2] - 1));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

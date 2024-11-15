import java.util.*;
import java.util.stream.*;

class Solution {
     public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        if (strNumbers[0].equals("0")) {
            return "0";
        }
        return Arrays.stream(strNumbers).collect(Collectors.joining());
    }
}

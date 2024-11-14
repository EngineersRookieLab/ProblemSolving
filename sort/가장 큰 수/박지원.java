import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(int[] numbers) {
        List<String> numberList = new ArrayList<>();
        for(int number : numbers) {
            numberList.add(Integer.toString(number));
        }
        
       String answer = numberList.stream()
                .sorted((str1, str2) -> (str2 + str1).compareTo(str1 + str2)) 
                .collect(Collectors.joining());

        if (answer.startsWith("0")) {
            return "0";
        }
        return answer;
    }
}

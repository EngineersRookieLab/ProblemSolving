import java.util.*;
class Solution {
    HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        recursive("", numbers);

        int answer = 0;
        for(Integer num : numberSet) {
            if(isPrime(num)) {
                answer ++;
            }
        }
        return answer;
    }

    public void recursive(String numStr, String numbers) {
        if (!"".equals(numStr)) {
            numberSet.add(Integer.parseInt(numStr));
        }

        for(int i = 0; i < numbers.length(); i++ ){
            recursive(numStr + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1));
        }
    }

    public boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

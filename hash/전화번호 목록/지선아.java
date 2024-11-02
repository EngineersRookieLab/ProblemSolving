import java.util.*;
import java.util.stream.*;

class Solution {
    public boolean solution(String[] phone_book) {
        List<String> sortedPhoneBook  = Arrays.stream(phone_book).sorted().collect(Collectors.toList());
        for (int i = 0; i < sortedPhoneBook.size() - 1; i++) {
            if (sortedPhoneBook.get(i + 1).startsWith(sortedPhoneBook.get(i))) {
                return false;
            } 
        }
        return true;
    }
}

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet hs = new HashSet<String>();
//         하나씩 번호를 넣는다
        for(int i=0; i < phone_book.length; i++) {
//             현재 들어가있는것들중 같은게있는지 확인
            String in = phone_book[i];
            Iterator<String> it = hs.iterator();	 
            while(it.hasNext()) {
                String old = it.next();
                if(in.contains(old)) 
                    return false;
                }                
            hs.add(in);
            }
        return true;
    }
}

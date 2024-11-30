class Solution {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder();
        int targetLength = number.length() - k;
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            while (k > 0 && builder.length() > 0 && builder.charAt(builder.length() - 1) < current) {
                builder.deleteCharAt(builder.length() - 1);
                k--;
            }
            builder.append(current);
        }
        return builder.substring(0, targetLength);
    }
        
}

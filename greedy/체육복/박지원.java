import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int getCount = 0;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    getCount++;
                    break;
                }
            }
        }
        
        for (int lostj : lost) {
            if (lostj == -1) continue;
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == -1) continue;
                if (lostj == reserve[j] - 1 || lostj == reserve[j] + 1) {
                    reserve[j] = -1;
                    getCount++;
                    break;
                }
            }
        }
        return n - lost.length + getCount;
    }
}


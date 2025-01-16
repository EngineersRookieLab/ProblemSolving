import java.util.*;
import java.util.stream.*;
class Solution {
    
    private static final String ICN = "ICN";
    private List<String> route;
    private boolean[] isUsed;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        route = new ArrayList<>();
        isUsed = new boolean[tickets.length];
        route.add(ICN);
        dfs(ICN, tickets, 0);
        return route.toArray(new String[0]);
    }
    private boolean dfs(String current, String[][] tickets, int count) {
        if (count == tickets.length) {
            return true;
        }
        for (int i = 0 ; i < tickets.length; i++) {
            if (!isUsed[i] && tickets[i][0].equals(current)) {
                isUsed[i] = true;
                route.add(tickets[i][1]);
                if (dfs(tickets[i][1], tickets, count+1)) {
                    return true;
                }
                isUsed[i] = false;
                route.remove(route.size() - 1);
            }
        }
        return false;
    }
}

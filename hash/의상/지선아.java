public class Sol42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for (String[] cloth : clothes) {
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
        }
        int sum = 1;
        for (int num : clothesMap.values()) {
            sum *= (num + 1);
        }
        return sum - 1;
    }
}

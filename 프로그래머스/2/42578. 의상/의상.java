import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }
        int now = 1;
        for(String cloth : map.keySet()){
            now *= (map.get(cloth)+1);
        }
        now -= 1;
        
        return now;
    }
}
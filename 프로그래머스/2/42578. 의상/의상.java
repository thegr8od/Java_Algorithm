import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] str : clothes){
            map.put(str[1], map.getOrDefault(str[1],0)+1);
        }
        
        for(String key : map.keySet()){
            System.out.print(map.get(key));
        }
        
        for(String key : map.keySet()){
            answer *= (map.get(key)+1);
        }
        answer -= 1;
        return answer;
    }
}
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String part : participant){
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for(String comp : completion){
            map.put(comp, map.getOrDefault(comp, 0) - 1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                answer = key;
            }
        }
        return answer;
    }
}
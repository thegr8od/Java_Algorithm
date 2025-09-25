import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        List<String> lst = new ArrayList<>();
        for(String id : id_list){
            map.put(id, new HashSet<String>());
        }
        
        for(String rep : report){
            String[] now = rep.split(" ");
            String id1 = now[0];
            String id2 = now[1];
            
            map.get(id1).add(id2);
        }
        
        for(String key : map.keySet()){
            for(String now : map.get(key)){
                map2.put(now, map2.getOrDefault(now, 0) + 1);
            }
        }
        
        for(String now : map2.keySet()){
            if(map2.get(now) >= k){
                lst.add(now);
            }
        }
        
        for(String now : lst){
            for(int i=0; i<id_list.length; i++){
                if(map.get(id_list[i]).contains(now)){
                    answer[i] += 1;
                }
            }
        }
        
        return answer;
    }
}
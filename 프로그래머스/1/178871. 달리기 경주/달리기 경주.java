import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);
        }
        for(String calling : callings){
            int now = map.get(calling);
            
            String tmp = players[now-1];
            players[now-1] = calling;
            players[now] = tmp;
            
            map.put(players[now-1], now-1);
            map.put(players[now], now);
        }
        return players;
    }
}
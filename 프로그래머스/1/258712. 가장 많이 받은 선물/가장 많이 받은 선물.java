import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            map.put(friends[i], i);
        }
        
        int[] giftDegree = new int[friends.length];
        int[][] giftGraph = new int[friends.length][friends.length];
        
        for(String gift : gifts){
            String[] cur = gift.split(" ");
            giftDegree[map.get(cur[0])]++;
            giftDegree[map.get(cur[1])]--;
            giftGraph[map.get(cur[0])][map.get(cur[1])]++;
        }
        
        for(int i=0; i<friends.length; i++){
            int cnt = 0;
            for(int j=0; j<friends.length; j++){
                
                if(i==j) continue;
                
                if(giftGraph[i][j] > giftGraph[j][i] || 
                   (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j])){
                    cnt++;
                }
            }
            
            answer = Math.max(cnt, answer);
        }
        return answer;
    }
}
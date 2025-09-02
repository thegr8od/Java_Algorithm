import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] visited = new boolean[reserve.length];
        int rec = 0;
        
        // 앞사람부터
        List<Integer> lst = new ArrayList<>();
        for(int num : reserve){
            lst.add(num);
        }
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    visited[j] = true;
                    rec++;
                    lost[i] = -1;
                }
            }
        }
        
        for(int num : lost){
            if(num != -1){
            for(int j=0; j<reserve.length; j++){
                if(!visited[j] && Math.abs(num - reserve[j]) == 1){
                    visited[j] = true;
                    rec++;
                    break;
                }
            }
            }
        }
        
        answer += rec;
        
        
        return answer;
    }
}
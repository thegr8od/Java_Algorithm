import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int now = 0;
        for(int[] cmd : commands){
            int start = cmd[0]-1;
            int end = cmd[1]-1;
            int index = cmd[2]-1;
            
            List<Integer> lst = new ArrayList<>();
            
            for(int i=start; i<=end; i++){
                lst.add(array[i]);
            }
            
            Collections.sort(lst);
            answer[now++] = lst.get(index);            
            
            
        }
        
        return answer;
    }
}
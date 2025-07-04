import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int now = 0;
        for(int[] command : commands){
            int start = command[0]-1;
            int end = command[1];
            int idx = command[2]-1;
            List<Integer> lst = new ArrayList<>();
            
            for(int i = start; i<end; i++){
                lst.add(array[i]);
            }
            
            Collections.sort(lst);
            
            answer[now++] = lst.get(idx);
            
            
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        ArrayList<Integer> lst = new ArrayList<>();
        // Queue<Integer> queue = new ArrayDeque<>();
        // for(int i=0; i<len; i++){
        //     queue.add(progresses[i]);
        // }
        
        for(int i=0; i<len; i++){
            int cnt = 1;
            while(true){
                int now = progresses[i];
                if(now >= 100){
                    break;
                }
                for(int j=i; j<len; j++){
                    progresses[j] += speeds[j];
                }
            }
            
            for(int k=i+1; k<len; k++){
                if(progresses[k] >= 100){
                    cnt++;
                    i++;
                }
                else{
                    break;
                }
            }
            lst.add(cnt);
        }
       
        int[] answer = new int[lst.size()];
        for(int i=0; i<lst.size(); i++){
            answer[i] = lst.get(i);
        }
        
        return answer;
    }
}
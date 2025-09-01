import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int index = 0;
        int totalSize =0;
        List<Integer> lst = new ArrayList<>();
        while(true){
            if(index == progresses.length) break;
            int size = 0;
            for(int i =0; i<progresses.length; i++){
                progresses[i] += speeds[i];
            }
            boolean flag = false;
            while(true){
                if(index == progresses.length) break;
                if(progresses[index] >= 100){
                    size++;
                    index++;
                    flag = true;
                }
                else{
                    break;
                }
            }
            
            if(flag){
                lst.add(size);
            }
        }
        int[] answer = new int[lst.size()];
        for(int i =0; i<lst.size(); i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }
}
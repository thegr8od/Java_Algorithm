import java.util.*;
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
    
        List<Integer> lst = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int num : arr){
            queue.add(num);
        }
        
        
        int lastNum = 99999;
        for(int i=0; i<arr.length; i++){
            int now = queue.poll();
            if(lastNum != now){
                lst.add(now);
                
            }
            lastNum = now;
        }
        
        int[] answer = new int[lst.size()];
        for(int i=0; i<lst.size(); i++){
            answer[i] = lst.get(i);
        }
        

        return answer;
    }
}
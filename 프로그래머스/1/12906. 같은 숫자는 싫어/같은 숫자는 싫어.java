import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> lst = new ArrayList<>();
        int lastNum = 99;
        for(int i =0; i<arr.length; i++){
            queue.add(arr[i]);
        }
        
        for(int i=0; i<arr.length; i++){
            int num = queue.poll();
            if(num != lastNum){
                lst.add(num);
                lastNum = num;
            }
        }
        
        int[] answer = new int[lst.size()];
        for(int i =0; i<lst.size();i++){
            answer[i] = lst.get(i);
        }

        return answer;
    }
}
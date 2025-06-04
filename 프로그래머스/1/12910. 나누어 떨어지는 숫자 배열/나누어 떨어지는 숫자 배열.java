import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> lst = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                lst.add(arr[i]);
            }
        }
        
        int size = lst.size();
        Collections.sort(lst);
        
        if(size == 0){
            return new int[] {-1}; 
        }
        else{
            int[] answer = new int[size];

            for(int i =0; i<size; i++){
                answer[i] = lst.get(i);
            }

            return answer;
        }
    }
}
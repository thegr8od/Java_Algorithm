import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int oneIdx = 0;
        int twoIdx = 0;
        int threeIdx = 0;
        
        int oneC = 0;
        int twoC = 0;
        int threeC = 0;
        for(int num : answers){
            if(one[oneIdx++ % 5] == num) oneC++;
            if(two[twoIdx++ % 8] == num) twoC++;
            if(three[threeIdx++ % 10] == num) threeC++;
        }
        
        int maxC = Math.max(oneC, Math.max(twoC, threeC));
        List<Integer> lst = new ArrayList<>();
        
        if(maxC == oneC) lst.add(1);
        if(maxC == twoC) lst.add(2);
        if(maxC == threeC) lst.add(3);
        
        
        
        int[] answer = new int[lst.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }
}
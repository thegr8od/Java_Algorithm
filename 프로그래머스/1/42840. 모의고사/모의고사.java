import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1,2,3,4,5}; //5
        int[] two = {2,1,2,3,2,4,2,5}; //8
        int[] three = {3,3,1,1,2,2,4,4,5,5}; //10
        
        int oneC = 0;
        int twoC = 0;
        int threeC = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i%5]) oneC++;
            if(answers[i] == two[i%8]) twoC++;
            if(answers[i] == three[i%10]) threeC++;
        }
        
        int maxC = Math.max(oneC, Math.max(twoC, threeC));
        
        List<Integer> lst = new ArrayList<>();
        
        if(oneC == maxC) lst.add(1);
        if(twoC == maxC) lst.add(2);
        if(threeC == maxC) lst.add(3);
        
        int[] answer = new int[lst.size()];
        
        for(int i=0; i<lst.size(); i++){
            answer[i] = lst.get(i);
        }
        
        
        
        
        return answer;
    }
}
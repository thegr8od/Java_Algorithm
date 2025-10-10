import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        Set<Integer> set = new HashSet<>();
        
        for(int number : numbers){
            set.add(number);
        }
        
        for(int num : set){
            answer -= num;
        }
        return answer;
    }
}
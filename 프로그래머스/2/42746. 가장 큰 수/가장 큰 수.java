import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] ans = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            ans[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(ans, (a,b) -> (b+a).compareTo(a+b));
        for(int i=0; i<ans.length; i++){
            answer += ans[i];
        }
        
        if(ans[0].equals("0")){
            return "0";
        }
        else{
        return answer;
        }
        }
    
    
}
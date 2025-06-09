import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = {"30", "3", "36", "34", "6", "33", "31"};
        Arrays.sort(str, (a,b) -> b.compareTo(a));
        for(String s : str){
            System.out.println(s);
        }
        String[] ans = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            ans[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(ans, (a,b) -> (b+a).compareTo(a+b));
           
        //347, 56, 32
        
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
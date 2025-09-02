import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                deque.push('(');
            }
            else if(s.charAt(i) == ')'){
                if(deque.size() != 0){
                    deque.pop();
                }
                else{
                    return answer;
                }
            }
        }
        
        if(deque.size() == 0){
            answer = true;
        }
        
        return answer;
        
    
    }
}
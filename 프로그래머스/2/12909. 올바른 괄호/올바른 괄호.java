import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == '('){
                deque.add('(');
            }
            else if(s.charAt(i) == ')' && deque.size() != 0){
                if(deque.peekLast() == '('){
                    deque.pop();
                }
                else{
                      System.out.println("안됨");
                    answer = false;
                    
                }
            }
            else{
                answer = false;
            }
        }
        
        if(deque.size() != 0){
            answer= false;
        }
        

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
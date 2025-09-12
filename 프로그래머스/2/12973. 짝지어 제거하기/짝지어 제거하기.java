import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char a =s.charAt(i);
            if(deque.size() >= 1){
                if(deque.peek() == a){
                    deque.pop();
                }
                else{
                    deque.push(a);
                }
            }
            else{
                deque.push(a);
            }
            
        }
        
        if(deque.size() == 0){
            answer = 1;
        }
        else{
            answer =0;
        }

        return answer;
    }
}
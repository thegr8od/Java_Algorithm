import java.util.*;

class Solution {
    
    public int solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> ori = new ArrayDeque<>();
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            ori.add(s.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            deque = new ArrayDeque<>(ori);
            Deque<Character> chk = new ArrayDeque<>();
            boolean flag = false;
            for(int j=0; j<s.length(); j++){
                Character now = deque.pop();
                if(now == '(' || now == '{' || now == '['){
                    chk.push(now);
                }
                else{
                    if(chk.size() == 0){
                        flag = true;
                        break;
                    }
                    if(now==')'){
                        if(chk.pop() !='('){
                            flag = true;
                            break;
                        }
                    }
                    else if(now==']'){
                        if(chk.pop() !='['){
                            flag = true;
                            break;
                        }
                    }
                    else{
                        if(chk.pop() !='{'){
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(!flag && chk.size() == 0){
                answer++;
            }
            Character next = ori.pop();
            ori.add(next);
        }
        

        
        return answer;
    }
}
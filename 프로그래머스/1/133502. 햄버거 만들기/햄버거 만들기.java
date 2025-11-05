import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<ingredient.length; i++){
            stack.push(ingredient[i]);
            
            if(ingredient[i] == 1 && stack.size() >= 4){
                int one = stack.pop();
                int two = stack.pop();
                int three = stack.pop();
                int four = stack.pop();
                
                if(one == 1 && two == 3 && three == 2 && four == 1){
                    answer++;
                }
                else{
                    stack.push(four);
                    stack.push(three);
                    stack.push(two);
                    stack.push(one);
                    
                }
                
            }
        }
        
        return answer;
    }
}
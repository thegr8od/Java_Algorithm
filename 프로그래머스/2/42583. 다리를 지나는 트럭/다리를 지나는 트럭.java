import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        int sum = 0;
        
        for(int t : truck_weights) {
            
            while(true){
                //큐가 비어있다면
                if(q.isEmpty()){
                    q.add(t);
                    sum += t;
                    answer++;
                    break;
                }
                //큐의 사이즈와 다리의 길이가 같다면
                else if (q.size() == bridge_length){
                    sum -= q.poll();
                }
                //큐가 비어있지 않을 때
                else {
                    if(sum+t > weight){
                        q.offer(0);
                        answer++;
                    }
                    
                    else {
                        q.add(t);
                        sum += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}
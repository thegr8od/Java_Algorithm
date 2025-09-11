import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for(String oper : operations){
            String[] cur = oper.split(" ");
            if(cur[0].equals("I")){
                pq1.add(Integer.parseInt(cur[1]));
                pq2.add(Integer.parseInt(cur[1]));
            }
            else{
                if(cur[1].equals("1") && !pq1.isEmpty()){
                    pq1.remove(pq2.poll());
                }
                else if(cur[1].equals("-1") && !pq2.isEmpty()) {
                    pq2.remove(pq1.poll());
                }
            }
        }
        
        int min = pq1.isEmpty() ? 0 : pq1.poll();
        int max = pq2.isEmpty() ? 0 : pq2.poll();
        answer[0] = max;
        answer[1] = min;
        return answer;
    }
    // -45, 653, -642, 45, 97, 333
    // 
}
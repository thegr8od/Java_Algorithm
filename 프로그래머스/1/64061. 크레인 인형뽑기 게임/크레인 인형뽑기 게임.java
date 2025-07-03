import java.util.*;

class Solution {
    static int answer;
    public int solution(int[][] board, int[] moves) {
        
        int x = board.length;
        int y = board[0].length;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        
        for(int num : moves){
            for(int i = 0; i<x; i++){
                if(board[i][num-1] != 0){
                    check(dq, board[i][num-1]);
                    board[i][num-1] = 0;
                    break;
                }
            }
        }
        
        return answer*2;
    }
    
    public void check(Deque<Integer> dq, int now){
        if(dq.size()>0 && dq.peek() == now){
            dq.poll();
        
            answer++;
        }
        else{
            dq.push(now);
        }
    }
}
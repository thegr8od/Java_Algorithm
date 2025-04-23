import java.util.*;

class Solution {
    public int solution(String name) {
        int len = name.length();
        int answer = 0;
        
        for (int i =0; i< len; i++){
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
        }
        
        int move = len - 1;
        
        for (int i=0; i< len; i++){
            int next = i + 1;
            while (next < len && name.charAt(next) =='A'){
                next++;
            }
            
            // 현재 위치까지 갔다가 돌아와서 끝까지 가는 경우
            move = Math.min(move, i*2+len - next);
            // 반대로 끝까지 갔다가 돌아와서 i까지 가는 경우
            move = Math.min(move, (len - next) * 2 + i);
        }
        
        return answer + move;
    }
}
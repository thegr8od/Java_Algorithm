import java.util.*;


class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> maxScore = new ArrayList<>();
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int f_idx = 0;
        int s_idx = 0;
        int t_idx = 0;
        int f_cnt =0;
        int s_cnt =0;
        int t_cnt = 0;
        
        for(int i =0; i<answers.length; i++){
            if(f_idx >4){
                f_idx = 0;
            }
            if(s_idx>7){
                s_idx = 0;
            }
            if(t_idx>9){
                t_idx = 0;
            }
            if(first[f_idx] == answers[i]){
                f_cnt++;
                System.out.println("하이");
            }
            if(second[s_idx] == answers[i])
                s_cnt++;
            if(third[t_idx] == answers[i])
                t_cnt++;
            
            f_idx++;
            s_idx++;
            t_idx++;
            
        }

        int maxVal = Math.max(t_cnt, Math.max(f_cnt, s_cnt));
        
        if(maxVal == f_cnt){
            maxScore.add(1);
        }
        if(maxVal == s_cnt){
            maxScore.add(2);
        }
        if(maxVal == t_cnt){
            maxScore.add(3);
        }

        int[] answer = new int[maxScore.size()];
        for (int i =0; i<answer.length; i++){
            answer[i] = maxScore.get(i);
        }
        
        return answer;
    }
}
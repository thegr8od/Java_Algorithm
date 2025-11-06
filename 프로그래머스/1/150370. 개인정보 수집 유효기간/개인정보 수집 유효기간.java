import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> lst = new ArrayList<>();
        String[] todays = today.split("\\.");
        int year = Integer.parseInt(todays[0]);
        int month = Integer.parseInt(todays[1]);
        int day = Integer.parseInt(todays[2]);
        
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] te = term.split(" ");
            map.put(te[0], Integer.parseInt(te[1]));
        }
        
        
        int index = 1;
        
        for(String privacy : privacies){
            String[] pri = privacy.split("\\.");
            int nowY = Integer.parseInt(pri[0]);
            int nowM = Integer.parseInt(pri[1]);
            String[] dayA = pri[2].split(" ");
            int nowD = Integer.parseInt(dayA[0]);
            String time =dayA[1];
            
            nowM += map.get(time);
            nowD--;
            
            if(nowM > 12){
                nowY += nowM/12;
                nowM = nowM%12;
                if(nowM == 0){
                    nowM = 12;
                    nowY -= 1;
                }
            }
            
            if(nowD < 1){
                nowD = 28;
                nowM -= 1;
            }
            
            
            if(nowY < year || (nowY == year && nowM < month) || (nowY == year && nowM == month && nowD < day)){
                lst.add(index);
            }
            
            index++;
        }
        
        int[] answer = new int[lst.size()];
        
        int hi = 0;
        for(int num : lst){
            answer[hi++] = num;
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] data = new Integer[citations.length];
        
        for (int i =0; i<citations.length; i++){
            data[i] = citations[i];
        }
        
        Arrays.sort(data);
        int last_num = data[data.length-1];
        
    
        for (int i=0; i<last_num; i++){
            int h = 0;
            int cnt = 0;
            int r_cnt = 0;
            for(int j=0; j<data.length; j++){
                if(data[j]>=i){
                    cnt++;
                }
                else{
                    r_cnt++;
                }
            }
            if (cnt>=i && r_cnt<=i){
                answer = i;
            }
        
        }
        return answer;
        }
        

}

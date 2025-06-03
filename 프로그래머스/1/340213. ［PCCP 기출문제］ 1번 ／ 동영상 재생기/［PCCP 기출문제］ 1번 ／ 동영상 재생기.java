class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] len2 = video_len.split(":");
        int len = Integer.parseInt(len2[0]) * 60 + Integer.parseInt(len2[1]);
    
        String[] now2 = pos.split(":");
        int now = Integer.parseInt(now2[0]) * 60 + Integer.parseInt(now2[1]);        
        
        
        String[] opS2 = op_start.split(":");
        int opS = Integer.parseInt(opS2[0]) * 60 + Integer.parseInt(opS2[1]); 
        
        String[] opE2 = op_end.split(":");
        int opE = Integer.parseInt(opE2[0]) * 60 + Integer.parseInt(opE2[1]); 
        if(now>= opS && now<= opE){
                now = opE;
            
        }
        
        for(String s : commands){
            if(s.equals("next")){
                now += 10;
                if(now>len) {
                        now = len;
                    }
                }
                
            
            else{
                now -= 10;
                if(now<0){
                    now = 0;
                }
            }
            if(now>= opS && now<= opE){
                now = opE;
            }
            
          
        }
        
        String hour ="";
        String minute ="";
        
        if(now/60 < 10) {
            hour = "0" + String.valueOf(now/60);
        }
        else{
            hour = String.valueOf(now/60); 
        }
        
        if(now%60 < 10) {
            minute = "0" + String.valueOf(now%60);
        }
        else{
            minute = String.valueOf(now%60); 
        }
        
        answer = hour + ":" + minute;
        return answer;
    }
}
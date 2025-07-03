class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i=1; i<=s.length()/2; i++){
            String end = "";
            String now = "";
            int idx = 0;
            int cnt = 1;
            
            for (int j = 0; j < i; j++) {
                if (idx >= s.length()) break;
                now += s.charAt(idx++);
            }
            
            while (idx < s.length()){
                String temp = "";
                for (int j=0; j<i; j++){
                    if (idx >= s.length()) break;
                    temp += s.charAt(idx++);
                }
                
                if(now.equals(temp)) {
                    cnt++;
                } else{
                    if(cnt > 1) end += String.valueOf(cnt) + now;
                    else end += now;
                    now = temp;
                    cnt = 1;
                    
                }
            }
            
            if(cnt>1) end += String.valueOf(cnt) + now;
            else end += now;
            
            answer = Math.min(answer, end.length());
        }
        return answer;
    }
}
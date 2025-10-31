class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            
            if(now == ' '){
                cnt = 0;
                answer += ' ';
                continue;
            }
            else{
                
                if(cnt%2 == 0){
                    now = Character.toUpperCase(now);
                    answer += now;
                    cnt++;
                }
                else{
                    now= Character.toLowerCase(now);
                    answer += now;
                    cnt++;
                }
            
            }
        }
        return answer;
    }
}
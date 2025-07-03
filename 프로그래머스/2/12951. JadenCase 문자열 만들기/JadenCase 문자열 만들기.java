class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] splitS = s.split(" ");
        for(String now : splitS){
            if(now.length() == 0){
                answer += " ";
            }
            else{
                if(now.charAt(0) >= 'A' && now.charAt(0) <= 'Z'){
                    answer += Character.toUpperCase(now.charAt(0));
                }
                else if(now.charAt(0) >= 'a' && now.charAt(0) <= 'z'){
                    answer += Character.toUpperCase(now.charAt(0));
                }
                else{
                    answer += now.charAt(0);
                }
                
                for(int i=1; i<now.length(); i++){
                    answer += Character.toLowerCase(now.charAt(i));
                }
                answer += " ";
            }
        }

        if (!s.endsWith(" ")) {
            answer = answer.substring(0, answer.length() - 1);
        }

        return answer;
    }
}
class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                idx = 0;
                answer += ' ';
                continue;
            }
            else if(idx%2 == 0){
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    char alp = Character.toUpperCase(s.charAt(i));
                    answer += alp;
                }
                else{
                    answer += s.charAt(i);
                }
                idx++;
                System.out.println(i + " " + idx);
            }
            else{
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    char alp = Character.toLowerCase(s.charAt(i));
                    answer += alp;
                }
                else{
                    answer += s.charAt(i);
                }
                idx++;
                System.out.println(i + " " + idx);
            }
            

        }
        return answer;
    }
}
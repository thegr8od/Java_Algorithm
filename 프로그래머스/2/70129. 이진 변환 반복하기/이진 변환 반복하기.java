class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int turn = 0;
        int idx = 0;
        while(true){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    sb.append('1');
                }
                else{
                    zero++;
                }
            }
            
            int len = sb.length();
            StringBuilder sb2 = new StringBuilder();
           
            while(len > 0){
                sb2.insert(0, len%2);
                len = len/2;
            }
            s = sb2.toString();
            turn++;
            
            if(s.length() == 1){
                break;
            }
            
        }
   
        answer[0] = turn;
        answer[1] = zero;
        
        
        
        return answer;
    }
}
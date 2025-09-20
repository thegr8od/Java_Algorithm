import java.util.*;

class Solution {
    public String solution(String new_id) {

        StringBuilder sb = new StringBuilder(new_id);
        //1단계
        for (int i=0; i<sb.length(); i++){
            if(isAlp(sb.charAt(i)) && Character.isUpperCase(sb.charAt(i))){
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            }
        }
        
        //2단계
        for (int i=0; i<sb.length(); i++){
            if(!isPos(sb.charAt(i)) && !isAlp(sb.charAt(i))){
                sb.setCharAt(i, '!');
            }
        }
        
        //3단계

        boolean prevDot = false;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '.') {
                if (prevDot) {
                    sb.setCharAt(i, '!');
                } else {
                    prevDot = true;
                }
            } else if (ch == '!'){
                
            } 
            else {
                prevDot = false;
            }
        }

        System.out.println(sb + " 점바꾸기");
        int idx = 0;
        
        //4단계
        while(idx<sb.length()){
            if((sb.charAt(idx) != '.' && sb.charAt(idx) != '!')){
                break;
            }
            else{
                sb.setCharAt(idx++, '!');
            }
        }
        System.out.println(sb);
        idx = sb.length()-1;
        while(idx>=0){
            if((sb.charAt(idx) != '.' && sb.charAt(idx) != '!')){
                break;
            }
            else{
                sb.setCharAt(idx--, '!');
            }
        }
        
       
        String answer = "";
        
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) !='!'){
                answer += sb.charAt(i);
            }
        }
        
         //5단계
        if(answer.length() == 0){
            answer += 'a';
        }
        System.out.println(answer);
        if(answer.length()>=16){
            answer = answer.substring(0,15);
            if(answer.charAt(14) == '.'){
                answer = answer.substring(0,14);
            }
        }
        
        if(answer.length() <=2){
            char c = answer.charAt(answer.length()-1);
            while(true){
                 answer += c;
                 if(answer.length() == 3) break;
             }
        }
        System.out.println(answer);
        return answer;
    }
    
    static boolean isAlp (char ch){
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        } 
        else {
            return false;
        }
    }
    
    static boolean isPos (char ch){
        if (ch == '_' || ch == '-' || ch == '.' || (ch >= '0' && ch <= '9') ) {
            return true;
        } 
        else {
            return false;
        }
    }
}
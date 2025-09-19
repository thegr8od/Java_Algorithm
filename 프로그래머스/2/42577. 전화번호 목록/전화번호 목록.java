import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        
        for(String str : phone_book){
            set.add(str);
        }
        
        for(String str : phone_book){
            String now = "";
            for(int i=0; i<str.length(); i++){
                now += str.charAt(i);
                if(set.contains(now) && !now.equals(str)){
                    answer =false;
                    return answer;
                }
            }
        }
        return answer;
    }
}
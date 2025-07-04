import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        for(String number : phone_book){
            set.add(number);
        }
        
        for(String number : phone_book){
            for(int i=0; i<number.length(); i++){
                if(set.contains(number.substring(0,i))){
                    answer = false;
                }
            }
        }
        
        return answer;
    }
}
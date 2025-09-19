import java.util.*;

class Solution {
    static char[] alp = {'A','E','I','O','U'};
    static List<String> lst;
    static int answer, d;
    public int solution(String word) {
        lst = new ArrayList<>();
        dfs("", word);
        return answer;
    }
    
    static void dfs(String now, String word){
        
        if(now.equals(word)){
            answer = d;
            return;
        }
        
        if(now.length() < 5){
            for(int i=0; i<5; i++){
                d++;
                dfs(now+alp[i], word);
            }
        }
        
    }
}
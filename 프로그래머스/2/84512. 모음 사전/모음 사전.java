import java.util.*;

class Solution {
    static char[] alp = {'A','E','I','O','U'};
    static List<String> lst = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        dfs(0,"");
        
        for(int i=0; i<lst.size(); i++){
            if(lst.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    static void dfs(int d, String now){
        
        if(d>5){
            return;
        }
        
        lst.add(now);

        
        for(int i=0; i<5; i++){
            dfs(d+1,now+alp[i]);
        }
    }
}
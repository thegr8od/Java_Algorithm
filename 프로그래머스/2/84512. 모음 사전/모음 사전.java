import java.util.*;

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static List<String> lst;
    public int solution(String word) {
        int answer = 0;
        lst = new ArrayList<>();
        dfs("",0);
        for(int i=0; i<lst.size(); i++){
            if(word.equals(lst.get(i))){
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public void dfs (String now, int d){
        
        lst.add(now);
        
        if(d==5){
            return;
        }
        
        for(int i=0; i<5; i++){
            dfs(now+words[i], d+1);
        }
    }
}
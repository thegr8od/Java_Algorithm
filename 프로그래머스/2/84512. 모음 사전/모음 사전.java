import java.util.*;

class Solution {
    static String[] chars = {"A", "E", "I", "O", "U"};
    static ArrayList<String> lst = new ArrayList<>();
    public int solution(String word) {
        dfs("",0);
        Collections.sort(lst);
        return lst.indexOf(word) + 1;
    }
    
    static void dfs(String current, int depth){
        
      if (depth > 5) return;
    
        if (!current.isEmpty()) {
            lst.add(current);
        }
        
        for (int i =0; i < chars.length; i++){
            dfs(current + chars[i], depth + 1);
        }
    }   
}

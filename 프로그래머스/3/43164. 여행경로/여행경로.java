import java.util.*;

class Solution {
    static int size;
    static List<List<String>> answerLst;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        answerLst = new ArrayList<>();
        Set<String> set = new HashSet<>();
        visited = new boolean[tickets.length];
   
        
        dfs("ICN", tickets, new ArrayList<String>(), 0);
        
        String[][] lstAnswer = new String[answerLst.size()][answerLst.get(0).size()];

        
        for(int i=0; i<answerLst.size(); i++){
            for(int j=0; j<answerLst.get(0).size(); j++){
                lstAnswer[i][j] = answerLst.get(i).get(j);
            }
        }
    
            Arrays.sort(lstAnswer, (a,b) -> {
                for(int i=0; i<a.length; i++){
                    if(!a[i].equals(b[i])) return a[i].compareTo(b[i]);
                }
                return 0;
            });
  
        
        answer = lstAnswer[0];
        

        

        
        
        return answer;
    }
    
    
    static void dfs(String start,  String[][] tickets, List<String> lst, int d) {
        
        lst.add(start);
        
        if(d == tickets.length){
            answerLst.add(lst);
            return;
        }
        
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], tickets, new ArrayList<>(lst), d+1);
                visited[i] = false;
            }    
        }

        
    }
}
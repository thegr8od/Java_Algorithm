import java.util.*;

class Solution {
    static Set<Integer> set;
    public int[] solution(int[] numbers) {
        set = new HashSet<>();
        dfs(0,0,0,numbers);
        
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int num : set){
            answer[idx++] = num;
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    static void dfs(int d, int sum, int start, int[] numbers){
        
        if(d==2){
            set.add(sum);
            return;
        }
        
        for(int i=start; i<numbers.length; i++){
            dfs(d+1, sum+numbers[i], i+1, numbers);
        }
    }
}
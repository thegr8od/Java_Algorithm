import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] visited = new boolean[people.length];
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        int count =0;
        
        if(people.length == 1){
            return 1;
        }
        
        while(start<=end){
            if(people[start] + people[end] <= limit) {
                break;
            }
            else{
                 end--;
            }
         
        }
        
        System.out.println(end);
        
        while(start<end){
            if(people[start] + people[end] <= limit){
                visited[start] = true;
                visited[end] = true;
                start++;
                end--;
                count++;
            }
            else{
                end--;
            }
        }
        
        
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) count++;
        }
        
        System.out.println(count);
        return count;
        
        
        
        
    }
}
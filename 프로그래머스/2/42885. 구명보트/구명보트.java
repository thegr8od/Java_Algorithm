import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int cnt = 0;
        while(start<end){
            if(people[start] + people[end] <= limit){
                cnt++;
                start++;
                end--;
            }
            else{
                end--;
            }
            
        }
        return people.length - cnt;
    }
}
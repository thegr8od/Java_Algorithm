import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int idx = 0;
        int cnt = 1;
        char prev = words[0].charAt(0);
        for(String word : words){
            idx++;
            if(idx > n){
                cnt++;
                idx=1;
            }
            if(prev != word.charAt(0)){
                return new int[] {idx,cnt};
            }
            if(set.contains(word)){
                return new int[]{idx,cnt};
            }
            set.add(word);
            prev = word.charAt(word.length()-1);
        }
        int[] answer = new int[] {0,0};
        return answer;
    }
}
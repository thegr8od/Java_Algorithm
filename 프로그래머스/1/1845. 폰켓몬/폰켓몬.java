import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int n : nums){
            set.add(n);
        }
        
        int len = nums.length / 2;
        int size = set.size();
        
        if(size >= len) {
            return len;
        } else{
            return size;
        }
        
        
    }
}
class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target,0);
        return answer;
    }
    
    static void dfs(int idx, int d, int[] numbers, int target, int sum){
        if(d==numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        dfs(idx+1, d+1, numbers, target, sum+numbers[idx]);
        dfs(idx+1, d+1, numbers, target, sum-numbers[idx]);
    }
}
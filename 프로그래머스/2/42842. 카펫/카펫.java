class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int allCnt = brown + yellow;
        
        for(int i=3; i<allCnt; i++){
            int row = i;
            int col = allCnt / row;
            
            if((row-2) * (col-2) == yellow){
                answer[0] = row;
                answer[1] = col;
            }
            
            
            
            
        }
        
        return answer;
    }
}
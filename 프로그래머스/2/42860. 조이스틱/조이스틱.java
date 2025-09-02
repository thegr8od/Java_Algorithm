class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int index;
        int move = length - 1;
        
        for(int i=0; i<name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            index = i+1;
            
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }
            
            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이도수가 적은 것을 선택
            move = Math.min(move, i*2 + length - index);
            // 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려
            move = Math.min(move, (length-index) * 2 + i);
        }
        
        return answer + move;
    }
}
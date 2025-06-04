import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // n편 중, h번 이상 인용된 논문이 h편 이상, 나머지 논문이 h번 이하 인용
        // h의 최댓값 구하기
        Arrays.sort(citations);
        int n = 0;
        while(true){
            int count = 0;
            for(int i=citations.length-1; i>=0; i--){
                if(citations[i] >= n){
                    count++;
                }
                else{
                    break;
                }
            }
            if(count>=n && citations.length - count <= n){
                answer = Math.max(answer, n);
                n++;
            }
            else{
                break;
            }
            
        }
        
        return answer;
    }
}
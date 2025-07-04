import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int n = 0;
        while (true) {
            int count = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= n) {
                    count++;
                }
            }
            if (count >= n && citations.length - count <= n) {
                answer = Math.max(answer, n);
                n++;
            } else {
                break;
            }
        }
        return answer;
    }
}

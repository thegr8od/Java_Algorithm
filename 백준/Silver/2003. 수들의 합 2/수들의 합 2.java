
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int left = 0, right = 1;
        int cnt = 0;
        
        while (right <= n && left <= right) {
            // 부분 합 계산
            int sum = 0;
            for (int i = left; i < right; i++) {
                sum += nums[i];
            }
            
            if (sum == m) {
                cnt++;
                right++;
            } else if (sum < m) {
                right++;
            } else {
                left++;
            }
        }
        
        System.out.println(cnt);
        
        scanner.close();
    }
}
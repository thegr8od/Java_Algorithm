
import java.util.Scanner;

public class Solution {
	static int N,B,ans;
	static int[] arr;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			ans = Integer.MAX_VALUE;
			arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			isSelected = new boolean[N];
			subset(0);
			System.out.println("#"+tc+" " + ans);
			
		}
	}
	
	static void subset(int d) {
		
		if(d == N) {
			int sum = 0;
			for (int i =0; i<N; i++) {
				if(isSelected[i]) sum += arr[i];
			}
			if (sum>=B) {
			ans = Math.min(ans, sum-B);
			}
			return;
		}
		
		
		
			
		isSelected[d] = true;
		subset(d+1);
		isSelected[d] = false;
		subset(d+1);
	}
}



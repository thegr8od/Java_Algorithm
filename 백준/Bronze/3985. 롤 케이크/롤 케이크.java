import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[L+1];
		int who = Integer.MAX_VALUE;
		int ans = 0;
		int num = 0;
		int cnt = 0;
		for (int i =1; i<=N; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			int now = k-p;
			int nowC = 0;
			if (now > ans) {
				ans = now;
				num = i;
			}
			for(int j=p; j<=k; j++) {
				if (arr[j] == 0) {
					arr[j] = i;
					nowC++;
				}
			}
			if (nowC > cnt) {
				cnt = nowC;
				who = i;
			}
				
		}
		
		System.out.println(num);
		System.out.println(who);
	}
}

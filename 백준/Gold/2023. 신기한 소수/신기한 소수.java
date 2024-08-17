import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs(0,0);
		System.out.println(sb);
	}
	
	static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i=2; i<=Math.sqrt(num); i++) {
			if (num % i ==0) return false;
		}
		return true;
	}
	
	static void dfs(int output, int d) {
		if (d == N) {
			if (isPrime(output)) {
				sb.append(output).append("\n");
				return;
			}
		}
		for (int i =0; i<10; i++) {
			int next = output*10 + i;
			if (isPrime(next)) {
				dfs(next, d+1);
			}
		}
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,L,ans;
	static int[] T,K;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t =1; t<=TC; t++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		T = new int[N];
		K = new int[N];
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			K[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		dfs(0,0,0);
		System.out.println("#" + t + " "+ ans);
		
		}
	}
	
	static void dfs(int x, int score, int kal) {
		
		
		if (kal > L) {
			return;
		}
		
		if (score >= ans) {
			ans = score;
		}
		
		if (x == N) {
			return;
		}
		
		dfs(x+1, score + T[x] , kal + K[x]);
		dfs(x+1, score, kal);
	}
}

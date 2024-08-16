
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] sour,bit;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bit = new int[N];
		for (int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bit[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,1,0,0);
		System.out.println(ans);
		
	}
	
	static void dfs(int d, int s, int b, int cnt) {
		
		
		if (d == N) {
			if (cnt > 0) {
			int score = Math.abs(s-b);
			ans = Math.min(ans, score);			
			}
			return;
		}
		
		dfs(d+1, s*sour[d], b+bit[d], cnt+1);
		dfs(d+1, s, b,cnt);
		
	}
	
	
//	static void dfs(int x, int score, int kal) {
//		
//		
//		if (kal > L) {
//			return;
//		}
//		
//		if (score >= ans) {
//			ans = score;
//		}
//		
//		if (x == N) {
//			return;
//		}
//		
//		dfs(x+1, score + T[x] , kal + K[x]);
//		dfs(x+1, score, kal);
//	}
	}


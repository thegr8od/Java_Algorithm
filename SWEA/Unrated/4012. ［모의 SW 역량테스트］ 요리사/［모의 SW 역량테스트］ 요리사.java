
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T,N, ans;
	static int[][] arr;
	static int[] numbers;
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			numbers = new int[N];
			for (int i =0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0,1);
			System.out.println("#"+t + " " + ans);
		}
	}
	
	static void dfs(int d, int start) {
		if(d == N/2) {
			ans = Math.min(ans, cal());
			return;
		}
		
		
		for(int i =start; i<N; i++) {
			numbers[d] = i;
			dfs(d+1, i+1);
		}
	}
	
	static int cal() {
		boolean[] selected = new boolean[N];
		
		for (int i =0; i<N/2; i++) {
			selected[numbers[i]] = true;
		}
		int A = 0;
		int B = 0;
		
		for (int i =0; i<N; i++) {
			for (int j =i+1; j<N; j++) {
				if (selected[i] && selected[j]) {
					A += arr[i][j] + arr[j][i];
				} else if (!selected[i] && !selected[j]) {
					B += arr[i][j] + arr[j][i];
				}
			}
		}
		
		return Math.abs(A-B);
	}
	
	
}

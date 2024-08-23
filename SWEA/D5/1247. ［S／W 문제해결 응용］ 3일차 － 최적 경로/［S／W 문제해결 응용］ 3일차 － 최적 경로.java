import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int T,N;
	static boolean[] visited;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc =1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			arr = new int[N+2][2];
			visited = new boolean[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[0][0] = Integer.parseInt(st.nextToken());
			arr[0][1] = Integer.parseInt(st.nextToken());
			
			arr[N+1][0] = Integer.parseInt(st.nextToken());
			arr[N+1][1] = Integer.parseInt(st.nextToken());
			
			for (int i=1; i<=N ; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,arr[0][0],arr[0][1],0);
			System.out.println("#" + tc + " "+ min);
		}
	}
	
	static void dfs(int d, int x, int y, int len) {
		
		if(d == N) {
			len = len + calc(x,y,arr[N+1][0], arr[N+1][1]);
			if (len < min) {
				min = len;
			}
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(d +1 , arr[i][0], arr[i][1], len + calc(x,y, arr[i][0], arr[i][1]));
				visited[i] = false;
			}
		}
	}
	
	
	static int calc(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}

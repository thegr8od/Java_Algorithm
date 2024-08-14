import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr;
	public static int N,M;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(1,0);
		System.out.println(sb);
		
	}
	
	public static void dfs(int now, int depth) {
		if (depth == M) {
			for(int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = now; i<=N; i++) {
			arr[depth] = i;
			dfs(i+1,depth+1);
		}
		
	}
}

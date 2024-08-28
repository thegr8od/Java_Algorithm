import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int ans = 0;
	static List<Integer> list;
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		list = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		edge = new ArrayList[N];
		
		for (int i =0; i< N; i++) {
			edge[i] = new ArrayList<>();
		}
		
		for (int i =0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a].add(b);
			edge[b].add(a);
		}
		
		for (int i =0; i<N;i++) {
			if (ans != 1) dfs(i,1);
		}
		
		System.out.println(ans);
		
		
	}
	
	static void dfs(int start, int depth) {
		if (depth == 5) {
			ans = 1;
			return;
		}
		visited[start] = true;
		for (int to : edge[start]) {
			if(!visited[to]) {
				dfs(to, depth + 1);
			}
		}
		visited[start] = false;
	}
}

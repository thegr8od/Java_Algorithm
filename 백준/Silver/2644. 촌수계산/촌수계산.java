

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,m, start, target;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int result = -1;
	
	public static void dfs(int v, int cnt) {
		visited[v] = true;
		if (v == target) {
			result = cnt;
			return;
		}
		
		for (int i : graph.get(v)) {
			if(!visited[i]) {
				dfs(i,cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		target  = Integer.parseInt(st.nextToken());
		m  = Integer.parseInt(br.readLine());
		
		// 그래프 초기화
		for(int i =0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited = new boolean[n+1];
		
		dfs(start, 0);
		
		System.out.println(result);
	}

}

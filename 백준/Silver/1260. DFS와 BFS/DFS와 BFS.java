import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] graph;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 접전
		int M = sc.nextInt(); // 간선
		int V = sc.nextInt(); // 시작
		
		graph = new int[N+1][N+1];
		
		for(int i =0; i<M; i++) {
			int a = sc.nextInt();
			int b= sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
		System.out.println();
	}
	
	static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start + " ");
		
		if(start == graph.length) return;
		
		for(int i =1; i<graph.length; i++) {
			if(graph[start][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		System.out.print(start + " ");
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for(int i =1; i<graph.length; i++) {
				if(graph[n][i] == 1 && visited[i] == false) {
					visited[i] = true;
					System.out.print(i + " ");
					queue.offer(i);
				}
			}
		}
	}
}
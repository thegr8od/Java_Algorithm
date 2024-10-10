

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans, N, M, fkSum;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j,0,0);
				fk(i,j);
			}
		}
		System.out.println(ans);
	}

	static void dfs(int x, int y, int d, int sum) {


		if (d == 4) {
			ans = Math.max(sum, ans);
			return;
		}
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
				dfs(nx, ny, d + 1, sum + map[x][y]);
			}
		}
		visited[x][y]= false;
	}

	static void fk(int x, int y) {
		int min =Integer.MAX_VALUE;
		int d = 0;
		int fkSum = map[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				fkSum += map[nx][ny];
				d++;
				if(min > map[nx][ny]) {
					min = map[nx][ny];
				}
			}
		
		}
		if(d==4) {
			fkSum -= min;
		}
		
		ans = Math.max(ans, fkSum);
	}
}

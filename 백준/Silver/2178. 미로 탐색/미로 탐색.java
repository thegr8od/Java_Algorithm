import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i<N; i++) {
			String str = br.readLine();
			for (int j =0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int res = bfs(0,0);
		System.out.println(res);
		
	}
	
	
	static int bfs(int x, int y) {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.offer(new Pair(x,y));
		map[x][y] = 1;
		
		while(!queue.isEmpty()) {
			Pair current = queue.poll();
			x = current.x;
			y = current.y;
			
			for (int i =0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx <0 || ny <0 || nx >= N || ny >= M) {
					continue;
				}
				
				if (map[nx][ny] == 0) {
					continue;
				}
				if (map[nx][ny] == 1) {
					map[nx][ny] = map[x][y] + 1;
					queue.offer(new Pair(nx,ny));
				}
			}
		}
		
		return map[N-1][M-1];
		
	}
	
	static class Pair{
		public int x,y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

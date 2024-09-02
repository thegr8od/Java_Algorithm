import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//제출용
public class Main {
	static int m, n, k;
	static boolean[][] map;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new boolean[m][n];
		
		while(k --> 0) {
			st = new StringTokenizer(br.readLine());
			int x, y, ex, ey;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < ex; i++) {
				for(int j = y; j < ey; j++) {
					map[j][i] = true;
				}
			}
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!map[i][j]) {
					res.add(bfs(i, j));
				}
			}
		}
		Collections.sort(res);
		
		StringBuilder sb = new StringBuilder();
		sb.append(res.size()).append("\n");
		for(int i : res) {
			sb.append(i).append(" ");
		}
		sb.append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bfs(int y, int x) {
		int cnt = 0; 
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(y, x));
		map[y][x] = true;
		cnt++;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			y = p.y;
			x = p.x;
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
				if(map[ny][nx]) continue;
				cnt++;
				map[ny][nx] = true;
				q.offer(new Pos(ny,nx));
			}
		}
		
		return cnt;
	}
	
	static class Pos{
		int y, x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
}

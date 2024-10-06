import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		if(N-1 == 0 && M-1 == 0) {
			System.out.println(1);
			return;
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		
		char[][] miro = new char[N][M]; // 미로 배열
		int[][] dist = new int[N][M]; // 거리 측정 배열
		boolean[][][] visit = new boolean[2][N][M]; // 벽을 부순 여부에 따라 방문 여부 기록
		Queue<int[]> que = new ArrayDeque<>();
		
		for (int i =0; i<N; i++) {
			String s = br.readLine();
			for(int j =0; j<M; j++) {
				miro[i][j] = s.charAt(j);
			}
		}
		
		que.offer(new int[] {0,0,0});
		
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx <0 || nx >= N || ny <0 || ny >= M) {
					continue;
				}
				
				if (miro[nx][ny] == '1') {
					if(cur[2] == 0 && !visit[1][nx][ny]) {
						visit[cur[2]][nx][ny] = true;
						dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
						que.offer(new int[] {nx,ny,1});
					}
				}
				
				else {
					if(!visit[cur[2]][nx][ny]) {
						visit[cur[2]][nx][ny] = true;
						dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
						que.offer(new int[] {nx,ny,cur[2]});
						
					}
				}
				
				if(nx == N-1 && ny == M-1) {
					System.out.println(dist[nx][ny] + 1);
					return;
				}
			}
		}
		
		System.out.println(-1);
		
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static boolean[][][] visited;
	static Node start;
	static int N,M, ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][64];
		
		for (int i = 0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') start = new Node(i,j,0,0);
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(start.x,start.y,0,0));
		visited[start.x][start.y][0] = true;
		
		while(!que.isEmpty()) {
			
			Node node = que.poll();
			int x = node.x;
			int y = node.y;
			int cnt = node.cnt;
			int key = node.key;
			
			if(map[x][y] == '1') {
				return cnt;
			}
			
			for(int i=0; i<4; i++) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny <0 || ny >= M) continue;
				if(visited[nx][ny][key] || map[nx][ny] == '#') continue;
				
				if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					int next_key = 1 << (map[nx][ny] - 'a');
					next_key = key | next_key;
					visited[nx][ny][next_key] = true;
					que.offer(new Node(nx,ny,cnt+1, next_key));

				}
				else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					if((key & 1 << (map[nx][ny] - 'A')) != 0) {
						visited[nx][ny][key] = true;
						que.offer(new Node(nx,ny,cnt+1, key));
					}
				} else {
					visited[nx][ny][key] = true;
					que.offer(new Node(nx,ny,cnt+1, key));
				}
				
				
				
			}
		}
		return -1;
	}
}

class Node{
	int x;
	int y;
	int cnt;
	int key;
	
	
	public Node(int row, int col, int cnt, int key) {
		super();
		this.x = row;
		this.y = col;
		this.cnt = cnt;
		this.key = key;
	}
	
	

}

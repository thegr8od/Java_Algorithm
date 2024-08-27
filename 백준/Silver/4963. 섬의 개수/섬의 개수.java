import java.util.Scanner;

public class Main {

	static int[][] graph;
	static boolean[][] visited;
	static int w, h;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if (w==0 && h ==0) {
				break;
			}
			
			graph = new int[h][w];
			visited = new boolean[h][w];
			
			// 그래프 입력
			for (int i =0; i<h; i++) {
				for(int j =0; j<w; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			int res = 0;
			
			for(int i =0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if (graph[i][j] == 1  && !visited[i][j]) {
						dfs(i,j);
						res++;
					}
				}
			}
			System.out.println(res);
		}

	}
	
	static void dfs(int x, int y) {
		// 범위 확인
		if (x<0 || x>=h || y<0 || y>=w) {
			return;
		}
		
		// 이미 방문했거나 1이 아닌 경우
		if(graph[x][y] == 0 || visited[x][y]) {
			return;
		}
		
		visited[x][y] = true;
		
		//8방향  탐색
		dfs(x-1,y);
		dfs(x-1,y+1);
		dfs(x,y+1);
		dfs(x+1,y+1);
		dfs(x+1,y);
		dfs(x+1,y-1);
		dfs(x,y-1);
		dfs(x-1,y-1);
	}
}

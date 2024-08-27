import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] graph;
	static boolean[][] visited;
	static int N,danji, maxV;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j =0; j<N; j++) {
				graph[i][j] = str.charAt(j) - '0';
				
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j =0; j<N; j++) {
				maxV=0;
				if(graph[i][j] == 1 && !visited[i][j]) {
					int cnt = dfs(i,j,0);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int count : list) {
		System.out.println(count + " ");
		}
	}
	
	  static int dfs(int x, int y, int count) {
	        // 현재 위치가 유효한지 확인
	        if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || graph[x][y] == 0) {
	            return count;
	        }
	        
	        // 현재 집 방문 처리
	        visited[x][y] = true;
	        
	        // 단지의 크기 카운트 (현재 집 포함)
	        count++;
	        
	        // 4방향 탐색
	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            count = dfs(nx, ny, count); // 재귀 호출하여 연결된 집의 수를 더함
	        }
	        
	        return count;
	    }
	}


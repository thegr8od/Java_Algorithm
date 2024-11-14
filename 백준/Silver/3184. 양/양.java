import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int sheep, wolf,r,c;
	static int nowS, nowW;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        visited = new boolean[r][c];
        
        map = new char[r][c];
        for (int i=0 ;i<r; i++) {
        	String cmd = br.readLine();
        	for (int j=0; j<c; j++) {
        		map[i][j] = cmd.charAt(j);
        		if(map[i][j] == 'o') sheep++;
        		if(map[i][j] == 'v')wolf++;
        		if(map[i][j] == '#') {
        			visited[i][j] = true;
        	
        		}
        	}
        }
        
        
        for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if((visited[i][j] == false) && map[i][j] == 'v') {
					nowS = 0;
					nowW = 0;
					dfs(i,j);
					
					if(nowS > nowW) {
						wolf -= nowW;
					}
					else {
						sheep -= nowS;
					}
				}
			}
		}
        
        System.out.println(sheep + " " + wolf);
        
        
        
        
        
    }
    
    static void dfs(int x, int y) {
    	visited[x][y] = true;
    	
    	if(map[x][y] == 'o') nowS++;
		if(map[x][y] == 'v') nowW++;
    	
    	for(int i=0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if (nx >=0 && nx<r && ny>=0 && ny<c) {
    			if (!visited[nx][ny]) {
    				dfs(nx,ny);
    			}
    		}
    	}
    	
    }
}
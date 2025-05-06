import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Array;
import java.util.*;


public class Main {
    static int R, C;
    static int answer = 1;
    static int cnt;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int max = 100001;
    static boolean[] visited = new boolean[max];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i =0; i<R; i++){
            String now = br.readLine();
            for (int j=0; j<C; j++){
                map[i][j] = now.charAt(j) - 'A';
            }
        }
        dfs(0,0,0);

        System.out.println(answer);


    }

    static void dfs(int x, int y, int depth){

        if(visited[map[x][y]]){
            answer = Math.max(answer, depth);
            return;
        }
        else{
            visited[map[x][y]] = true;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && nx<R && ny>=0 && ny<C){
                    dfs(nx,ny, depth+1);
                }
            }
            visited[map[x][y]] = false;
        }

    }


}




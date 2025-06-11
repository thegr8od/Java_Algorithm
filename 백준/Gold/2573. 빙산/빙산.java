import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, count;
    static StringTokenizer st;
    static int[][] map;
    static int[][] nowMap;
    static boolean[] visited;
    static int beer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        nowMap = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            count++;
            int num = 0;
            boolean flag = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    nowMap[i][j] = map[i][j];
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] != 0){
                        melt(i,j);
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    nowMap[i][j] = map[i][j];
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(nowMap[i][j] !=0){
                        dfs(i,j);
                        flag = true;
                        num++;
                    }
                }
            }

            if(num>1){
                break;
            }

            if(!flag){
                count = 0;
                break;
            }

        }

        System.out.println(count);

    }

    static void dfs(int x, int y) {

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                if(nowMap[nx][ny] !=0){
                    nowMap[nx][ny] = 0;
                    dfs(nx,ny);
                }
            }
        }
    }

    static void melt(int x, int y){

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                if(nowMap[nx][ny] == 0){
                    if(map[x][y]>0){
                        map[x][y]--;
                    }
                }
            }
        }
    }
}
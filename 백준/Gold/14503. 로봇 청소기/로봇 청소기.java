import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static int[][] map;
    static int N,M;
    static int x, y, dir;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        if(dir==1){
            dir=3;
        }
        else if(dir==3){
            dir = 1;
        }
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(map[x][y] == 0){
                map[x][y] = 2;
                cnt++;
            }
            int flag = 0;
            int oriDir = dir;
            for(int i=1 ;i<5; i++){
                dir = (oriDir+i)%4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(map[nx][ny] == 0){
                        flag++;
                        x = nx;
                        y = ny;
                        break;
                    }
                }
            }

            if(flag == 0){
                int qx = x - dx[dir];
                int qy = y - dy[dir];
                if(qx>=0 && qx<N && qy>=0 && qy<M) {
                    if (map[qx][qy] == 1) break;
                    else{
                        x = qx;
                        y = qy;
                    }
                }

            }
        }

        System.out.println(cnt);
    }


}

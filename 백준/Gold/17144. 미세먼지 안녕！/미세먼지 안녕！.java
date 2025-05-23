import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    static int R,C,T;
    static int[][] oriData;
    static int[][] nowData;
    static int[][] data;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int uX, uY;
    static int dX, dY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        oriData = new int[R][C];
        nowData = new int[R][C];
        data = new int[R][C];
        int flag = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                oriData[i][j] = Integer.parseInt(st.nextToken());
                if(oriData[i][j] == -1){
                    if(flag ==0) {
                        uX = i;
                        flag++;
                    }
                    else{
                        dX = i;
                    }
                }
            }
        }




        while(T-- >0) {
            data[uX][0] = -1;
            data[dX][0] = -1;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (oriData[i][j] != 0 && oriData[i][j] != -1) {
                        mise(i, j);
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    nowData[i][j] = data[i][j];
                }
            }


            cleanUp();
            cleanDown();


            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    oriData[i][j] = nowData[i][j];
                }
            }

            data = new int[R][C];

        }
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += nowData[i][j];
            }
        }
        System.out.println(answer + 2);

    }

    static void mise(int x, int y) {
        int cnt = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<R && ny>=0 && ny<C){
                if(oriData[nx][ny] != -1 && data[nx][ny] != -1) {
                    data[nx][ny] += oriData[x][y] / 5;
                    cnt++;
                }
            }
        }
        data[x][y] += oriData[x][y] - (oriData[x][y]/5) * cnt;

    }


    static void cleanUp(){
        nowData[uX][1] = 0;
        for(int i = 2; i<C; i++){
            nowData[uX][i] = data[uX][i-1];
        }
        for(int i=uX-1; i>=0; i--){
            nowData[i][C-1] = data[i+1][C-1];
        }
        for(int i=C-1; i>0; i--){
            nowData[0][i-1] = data[0][i];
        }
        for(int i=1; i<uX; i++){
            nowData[i][0] = data[i-1][0];
        }

    }

//    7 8 1
//            1 0 0 0 5 4 3 9
//            2 0 0 0 3 0 0 8
//            -1 0 5 0 0 0 22 0
//            -1 8 0 0 0 0 0 0
//            0 0 0 0 0 10 43 2
//            2 0 5 0 15 0 0 1
//            3 0 40 0 0 0 20 3

    static void cleanDown(){
        nowData[dX][1] = 0;
        for(int i = 2; i<C; i++){
            nowData[dX][i] = data[dX][i-1];
        }
        for(int i=dX+1; i<R; i++){
            nowData[i][C-1] = data[i-1][C-1];
        }
        for(int i=C-1; i>0; i--){
            nowData[R-1][i-1] = data[R-1][i];
        }
        for(int i=R-2; i>dX; i--){
            nowData[i][0] = data[i+1][0];
        }
    }
}
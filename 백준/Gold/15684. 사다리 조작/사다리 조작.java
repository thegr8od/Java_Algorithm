import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M, H, answer;
    static int[][] map;
    static int minV;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로선 col
        M = Integer.parseInt(st.nextToken()); //놓여있는 가로선
        H = Integer.parseInt(st.nextToken()); //가로선 row
        answer = 4;
        map = new int[H+2][N+2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        dfs(0,1,1);
        System.out.println(answer == 4 ? -1 : answer);

    }

    static void dfs(int d, int x, int y){
        if(d>3 || d>answer) return;

        if(isCorrect()){
            answer = Math.min(answer, d);
        }

        for(int i=x; i<=H; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j] == 0 && map[i][j-1] ==0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    dfs(d+1, i,j);
                    map[i][j] = 0;
                }
            }
        }
    }

    static boolean isCorrect(){
        for(int i=1; i<=N; i++){
            int col = i;
            int row = 1;
            while(true){
                if(row > H) break;

                if(map[row][col -1] == 1){
                    col -=1;
                }
                else if(map[row][col] == 1){
                    col +=1;

                }
                row++;

            }
            if(col != i) return false;
        }
        return true;
    }



}

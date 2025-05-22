import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    static int N,M, x, y;
    static int[][] data;
    static int[][] dice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = 0;
        dice = new int[4][3];
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int num = Integer.parseInt(st.nextToken());
            diceRun(num);
        }




    }

    static void diceRun(int num){
        if(num == 1){
            int nx = x;
            int ny = y+1;
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                int temp01 = dice[0][1];
                int temp10= dice[1][0];
                int temp11 = dice[1][1];
                int temp12 = dice[1][2];
                int temp21 = dice[2][1];
                int temp31 = dice[3][1];

                dice[1][0] = temp31;
                dice[1][1] = temp10;
                dice[1][2] = temp11;
                dice[3][1] = temp12;

                if(data[nx][ny] == 0){
                    data[nx][ny] = dice[3][1];
                }
                else{
                    dice[3][1] = data[nx][ny];
                    data[nx][ny] = 0;
                }

                System.out.println(dice[1][1]);

                y = y+1;
            }
        }

        if(num == 2){
            int nx = x;
            int ny = y-1;
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                int temp01 = dice[0][1];
                int temp10= dice[1][0];
                int temp11 = dice[1][1];
                int temp12 = dice[1][2];
                int temp21 = dice[2][1];
                int temp31 = dice[3][1];

                dice[1][0] = temp11;
                dice[1][1] = temp12;
                dice[1][2] = temp31;
                dice[3][1] = temp10;

                if(data[nx][ny] == 0){
                    data[nx][ny] = dice[3][1];
                }
                else{
                    dice[3][1] = data[nx][ny];
                    data[nx][ny] = 0;
                }

                System.out.println(dice[1][1]);

                y = y-1;
            }
        }


        if(num == 3){
            int nx = x-1;
            int ny = y;
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                int temp01 = dice[0][1];
                int temp10= dice[1][0];
                int temp11 = dice[1][1];
                int temp12 = dice[1][2];
                int temp21 = dice[2][1];
                int temp31 = dice[3][1];

                dice[0][1] = temp11;
                dice[1][1] = temp21;
                dice[2][1] = temp31;
                dice[3][1] = temp01;

                if(data[nx][ny] == 0){
                    data[nx][ny] = dice[3][1];
                }
                else{
                    dice[3][1] = data[nx][ny];
                    data[nx][ny] = 0;
                }

                System.out.println(dice[1][1]);

                x = x-1;

            }
        }


        if(num == 4){
            int nx = x+1;
            int ny = y;
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                int temp01 = dice[0][1];
                int temp10= dice[1][0];
                int temp11 = dice[1][1];
                int temp12 = dice[1][2];
                int temp21 = dice[2][1];
                int temp31 = dice[3][1];

                dice[0][1] = temp31;
                dice[1][1] = temp01;
                dice[2][1] = temp11;
                dice[3][1] = temp21;

                if(data[nx][ny] == 0){
                    data[nx][ny] = dice[3][1];
                }
                else{
                    dice[3][1] = data[nx][ny];
                    data[nx][ny] = 0;
                }

                System.out.println(dice[1][1]);

                x = x+1;



            }
        }



    }
}



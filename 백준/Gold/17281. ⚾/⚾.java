import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,answer;
    static int[] lineUp;
    static boolean[] visited;
    static int[][] hit;
    static List<Integer> lst;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hit = new int[N][9];
        lineUp = new int[9];
        visited = new boolean[9];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                hit[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        lineUp[3] = 0; // 라인업
        visited[0] = true; // 뽑혔는지
        perm(0);

        System.out.println(answer);




    }

    static void perm(int d){

        if(d == 9){
            playBall(lineUp);
            return;
        }

        if(d == 3){
            perm(d+1);
            return;
        }


        for(int i=1; i<9; i++){
            if(visited[i]) continue;
            visited[i] = true;
            lineUp[d] = i;
            perm(d+1);
            visited[i] = false;

        }
    }

    static void playBall(int[] lineUp){
        int nowPlayer = 0;
        int nowTurn = 0;
        int score = 0;
        int outCount = 0;
        boolean[] onFiled = new boolean[3];

        while(nowTurn < N){


            if(nowPlayer == 9){
                nowPlayer = 0;
            }

            if(hit[nowTurn][lineUp[nowPlayer]] == 0){
                outCount++;
                if(outCount == 3){
                    for(int i=0; i<3; i++){
                        onFiled[i] = false;
                    }
                    outCount = 0;
                    nowTurn++;
                }
                nowPlayer++;

            }
            else if(hit[nowTurn][lineUp[nowPlayer]] == 1){
                for(int i=2; i>=0; i--){
                    if(i==2 && onFiled[i]){
                        score++;
                        onFiled[2]= false;
                    }
                    else if(onFiled[i]) {
                        onFiled[i] = false;
                        onFiled[i+1] = true;
                    }

                }
                onFiled[0] = true;
                nowPlayer++;
            }
            else if(hit[nowTurn][lineUp[nowPlayer]] == 2){
                for(int i=2; i>=0; i--){
                    if(i>0 && onFiled[i]){
                        score++;
                        onFiled[i]= false;
                    }
                    else if(onFiled[i]) {
                        onFiled[i] = false;
                        onFiled[i+2] = true;
                    }

                }
                onFiled[1] = true;
                nowPlayer++;
            }
            else if(hit[nowTurn][lineUp[nowPlayer]] == 3){
                for(int i=2; i>=0; i--){
                    if(onFiled[i]){
                        score++;
                        onFiled[i] = false;
                    }

                }
                onFiled[2] = true;
                nowPlayer++;
            }
            else{
                for(int i=2; i>=0; i--){
                    if(onFiled[i]){
                        score++;
                        onFiled[i] = false;
                    }

                }
                score++;
                nowPlayer++;
            }
        }

        answer = Math.max(answer,score);


    }






}

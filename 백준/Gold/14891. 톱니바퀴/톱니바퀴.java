    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        static StringTokenizer st;
        static int data[][];
        static int[] dy = {-1, 0, 1};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            data = new int[4][8];

            for (int i = 0; i < 4; i++) {
                String s = br.readLine();
                for (int j = 0; j < 8; j++) {
                    data[i][j] = s.charAt(j) - '0';
                }
            }
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                check(idx, dir);
            }
            int answer =0;
            for(int i=0; i<4; i++){
                answer += data[i][0] * (int) Math.pow(2,i);
            }
            System.out.println(answer);


        }

        static void check(int idx, int dir){
            if(idx == 1){
                int cnt =0;
                int oriDir = dir;
                for(int i=0; i<3; i++){
                    if(data[i][2] != data[i+1][6]){
                        cnt++;
                    }
                    else {
                        break;
                    }
                }
                for(int i=0; i<cnt; i++){
                        turn(i+1, dir);
                        if(dir==1) dir=-1;
                        else{dir=1;}
                }
                turn(idx-1,-oriDir);
            }
            else if(idx == 4) {
                int cnt = 0;
                int oriDir = dir;
                for (int i = 3; i > 0; i--) {
                    if (data[i - 1][2] != data[i][6]) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                for (int i = 3; i > 3 - cnt; i--) {
                    turn(i - 1, dir);
                    if (dir == 1) dir = -1;
                    else {
                        dir = 1;
                    }
                }
                turn(idx-1,-oriDir);
            }

            else if(idx == 2){
                if(data[1][6] != data[0][2]){
                    turn(0, dir);
                }
                int oriDir = dir;
                int cnt =0;
                for(int i=1; i<3; i++){
                    if(data[i][2] != data[i+1][6]){
                        cnt++;
                    }
                    else {
                        break;
                    }
                }
                for(int i=1; i<cnt+1; i++){
                    turn(i+1, dir);
                    if(dir==1) dir=-1;
                    else{dir=1;}
                }
                turn(idx-1,-oriDir);
            }
            else{
                if(data[2][2] != data[3][6]){
                    turn(3, dir);
                }
                int cnt = 0;
                int oriDir = dir;
                for (int i = 2; i > 0; i--) {
                    if (data[i - 1][2] != data[i][6]) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                for (int i = 2; i > 2 - cnt; i--) {
                    turn(i - 1, dir);
                    if (dir == 1) dir = -1;
                    else {
                        dir = 1;
                    }
                }
                turn(idx-1,-oriDir);
            }

        }

        static void turn(int idx, int dir){
            if(dir==1){
                int temp = data[idx][0];
                for(int i=1; i<=7; i++){
                    data[idx][i-1] = data[idx][i];
                }
                data[idx][7] = temp;
            }
            else{
                int temp = data[idx][7];
                for(int i=7; i>0; i--){
                    data[idx][i] = data[idx][i-1];
                }
                data[idx][0] = temp;
            }
        }

       
    }

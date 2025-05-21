import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static List<int[]> order1;
    static List<int[]> order2;
    static int[][] num;
    static int[][] map;
    static int[][] data;
    static int[] order;
    static int answer;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int times = N*N;
        data = new int[times+1][4];
        map = new int[N+1][N+1];
        order = new int[times+1];
        for(int i=0; i<times; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            order[i] = now;
            for(int j=0; j<4; j++){
                int like = Integer.parseInt(st.nextToken());
                data[now][j] = like;
            }
        }


        for(int n : order){
            order1 = new ArrayList<>();
            findLike(n);
            if(order1.size()==1){
                int[] now = order1.get(0);
                int x = now[0];
                int y = now[1];
                map[x][y] = n;
            }
            else {
                order2 = new ArrayList<>();
                emptyNum();
                if(order2.size()>0){
                    int now[] = order2.get(0);
                    int x = now[0];
                    int y = now[1];
                    map[x][y] = n;
                }

            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 1 && nx < N+1 && ny >= 1 && ny < N+1) {
                            for (int n : data[map[i][j]]) {
                                if (map[nx][ny] == n) {
                                    cnt++;
                                }
                            }
                        }



                    }
                if(cnt == 1){
                    answer += 1;
                } else if (cnt == 2){
                    answer += 10;
                } else if (cnt == 3){
                    answer += 100;
                } else if (cnt == 4){
                    answer += 1000;
                }
                }



        }

        System.out.println(answer);
    }


    static void findLike(int student) {
        int maxV = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 1 && nx < N+1 && ny >= 1 && ny < N+1) {
                            for (int n : data[student]) {
                                if (map[nx][ny] == n) {
                                    cnt++;
                                }
                            }
                        }
                        maxV = Math.max(maxV, cnt);


                    }
                }
            }

        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 1 && nx < N+1 && ny >= 1 && ny < N+1) {
                            for (int n : data[student]) {
                                if (map[nx][ny] == n) {
                                    cnt++;
                                }
                            }
                        }

                    }
                    if (cnt == maxV) {
                        order1.add(new int[]{i, j});
                    }
                }


            }


        }
    }


    static void emptyNum() {
        int maxV = 0;
        for(int[] now : order1){
            int cnt=0;
            int x = now[0];
            int y = now[1];
                for(int i=0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx>=1 && nx<N+1 && ny>=1 && ny<N+1){
                        if(map[nx][ny]==0){
                            cnt++;
                        }
                    }
                }
                maxV = Math.max(maxV,cnt);
        }
        for(int[] now : order1){
            int cnt=0;
            int x = now[0];
            int y = now[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=1 && nx<N+1 && ny>=1 && ny<N+1){
                    if(map[nx][ny]==0){
                        cnt++;
                    }
                }
            }
            if(cnt == maxV) {
                order2.add(new int[] {x,y});
            }

        }



    }

}
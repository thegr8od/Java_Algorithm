import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    static int V,N,M;
    static int[] dx ={0,-1,-1,-1,0,1,1,1};
    static int[] dy ={-1,-1,0,1,1,1,0,-1};
    static int[][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<int[]> lst = new ArrayList<>();
        data = new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        lst.add(new int[] {N,1});
        lst.add(new int[] {N,2});
        lst.add(new int[] {N-1,1});
        lst.add(new int[] {N-1,2});

        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            List<int[]> preList = move(dir, s, lst);
            lst = find(preList);
        }
        int answer = 0;
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                answer += data[i][j];
            }
        }
        System.out.println(answer);

        
    }

    static ArrayList<int[]> move(int dir, int s, List<int[] > lst){
        ArrayList<int[]> lst2 = new ArrayList<>();
        for(int[] now : lst){
            int x = now[0];
            int y = now[1];
            for(int i=0; i<s; i++){
                x += dx[dir-1];
                y += dy[dir-1];
                if(x>N) x = 1;
                if(x<1) x = N;
                if(y>N) y = 1;
                if(y<1) y = N;
            }
            data[x][y] += 1;
            lst2.add(new int[] {x,y});
        }

        for(int[] now : lst2){
        }
        for(int[] now : lst2){
            update(now[0],now[1]);
        }

        return lst2;
    }

    static void update(int x, int y){
        for(int i=1; i<8; i+=2){
            int nx = x +dx[i];
            int ny = y +dy[i];
            if(nx>=1 && nx<N+1 && ny>=1 && ny<N+1) {
                if (data[nx][ny] > 0) {
                    data[x][y] += 1;
                }
            }
        }


    }

    static List<int[]> find(List<int[]> prev){
        List<int[]> lst = new ArrayList<>();
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(data[i][j] >= 2){
                    int flag = 0;
                    for(int[] now : prev){
                        int a= now[0];
                        int b= now[1];
                        if(i==a && j==b){
                            flag++;
                            break;
                        }
                    }
                    if(flag ==0){
                        data[i][j] -= 2;
                        lst.add(new int[]{i, j});
                    }

                }
            }
        }


        return lst;
    }
}



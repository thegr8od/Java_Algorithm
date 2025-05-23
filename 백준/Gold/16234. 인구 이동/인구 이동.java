import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    static int N,L,R;
    static int[][] data;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] dice;
    static boolean[][] visited;
    static boolean flag;
    static int cnt;
    static List<int[]> lst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true) {
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        lst = new ArrayList<>();
                        dfs(i,j);
                        int sum = 0;
                        if(lst.size()>1){
                            for(int[] now : lst){
                                sum += data[now[0]][now[1]];
                                flag = true;
                            }
                            for(int[] now : lst){
                                data[now[0]][now[1]] = sum / lst.size();
                            }
                        }


                    }
                }
            }
            if(!flag) break;
            else{cnt++;}

            flag = false;
        }

        System.out.println(cnt);

        //1. dfs -> visited 써서 방문했는지 안했는 지, 그 뒤 visited true 없으면
        //return 현재 카운트
        //2. true 있으면, flag한다음에 나누기로 배치
        //3. 다시 dfs -> visited


    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        lst.add(new int[]{x,y});

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                if(Math.abs(data[x][y]-data[nx][ny]) >= L && Math.abs(data[x][y]-data[nx][ny]) <= R){
                    dfs(nx,ny);

                }
            }
        }
    }
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static StringTokenizer st;
    static int[][] data;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int zeroCnt;
    static int ans = Integer.MAX_VALUE;
    static List<int[]> lst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lst = new ArrayList<>();
        data = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int now = Integer.parseInt(st.nextToken());
                data[i][j] = now;
                if(now == 2){
                    lst.add(new int[]{i,j});
                } else if (now == 0){
                    zeroCnt++;
                }
            }
        }

        if(zeroCnt == 0) {
            System.out.println(0);
        } else{
            comb(0,0,new ArrayList<>());
            if(ans == Integer.MAX_VALUE){
                System.out.println(-1);
            } else{
                System.out.println(ans);
            }
        }


    }

    static void bfs(List<int[]> virus){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int leftZero = zeroCnt;

        for (int[] now : virus){
            queue.add(new int[]{now[0],now[1], 0});
            visited[now[0]][now[1]] = true;
        }

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int time = now[2];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny] || data[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny,time+1});

                if(data[nx][ny] == 0){
                    leftZero--;
                    if(leftZero == 0){
                        ans = Math.min(ans, time+1);
                        return;
                    }
                }
            }
        }
    }

    static void comb(int d, int start, List<int[]> temp) {
        if (d == M){
            bfs(temp);
            return;
        }

        for(int i=start; i<lst.size(); i++){
            temp.add(lst.get(i));
            comb(d+1,i+1,temp);
            temp.remove(temp.size()-1);
        }


    }


}

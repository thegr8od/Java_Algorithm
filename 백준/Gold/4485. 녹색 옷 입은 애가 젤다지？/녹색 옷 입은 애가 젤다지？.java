import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,1,0,-1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 0;
        while(true){
            tc++;
        N = Integer.parseInt(br.readLine());
        if(N == 0) break;
        map = new int[N][N];
        dist = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                dist[i][j] = Integer.MAX_VALUE;
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = dijkstar(0,0,N-1, N-1);
        System.out.println("Problem "+tc+ ": " +answer);

            }
    }

    static int dijkstar(int startX, int startY, int endX, int endY){

        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]
        ));
        dist[startX][startY] = map[startX][startY];
        pq.add(new int[] {startX,startY, dist[startX][startY]});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowX = cur[0];
            int nowY = cur[1];
            int cost = cur[2];

            if(dist[nowX][nowY] < cost) continue;

            for(int i=0; i<4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N){
                    if(dist[nx][ny] > map[nx][ny] + cost){
                        dist[nx][ny] = map[nx][ny] + cost;
                        pq.add(new int[] {nx,ny, dist[nx][ny]});
                    }
                }
            }
        }

        return dist[endX][endY];


    }







}

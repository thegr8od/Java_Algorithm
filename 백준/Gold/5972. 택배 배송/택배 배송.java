import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int n,m;
    static int maxV = 1000000000;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[] dist;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        dist = new int[n+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
            dist[i] = maxV;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[] {b,c});
            graph[b].add(new int[] {a,c});

        }

        System.out.println(dijkstar(1, n));

    }

    static int dijkstar(int start, int end){

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        dist[start] = 0;
        pq.add(new int[] {start, dist[start]});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int time = cur[1];

            if(time > dist[now]) continue;

            for(int[] num : graph[now]){
                int to = num[0];
                int cost = num[1];

                if(dist[to] > dist[now] + cost){
                    dist[to] = dist[now] + cost;
                    pq.add(new int[]{to, dist[to]});
                }
            }
        }



        return dist[end];
    }

}

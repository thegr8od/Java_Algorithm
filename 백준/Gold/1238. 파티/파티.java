import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X;
    static int maxV = 1000000000;
    static StringTokenizer st;
    static int[] dist;
    static int[] dist2;
    static List<int[]>[] graph;
    static List<int[]>[] graph2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        graph2 = new ArrayList[N+1];
        dist = new int[N+1];
        dist2 = new int[N+1];


        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
            dist[i] = maxV;
            graph2[i] = new ArrayList<>();
            dist2[i] = maxV;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
            graph2[b].add(new int[]{a,c});
        }

        dijkstra(X, graph, dist);
        dijkstra(X, graph2, dist2);

        int maxTime = 0;
        for(int i=1; i<=N; i++){
            maxTime = Math.max(maxTime, dist[i] + dist2[i]);
        }

        System.out.println(maxTime);







    }

    static void dijkstra(int start, List<int[]>[] graph, int[] dist){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        dist[start] = 0;
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int now = cur[0];
            int time = cur[1];

            if (dist[now] < time) continue;

            for (int[] next : graph[now]){
                int to = next[0];
                int cost = next[1];

                if(dist[to] > dist[now] + cost){
                    dist[to] = dist[now] + cost;
                    pq.add(new int[] {to, dist[to]});
                }
            }
        }
    }



}



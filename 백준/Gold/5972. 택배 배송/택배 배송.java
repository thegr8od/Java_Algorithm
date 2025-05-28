import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int maxV = 1000000000;
    static StringTokenizer st;
    static int[] dist;
    static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = maxV;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
        }

        System.out.println(dijkstar(1, N));

    }

    static int dijkstar(int start, int end ) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int time = cur[1];

            if (dist[now] < time) continue;

            for (int[] next : graph[now]) {
                int to = next[0];
                int cost = next[1];
                if (dist[to] > dist[now] + cost) {
                    dist[to] = dist[now] + cost;
                    pq.offer(new int[]{to, dist[to]});
                }
            }

        }
        return dist[end];
    }

}

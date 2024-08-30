import java.util.*;

public class Solution {
    static int v, e;
    static List<Edge>[] edges;
    static PriorityQueue<Edge> q;

    static class Edge {
        int x,y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            v = sc.nextInt();
            e = sc.nextInt();
            edges = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                edges[i] = new ArrayList<>();
            }

            //최소 힙 비교
            q = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge e1, Edge e2) {
                    return Integer.compare(e1.y, e2.y); 
                }
            });

            for (int i = 0; i < e; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();

                edges[x].add(new Edge(y, w)); // x에서 y로 가는 엣지
                edges[y].add(new Edge(x, w)); // y에서 x로 가는 엣지 (무향 그래프)
            }

            boolean[] visit = new boolean[v + 1];
            q.offer(new Edge(1, 0)); 

            long ans = 0;
            
            
            while (!q.isEmpty()) {
                Edge edge = q.poll();
                int currentVertex = edge.x;
                int cost = edge.y;

                if (visit[currentVertex]) continue;

                visit[currentVertex] = true;
                ans += cost;

                for (Edge e : edges[currentVertex]) {
                    if (!visit[e.x]) {
                        q.offer(e);
                    }
                }
            }
            
            System.out.println("#" + tc + " " + ans);
        }
    }
}
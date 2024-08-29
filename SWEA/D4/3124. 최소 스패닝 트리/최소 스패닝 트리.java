import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int V, T;
    static int[] parents;

    static void make() {
        for (int i = 0; i < V; i++) {
            parents[i] = -1;
        }
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);  // 경로 압축
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        if (parents[aRoot] < parents[bRoot]) {  // Union by size
            parents[aRoot] += parents[bRoot];
            parents[bRoot] = aRoot;
        } else {
            parents[bRoot] += parents[aRoot];
            parents[aRoot] = bRoot;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            V = sc.nextInt();
            int E = sc.nextInt();

            parents = new int[V+1];
            Edge[] edges = new Edge[E];
            for (int i = 0; i < E; i++) {
                edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextLong());  // weight를 long으로 변경
            }

            Arrays.sort(edges);
            make();
            int cnt = 0;
            long cost = 0;  // 비용을 long으로 변경

            for (Edge edge : edges) {
                if (union(edge.start, edge.end)) {
                    cnt++;
                    cost += edge.weight;
                    if (cnt == V - 1) break;
                }
            }
            System.out.println("#" + tc + " " + cost);
        }
        sc.close();
    }

    static class Edge implements Comparable<Edge> {
        int start, end;
        long weight;  // weight를 long으로 변경

        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);  // long 비교로 수정
        }
    }
}

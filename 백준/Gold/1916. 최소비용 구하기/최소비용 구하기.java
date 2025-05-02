import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class Node implements Comparable<Node>{
    int end;
    int weight;

    Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}

public class Main {
    static int N,M;
    static ArrayList<ArrayList<Node>> a;
    static StringTokenizer st;
    static int[] dist;
    static boolean[] check;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        a = new ArrayList<>();
        dist = new int[N+1];
        check = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<=N; i++){
            a.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end,weight));

        }

        st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(startPos, endPos));

    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        queue.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    return dist[end];

    }

}

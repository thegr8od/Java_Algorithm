import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int maxLen, start;
    static List<Node>[] lst;
    static StringTokenizer st;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lst = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            lst[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lst[s].add(new Node(e, cost));
            lst[e].add(new Node(s, cost));

        }
        visited = new boolean[N+1];
        dfs(1, 0);

        visited = new boolean[N+1];
        dfs(start,0);
        System.out.println(maxLen);




    }

    static void dfs(int now, int len){
        visited[now] = true;
        
        if(len > maxLen){
            maxLen = len;
            start = now;
        }

        for(int i=0; i<lst[now].size(); i++){
            Node n = lst[now].get(i);
            if(!visited[n.e]){
                dfs(n.e, len+n.cost);
            }
        }



    }



}



class Node {
    int e;
    int cost;

    Node(int e, int cost){
        this.e = e;
        this.cost = cost;
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class Main {
    static int N,K;
    static int MAX = 100001;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX];
        int[] map = new int[MAX];
        bfs(N,0);
        System.out.println(answer);


    }

    public static void bfs(int start, int depth){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {start,depth});

        while(!queue.isEmpty()){

            int[] now = queue.poll();
            visited[now[0]] = true;

            if(now[0] == K){
                answer = Math.min(now[1],answer);
            }

            if(now[0]*2 >=0 && now[0]*2<MAX && !visited[now[0]*2]){
                queue.add(new int[] {now[0]*2, now[1]});
            }
            if(now[0]+1 >=0 && now[0]+1<MAX && !visited[now[0]+1]){
                queue.add(new int[] {now[0]+1, now[1]+1});
            }
            if(now[0]-1 >=0 && now[0]-1<MAX && !visited[now[0]-1]){
                queue.add(new int[] {now[0]-1, now[1]+1});
            }

        }
    }



}

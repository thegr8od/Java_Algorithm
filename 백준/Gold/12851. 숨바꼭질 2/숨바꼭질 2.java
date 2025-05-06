import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Array;
import java.util.*;


public class Main {
    static int N, K;
    static int answer = 100001;
    static int cnt;
    static int max = 100001;
    static boolean[] visited = new boolean[max];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N,0);
        System.out.println(answer);
        System.out.println(cnt);



    }

    public static void bfs(int start, int depth) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[0]] = true;

            if (now[0] == K) {
                if(now[1] <= answer){
                   cnt++;
                }
                answer = Math.min(answer, now[1]);
            }

            if (now[0]*2>=0 && now[0]*2<max && !visited[now[0]*2]){
                queue.add(new int[]{now[0]*2, now[1]+1});
            }

            if (now[0]+1>=0 && now[0]+1<max && !visited[now[0]+1]){
                queue.add(new int[]{now[0]+1, now[1]+1});
            }

            if (now[0]-1>=0 && now[0]-1<max && !visited[now[0]-1]){
                queue.add(new int[]{now[0]-1, now[1]+1});
            }


        }
    }

}

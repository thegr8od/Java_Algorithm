import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static int[][] map;
    static int N,M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);

    }

    public static void dfs(int depth){
        if(depth == 3){
            bfs();
            return;
        }

        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(map[i][j] ==0){
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){

        Queue<Node> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(map[i][j] ==2){
                    queue.add(new Node(i,j));
                }
            }
        }

        int[][] tempMap = new int[N][M];

        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                tempMap[i][j] = map[i][j];
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            for(int i =0; i<4; i++){
                int nx = x +dx[i];
                int ny = y +dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(tempMap[nx][ny]==0){
                        tempMap[nx][ny] = 1;
                        queue.add(new Node(nx,ny));
                    }
                }

            }
        }

        int cnt = 0;

        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(tempMap[i][j] == 0){
                    cnt++;
                }
            }
        }

        answer = Math.max(cnt,answer);

    }

    public static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}

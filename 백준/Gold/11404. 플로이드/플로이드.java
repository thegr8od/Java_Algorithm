import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    static int V;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dist = new int[V+1][V+1];
        for(int i=1; i<=V; i++){
            Arrays.fill(dist[i], 1000000000);
        }
        for (int i = 1; i <= V; i++) {
            dist[i][i] = 0;   // 자기 자신은 0
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[start][end] = Math.min(dist[start][end],weight);
        }

        floydWarshall();

        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++) {
                if (dist[i][j] == 1000000000) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    static void floydWarshall(){
        for(int k=1; k<=V; k++){ //중간
            for(int i=1; i<=V; i++){ //시작
                for(int j=1; j<=V; j++){ //도착
                    dist[i][j] =Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }


}



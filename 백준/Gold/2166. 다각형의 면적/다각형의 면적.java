import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        map[N][0] = map[0][0];
        map[N][1] = map[0][1];

        long sum1 = 0L;
        long sum2 = 0L;

        for(int i=0; i<N; i++){
            sum1 += (long)map[i][0] * map[i+1][1];
            sum2 += (long)map[i][1] * map[i+1][0];
        }

        System.out.printf("%.1f", Math.abs(sum1-sum2)/2.0);

    }





}

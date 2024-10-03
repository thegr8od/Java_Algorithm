
import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int maxCnt;
    static int maxV = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] map = br.readLine().toCharArray();
            for (int j = 0; j < map.length; j++) {
                if (map[j] == 'Y') {
                    arr[i][j] = 1;
                } else if (map[j] == 'N') {
                    arr[i][j] = maxV;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (0 < arr[i][j] && arr[i][j] <= 2) {
                    cnt++;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }

        System.out.println(maxCnt);
    }
}

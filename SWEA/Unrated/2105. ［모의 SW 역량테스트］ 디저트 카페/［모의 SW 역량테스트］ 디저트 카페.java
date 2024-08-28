import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] map;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {-1, 1, 1, -1};
    static boolean[][] visited;
    static boolean[] dessert;
    static int max;
    static int startX, startY;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            max = -1; 


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

           
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i < N - 2 && j > 0 && j < N - 1) {
                        visited = new boolean[N][N];
                        dessert = new boolean[101]; // 중복 체크
                        startX = i;
                        startY = j;
                        visited[i][j] = true;
                        dessert[map[i][j]] = true;
                        dfs(1, i, j, 0);
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }

    static void dfs(int cnt, int x, int y, int dir) {
        for (int d = dir; d < 4; d++) { // 이전 방향부터
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (nx == startX && ny == startY && cnt > 2) {
                    max = Math.max(max, cnt);
                    return;
                }
                if (!visited[nx][ny] && !dessert[map[nx][ny]]) {
                    visited[nx][ny] = true;
                    dessert[map[nx][ny]] = true;
                    dfs(cnt + 1, nx, ny, d);
                    visited[nx][ny] = false;
                    dessert[map[nx][ny]] = false;
                }
            }
        }
    }
}
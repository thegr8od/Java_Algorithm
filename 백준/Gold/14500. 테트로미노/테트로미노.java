import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
    static int[] dy = { 0, 0, -1, 1 };
    static int ans, N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 위치에서 DFS 및 특수 모양 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 1, map[i][j]);
                checkExtraShapes(i, j);
            }
        }

        System.out.println(ans);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        visited[x][y] = true;

        // 상하좌우로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크 및 방문 여부 확인
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
            }
        }

        visited[x][y] = false; // 백트래킹
    }

    static void checkExtraShapes(int x, int y) {
        int[][] shapes = {
            { 0, -1, 0, 1, -1, 0 }, // ㅗ
            { -1, 0, 1, 0, 0, 1 },  // ㅏ
            { 0, -1, 0, 1, 1, 0 },  // ㅜ
            { -1, 0, 1, 0, 0, -1 }  // ㅓ
        };

        for (int i = 0; i < shapes.length; i++) {
            int sum = map[x][y];
            boolean isValid = true;

            for (int j = 0; j < 3; j++) { // j는 0부터 2까지
                int nx = x + shapes[i][j * 2];
                int ny = y + shapes[i][j * 2 + 1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    sum += map[nx][ny];
                } else {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                ans = Math.max(ans, sum);
            }
        }
    }
}

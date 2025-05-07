import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;   // 원래의 adj matrix
    static int[][] path;    // 결과를 저장할 matrix
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 입력
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        path  = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2) i를 출발점으로 한 번의 DFS 수행, 방문된 곳을 path[i][…]에 1로 표시
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];  // i마다 방문 기록 초기화
            dfs(i);

            // DFS 후에 방문된 노드들을 path에 기록
            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    path[i][j] = 1;
                }
            }
        }

        // 3) 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(path[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // curr 노드에서 갈 수 있는 모든 노드를 재귀적으로 탐색
    static void dfs(int curr) {
        for (int i = 0; i < N; i++) {
            // 아직 방문 안 했고, 연결(edge)이 있으면
            if (!visited[i] && graph[curr][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}

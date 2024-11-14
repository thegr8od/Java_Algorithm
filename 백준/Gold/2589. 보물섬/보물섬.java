import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int r, c, ans;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String cmd = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = cmd.charAt(j);
            }
        }

        ans = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[r][c];
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans); 
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 0}); 

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int ax = now[0];
            int ay = now[1];
            int ad = now[2]; 

            ans = Math.max(ans, ad); 
            
            for (int i = 0; i < 4; i++) {
                int nx = ax + dx[i];
                int ny = ay + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (!visited[nx][ny] && map[nx][ny] == 'L') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, ad + 1}); 
                    }
                }
            }
        }
    }
}

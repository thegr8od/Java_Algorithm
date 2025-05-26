import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] apple;
    static int fx, fy, dir;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] turn;
    static int time;
    static int N, K, L;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        turn = new char[10001];
        apple = new boolean[N + 1][N + 1];
        fx = 1;
        fy = 1;

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apple[x][y] = true;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            char now = st.nextToken().charAt(0);
            turn[idx] = now;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{fx, fy});

        while (true) {
            time++;

            fx = fx + dx[dir];
            fy = fy + dy[dir];

            if (fx < 1 || fx > N || fy < 1 || fy > N) {
                System.out.println(time);
                return;
            }

            for (int[] snake : queue) {
                if (fx == snake[0] && fy == snake[1]) {
                    System.out.println(time);
                    return;
                }
            }

            if (apple[fx][fy]) {
                apple[fx][fy] = false;
                queue.add(new int[]{fx, fy});
            } else {
                queue.add(new int[]{fx, fy});
                queue.poll();
            }

            if (turn[time] == 'L') {
                dir = (dir + 3) % 4; // 왼쪽 회전
            } else if (turn[time] == 'D') {
                dir = (dir + 1) % 4; // 오른쪽 회전
            }
        }
    }
}



import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 x 방향
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 y 방향
    static int cs = 0; // 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0); // 7자리를 선택한다.
        System.out.println(cs);
    }

    private static void dfs(int nowDepth, int start) {
        if (nowDepth == 7) {
            if (checkLinked()) cs++;
        } else {
            // 25개의 자리 중 7개를 선택한다 
            for (int i = start; i < 25; i++) {
                visited[i / 5][i % 5] = true;
                dfs(nowDepth + 1, i + 1);
                visited[i / 5][i % 5] = false;
            }
        }
    }

    private static boolean checkLinked() {
        // 연속된 7자리에 대해서 copy
        boolean[][] cpyVisited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cpyVisited[i][j] = visited[i][j];
            }
        }

        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cpyVisited[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }
        
        // 연속된 7자리인지, 이다솜파 과반수 이상인지 확인
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        
        int cnt = 0;
        int s = 0;
        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int mvx = poll.x + dx[dir];
                int mvy = poll.y + dy[dir];

                if (0 > mvx || 5 <= mvx || 0 > mvy || 5 <= mvy) { // 범위를 넘어감
                    continue;
                }
                
                if (cpyVisited[mvx][mvy]) {
                    if (map[mvx][mvy] == 'S') s++; // 이다솜파
                    cnt++; // 연결된 사람들 확인
                    q.add(new Point(mvx, mvy));
                    cpyVisited[mvx][mvy] = false; // 방문 확인
                }
            }
        }
        if (cnt == 7 && 4 <= s) { // 7개가 연속으로 이어져 있는지, 이다솜파가 4명(과반수 이상인지)
            return true;
        }
        return false;
    }
}

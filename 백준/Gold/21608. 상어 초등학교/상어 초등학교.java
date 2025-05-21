import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static int[][] data;
    static int[] order;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int total = N * N;

        map = new int[N + 1][N + 1];
        data = new int[total + 1][4];
        order = new int[total];

        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;
            for (int j = 0; j < 4; j++) {
                data[student][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int student : order) {
            List<int[]> candidates = findLike(student);
            List<int[]> result = (candidates.size() == 1) ? candidates : findMostEmpty(candidates);
            int[] pos = result.get(0);
            map[pos[0]][pos[1]] = student;
        }

        int[] scoreTable = {0, 1, 10, 100, 1000};
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (inRange(nx, ny)) {
                        for (int like : data[map[i][j]]) {
                            if (map[nx][ny] == like) {
                                cnt++;
                                break;
                            }
                        }
                    }
                }
                answer += scoreTable[cnt];
            }
        }

        System.out.println(answer);
    }

    static List<int[]> findLike(int student) {
        List<int[]> result = new ArrayList<>();
        int maxLike = -1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0) continue;

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d], ny = j + dy[d];
                    if (inRange(nx, ny)) {
                        for (int like : data[student]) {
                            if (map[nx][ny] == like) {
                                cnt++;
                                break;
                            }
                        }
                    }
                }

                if (cnt > maxLike) {
                    result.clear();
                    maxLike = cnt;
                }

                if (cnt == maxLike) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    static List<int[]> findMostEmpty(List<int[]> positions) {
        List<int[]> result = new ArrayList<>();
        int maxEmpty = -1;

        for (int[] pos : positions) {
            int cnt = 0;
            int x = pos[0], y = pos[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (inRange(nx, ny) && map[nx][ny] == 0) {
                    cnt++;
                }
            }

            if (cnt > maxEmpty) {
                result.clear();
                maxEmpty = cnt;
            }

            if (cnt == maxEmpty) {
                result.add(new int[]{x, y});
            }
        }

        return result;
    }

    static boolean inRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }
}

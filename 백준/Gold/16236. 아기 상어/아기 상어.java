import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        if (this.x == o.x) {
            return Integer.compare(this.y, o.y);
        }
        return Integer.compare(this.x, o.x);
    }
}

public class Main {
    static int N;
    static StringTokenizer st;
    static int[][] board;
    static int size, eatCnt;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int nowX, nowY;
    static List<Node> lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        size = 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    nowX = i;
                    nowY = j;
                    board[i][j] = 0;
                } else {
                    board[i][j] = num;
                }
            }
        }

        while (true) {
            boolean[][] visited = new boolean[N][N];
            lst = new ArrayList<>();
            find(nowX, nowY, visited);
            Collections.sort(lst);

            if (lst.size() == 0) break;

            if (lst.size() == 1) {
                Node node = lst.get(0);
                int dist = bfs(nowX, nowY, node.x, node.y);
                nowX = node.x;
                nowY = node.y;
                eat(nowX, nowY);
                eatCnt++;
                if (eatCnt == size) {
                    size++;
                    eatCnt = 0;
                }
                answer += dist;
            } else {
                int bestX = -1, bestY = -1;
                int minDist = Integer.MAX_VALUE;

                for (Node node : lst) {
                    int dist = bfs(nowX, nowY, node.x, node.y);
                    if (dist == Integer.MAX_VALUE) continue;

                    if (dist < minDist) {
                        minDist = dist;
                        bestX = node.x;
                        bestY = node.y;
                    } else if (dist == minDist) {
                        if (node.x < bestX || (node.x == bestX && node.y < bestY)) {
                            bestX = node.x;
                            bestY = node.y;
                        }
                    }
                }

                if (minDist != Integer.MAX_VALUE) {
                    nowX = bestX;
                    nowY = bestY;
                    eat(nowX, nowY);
                    eatCnt++;
                    if (eatCnt == size) {
                        size++;
                        eatCnt = 0;
                    }
                    answer += minDist;
                }
            }
        }

        System.out.println(answer);
    }

    static void find(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        if (board[x][y] != 0 && board[x][y] < size) {
            lst.add(new Node(x, y));
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (!visited[nx][ny] && board[nx][ny] <= size) {
                find(nx, ny, visited);
            }
        }
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            if (x == endX && y == endY) {
                return dist[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && board[nx][ny] <= size) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static void eat(int x, int y) {
        board[x][y] = 0;
    }
}

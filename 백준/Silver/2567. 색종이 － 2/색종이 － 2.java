import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ans;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 배열 크기를 102x102로 설정하여 경계 문제를 해결
        arr = new int[102][102];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 색종이가 정사각형의 10x10
            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        // 둘레 계산
        for (int i = 1; i < 101; i++) {  // 배열의 유효 범위는 1~100
            for (int j = 1; j < 101; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        // 범위를 벗어나지 않고 인접한 셀이 흰색일 때
                        if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102 && arr[nx][ny] == 0) {
                            ans++;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
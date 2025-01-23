import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 다리 길이
        int m = Integer.parseInt(br.readLine()); // 가로등 개수
        int[] pos = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1; // 최소 높이
        int high = n; // 최대 높이
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2; // 중간값
            int covered = 0; // 현재까지 비춰진 지점
            boolean isPossible = true;

            for (int i = 0; i < m; i++) {
                if (pos[i] - mid > covered) {
                    isPossible = false;
                    break;
                }
                covered = pos[i] + mid;
            }

            if (n > covered) {
                isPossible = false;
            }

            if (isPossible) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}

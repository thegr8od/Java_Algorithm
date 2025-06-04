import java.io.*;
import java.util.*;

public class Main {
    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();

            for (int i = 0; i < N; i++) {
                set.add(br.readLine());
            }

            boolean flag = false;

            for (String key : set) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < key.length(); j++) {
                    sb.append(key.charAt(j));
                    String now = sb.toString();

                    if (!now.equals(key) && set.contains(now)) {
                        flag = true;
                        break;
                    }
                }

                if (flag) break; // 접두어 하나라도 발견 시 전체 루프 종료
            }

            System.out.println(flag ? "NO" : "YES");
        }
    }
}

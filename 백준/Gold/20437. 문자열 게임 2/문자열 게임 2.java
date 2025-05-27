import java.io.*;
import java.util.*;

public class Main {
    static int T, K;
    static final int ALPHABET = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int minV = Integer.MAX_VALUE;
            int maxV = Integer.MIN_VALUE;
            String str = br.readLine();
            K = Integer.parseInt(br.readLine());
            

            for (char c = 'a'; c <= 'z'; c++) {
                List<Integer> list = new ArrayList<>();
                for (int i=0; i<str.length(); i++) {
                    if (str.charAt(i) == c) {
                        list.add(i);
                    }
                }

                if (list.size() >= K) {
                    for (int i=0; i <= list.size() - K; i++) {
                        int len = list.get(i+K-1) - list.get(i)+1;
                        minV = Math.min(minV, len);
                        maxV = Math.max(maxV, len);
                    }
                }
            }

            if (minV == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minV + " " + maxV);
            }
        }
    }
}

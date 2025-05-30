import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,P,K, answer;
    static String X;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] number;
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        number = new int[10][7];
        number[0] = new int[] {1,1,1,0,1,1,1};
        number[1] = new int[] {0,0,1,0,1,0,0};
        number[2] = new int[] {0,1,1,1,0,1,1};
        number[3] = new int[] {0,1,1,1,1,1,0};
        number[4] = new int[] {1,0,1,1,1,0,0};
        number[5] = new int[] {1,1,0,1,1,1,0};
        number[6] = new int[] {1,1,0,1,1,1,1};
        number[7] = new int[] {0,1,1,0,1,0,0};
        number[8] = new int[] {1,1,1,1,1,1,1};
        number[9] = new int[] {1,1,1,1,1,1,0};

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N층까지
        K = Integer.parseInt(st.nextToken()); // 자릿수 최대 6
        P = Integer.parseInt(st.nextToken()); // 가능 변경 횟수
        X = st.nextToken(); // 실제 층
        if(X.length() < K) {
            while (true) {
                X = "0" + X;
                if (X.length() == K) break;
            }
        }

        //00456
        for(int i=1; i<=N; i++) {
            int count = 0;
            String now = String.valueOf(i);
            if(now.length() < K) {
                while (true) {
                    now = "0" + now;
                    if (now.length() == K) break;
                }
            }

            for(int j=0; j<K; j++){
                if(X.charAt(j) != now.charAt(j)){
                    count += (check(X.charAt(j) -'0', now.charAt(j) -'0'));
                }
            }
            if(count >= 1 && count <= P) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    static int check(int a, int b){
        int cnt = 0;
        for(int i=0; i<7; i++){
            if(number[a][i] != number[b][i]){
                cnt++;
            }
        }

        return cnt;
    }



}

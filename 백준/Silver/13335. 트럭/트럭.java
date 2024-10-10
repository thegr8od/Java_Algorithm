
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, W, ans;
    static int[] trk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 트럭수
        L = Integer.parseInt(st.nextToken()); // 다리의 길이
        W = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

        st = new StringTokenizer(br.readLine());
        trk = new int[N];
        for (int i = 0; i < N; i++) {
            trk[i] = Integer.parseInt(st.nextToken());
        }

        int[] len = new int[N];
        int rest = N;           // 건너지 않은 트럭 수
        int wSum = 0;           // 현재트럭들의 무게 합
        int end = 0;           
        int time = 0;          
        while (rest > 0) {
            time++;

            for (int i = 0; i < end; i++) {
                if (len[i] > 0) {
                    len[i]--;
                    if (len[i] == 0) {  
                        rest--;
                        wSum -= trk[i]; 
                    }
                }
            }

            if (end < N && wSum + trk[end] <= W) {
                wSum += trk[end];
                len[end] = L; // 새로 올라온 트럭은 다리의 길이만큼 이동해야 함
                end++;
            }
        }

 
        System.out.println(time);
    }
}

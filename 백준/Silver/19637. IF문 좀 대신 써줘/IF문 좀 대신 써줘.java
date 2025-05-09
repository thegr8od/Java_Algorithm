import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] cmd = new String[N];
        int[] std = new int[N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            cmd[i] = st.nextToken();
            std[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(br.readLine());

            int start = 0;
            int last = N-1;
            while(start <= last){
                int mid = (start+last) / 2;

                if(std[mid] < num){
                    start = mid + 1;
                }

                else {
                    last = mid -1;
                }
            }
            sb.append(cmd[start]).append("\n");
        }
        System.out.println(sb.toString());

    }



}

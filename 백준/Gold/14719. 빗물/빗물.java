import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H,W;
    static int[][] dp;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[] map = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<W; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<W-1; i++){
            int left = 0;
            int right =0;
            for(int j=i; j>=0; j--){
                left = Math.max(left, map[j]);
            }
            for(int j=i+1; j<W; j++){
                right = Math.max(right, map[j]);
            }

            if(left>=map[i] && right>=map[i]){
                result += (Math.min(left,right)-map[i]);
            }


        }
        System.out.println(result);

    }


}

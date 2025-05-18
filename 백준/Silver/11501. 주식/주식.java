import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            long sum = 0;
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i]  = Integer.parseInt(st.nextToken());
            }
            int maxV = arr[N-1];

            for(int i=N-1; i>=0; i--){
                if(maxV>arr[i]){
                    sum += maxV-arr[i];
                }
                else{
                    maxV = arr[i];
                }
            }

            System.out.println(sum);
        }


// 1 3 1 1 1 5 1 7 4 2 3 3 3 1 5 5 1 1 1 5 2


    }

}



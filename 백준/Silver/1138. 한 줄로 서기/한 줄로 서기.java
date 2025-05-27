import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static StringTokenizer st;
    static int[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1];
        List<Integer> lst = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>=1; i--){
            lst.add(data[i],i);
        }
        for(int N : lst){
            System.out.print(N + " ");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, S; 
    static int[] data;
    static long[] dp; 
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i =0; i<N; i++) {
        	int q = Integer.parseInt(st.nextToken());
        	if (q == 1) {
        		S++;
        		T += S;
        	} else {
        		S = 0;
        	}
     
    }
        System.out.print(T);


    }
}

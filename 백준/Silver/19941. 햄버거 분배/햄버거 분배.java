import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        boolean[] visited = new boolean[s.length()];
        int result = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'H') continue;
            for(int j=i-K; j<=i+K; j++){
                if(j>=0 && j<N && s.charAt(j) == 'H' && !visited[j]){
                    visited[j] = true;
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);


    }
}

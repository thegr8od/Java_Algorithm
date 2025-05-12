import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static final int INF = 20000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        String word = br.readLine();

        for(int i =0; i<N-1; i++){
            String now = br.readLine();
            int cnt = 0;
            int[] alp = new int[26];
            for(int j=0; j<word.length(); j++){
                alp[word.charAt(j) -'A']++;
            }

            for(int j=0; j<now.length(); j++){
                if(alp[now.charAt(j) -'A'] > 0){
                    alp[now.charAt(j) -'A']--;
                    cnt++;
                }
            }

            if(word.length() == now.length() && (cnt == now.length()-1 || cnt == now.length())){
                result++;
            }

            if(word.length()-1 == now.length() && cnt == now.length()){
                result++;
            }

            if(word.length()+1 == now.length() && cnt == now.length()-1){
                result++;
            }





        }


        System.out.println(result);

    }
}

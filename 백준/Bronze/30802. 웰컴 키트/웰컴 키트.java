import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] shirts = new int[6];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++){
            shirts[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int ansT = 0;
        for(int i : shirts){
            if(i>0 && i<=T){
                ansT += 1;
            }
            else{
                if(i%T ==0){
                    ansT += i/T;
                }
                else{
                    ansT += i/T +1;
                }
            }
        }
        System.out.println(ansT);
        System.out.println(N/P+ " " + N%P);




    }

}



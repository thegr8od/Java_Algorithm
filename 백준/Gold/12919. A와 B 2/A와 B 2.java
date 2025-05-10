import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int len;
    static String end;
    static String first;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine();
        end = br.readLine();
        len = first.length();

        dfs(end);

        System.out.println(answer);


    }


    public static void dfs(String now){
        int depth = now.length();

        if(depth==len){
            if(now.equals(first)) answer = 1;
            return;
        }

        if(now.charAt(depth-1) == 'A'){
            dfs(now.substring(0,depth-1));
        }

        if(now.charAt(0) == 'B'){
            String hi = reverse(now.substring(1,depth));
            dfs(hi);
        }



    }

    public static String reverse(String str){
        String hi = "";
        int strLen = str.length();
        for(int i=strLen-1; i>=0; i--){
            hi += str.charAt(i);
        }

        return hi;
    }



}

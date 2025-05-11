import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int len;
    static String end;
    static String first;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();
        
        int count = 0;
        int idx = 0;
        
        while (idx <= document.length() - word.length()){
            if(document.substring(idx, idx+word.length()).equals(word)){
                count++;
                idx += word.length();
            } else{
                idx++;
            }
        }

        System.out.println(count);

    }

}

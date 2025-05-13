import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int num = 1;
        int cnt = 0;
        int idx = 0;
        while(true){
            //1234567891011121314151617181920
            String s = String.valueOf(num);
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == n.charAt(idx)){
                    cnt++;
                    if(cnt == n.length()) break;
                    idx++;
                }
            }
            if(cnt == n.length()) break;
            num++;
        }

        System.out.println(num);

    }
}

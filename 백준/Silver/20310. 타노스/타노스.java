import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<Integer> data = new ArrayList<>();
        int zeroC = 0;
        int zero = 0;
        int oneC = 0;
        int one = 0;
        for(int i =0; i<s.length(); i++){
           data.add(s.charAt(i) - '0');
           if(s.charAt(i) - '0' == 0){
               zero++;
           }
           else{
               one++;
           }
        }

        for(int i =0; i<data.size(); i++){
            if(data.get(i) == 1){
                data.remove(i);
                oneC++;
                if(oneC == one/2) break;
            }
        }

        for(int i =data.size()-1; i>=0; i--){
            if(data.get(i) == 0){
                data.remove(i);
                zeroC++;
                if(zeroC == zero/2) break;
            }
        }

        for(int i : data){
            System.out.print(i);
        }

    }

}



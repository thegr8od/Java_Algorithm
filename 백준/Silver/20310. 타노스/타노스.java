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

        int i =0;
        while(oneC < one/2) {

            if (data.get(i) == 1) {
                data.remove(i);
                oneC++;
                i=0;
            }
            else{
                i++;
            }
        }

        int j =data.size()-1;
        while(zeroC < zero/2){

            if(data.get(j) == 0){
                data.remove(j);
                zeroC++;
                j = data.size()-1;
            }
            else{
                j--;
            }
        }

        for(int num : data){
            System.out.print(num);
        }

    }

}



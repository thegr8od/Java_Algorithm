import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, K;
    static int[] data;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String now = br.readLine();
        String answer = br.readLine();
        StringBuilder sb = new StringBuilder();
        


        while(answer.length()>now.length()){

            if(answer.charAt(answer.length()-1) == 'A'){
                answer = answer.substring(0, answer.length()-1);
            }
            else{
                answer = answer.substring(0, answer.length()-1);
                sb = new StringBuilder(answer);
                answer = sb.reverse().toString();
            }

        }

        if(answer.equals(now)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }



    }





}

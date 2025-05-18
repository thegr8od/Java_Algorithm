import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        int cnt = 0;
        for(int i=1; i<=3; i++){
            String s = br.readLine();
            if(s.equals("Fizz") || s.equals("Buzz") || s.equals("FizzBuzz")) continue;
            else{
                num = Integer.parseInt(s);
                cnt = i;
            }
        }
        int answer = num - cnt + 4;
        if(answer%3 == 0 && answer%5 == 0){
            System.out.println("FizzBuzz");
        }
        else if(answer%5 ==0){
            System.out.println("Buzz");
        }
        else if(answer%3 ==0){
            System.out.println("Fizz");
        }
        else{
            System.out.println(answer);
        }



// 1 3 1 1 1 5 1 7 4 2 3 3 3 1 5 5 1 1 1 5 2


    }

}



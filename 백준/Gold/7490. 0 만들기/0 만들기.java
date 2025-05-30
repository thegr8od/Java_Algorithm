import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, T;
    static int[] number;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T;tc++){
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(2,"1");
            System.out.println(sb.toString());
        }

    }

    static void dfs(int num, String str){

        if(num>N){
            if(evaluate(str.replace(" ","")) == 0){
                sb.append(str);
                sb.append('\n');
            }
            return;
        }

        dfs(num+1, str + " " + num);
        dfs(num+1, str + "+" + num);
        dfs(num+1, str + "-" + num);


    }

    static int evaluate(String expr){
        int sum = 0;
        int num = 0;
        char op = '+';

        for(int i=0; i<expr.length(); i++){
            char now = expr.charAt(i);
            if(Character.isDigit(now)){
                num = num * 10 + (now - '0');
            }

            if(!Character.isDigit(now) || i == expr.length()-1){
                if(op == '+') sum += num;
                if(op == '-') sum -= num;
                op = now;
                num = 0;
            }
        }

        return sum;

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
            if(stack.size()>=bombLen){
                boolean flag= true;

                for(int j=0; j<bombLen; j++){
                    if(stack.get(stack.size()-bombLen+j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j=0; j<bombLen; j++){
                        stack.pop();
                    }

            }


            }

        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }


}



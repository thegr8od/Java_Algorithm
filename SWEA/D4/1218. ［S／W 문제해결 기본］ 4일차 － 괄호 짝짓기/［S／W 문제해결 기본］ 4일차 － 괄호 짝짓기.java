import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
 
    static Stack<String> stack;
    static int flag = 1;
    static int tc;
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t<=10; t++) {
 
        int N = Integer.parseInt(br.readLine().trim());
        String input = br.readLine();
        flag = 1;
        stack = new Stack<>();
        for(int i =0; i<N; i++) {
            String a =String.valueOf(input.charAt(i));
            if(a.equals(")")) {
                if (stack.isEmpty() || !stack.pop().equals("(")) {
                    flag = 0;
                    break;
                }
            }
            else if(a.equals(">")) {
                if (stack.isEmpty() || !stack.pop().equals("<")) {
                    flag = 0;
                    break;
                }
            }
            else if(a.equals("}")) {
                if (stack.isEmpty() || !stack.pop().equals("{")) {
                    flag = 0;
                    break;
                }
            }
            else if(a.equals("]")) {
                if (stack.isEmpty() || !stack.pop().equals("[")) {
                    flag = 0;
                    break;
                }
            }   
            else {
                stack.push(a);
            }
         
        }
         
        System.out.println("#" + t + " " + flag);
         
        }
         
 
         
    }
}
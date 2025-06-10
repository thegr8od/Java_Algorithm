import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;

    static List<Integer> lst;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int now = 1;
        int result = 0;
        ArrayDeque<Character> dq = new ArrayDeque<>();

        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) == '('){
               now*=2;
               dq.push(str.charAt(i));
            }
            else if(str.charAt(i) == '['){
                now*=3;
                dq.push(str.charAt(i));
            }
            else if(str.charAt(i) == ')'){
                if(dq.size()<1 || dq.peek() != '(' ){
                    System.out.println(0);
                    return;
                }
                else{
                    if(str.charAt(i-1) == '('){
                        result += now;
                        now /=2;
                        dq.poll();
                    }
                    else{
                        now /= 2;
                        dq.poll();
                    }
                }

            }
            else{
                if( dq.size()<1  || dq.peek() != '['){
                    System.out.println(0);
                    return;
                }
                else{
                    if(str.charAt(i-1) == '['){
                        result += now;
                        now /=3;
                        dq.poll();
                    }
                    else{
                        now /= 3;
                        dq.poll();
                    }
                }
            }
        }
        
        if(!dq.isEmpty()){
            System.out.println(0);
        }
        else {
            System.out.println(result);

        }
    }






}

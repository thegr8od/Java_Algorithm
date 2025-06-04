import java.io.*;
import java.util.*;


public class Main {
    static int T,N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            for(int i=0; i<N; i++){
                set.add(br.readLine());
            }
            

            boolean flag = false;

            for(String key : set){
                String now = "";
                for(int j=0; j<key.length(); j++){
                    now += key.charAt(j);
                    if(!now.equals(key) && set.contains(now)) {
                        flag = true;
                    }
                }
            }

            if(flag) {
                System.out.println("NO");
            } else{
                System.out.println("YES");
            }

        }




    }


}

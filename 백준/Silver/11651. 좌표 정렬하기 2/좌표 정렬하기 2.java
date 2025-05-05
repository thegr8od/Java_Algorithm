import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Array;
import java.util.*;


public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a1, a2) -> {
            if(a1[1] != a2[1]){
                return a1[1] - a2[1];
            }
            else{
                return a1[0] - a2[0];

            }
        });

        for(int[] num : arr){
            System.out.println(num[0] +" " + num[1]);
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,K;
    static Map<Integer, Integer> map;
    static StringTokenizer st;
    static int answer;
    static int[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        int start =0;
        int end=1;
        map.put(data[0], map.getOrDefault(data[0], 0)+1);
        while(start<=end && end<N){

            map.put(data[end], map.getOrDefault(data[end], 0)+1);
            if(map.get(data[end])>K){
                while(map.get(data[end])>K){
                    map.put(data[start], map.get(data[start++])-1);
                }
            }

            end++;
            answer = Math.max(answer, end-start);






        }
        System.out.println(answer);
    }





}

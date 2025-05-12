import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static final int INF = 20000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(str.length() < M) continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> lst = new ArrayList<>();
        for(String key : map.keySet()){
            lst.add(key);
        }

        lst.sort((o1,o2) -> {
            if(!map.get(o1).equals(map.get(o2))){
                return map.get(o2) - map.get(o1);
            }
            if(o1.length() != o2.length()){
                return o2.length() - o1.length();
            }
            else{
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(String str : lst){
            sb.append(str).append("\n");
        }

        System.out.println(sb.toString());

    }
}

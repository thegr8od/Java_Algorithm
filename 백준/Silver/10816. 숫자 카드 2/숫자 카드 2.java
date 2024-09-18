
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] sang = br.readLine().split(" ");
        HashMap<Integer, Integer> dict1 = new HashMap<>();
        
        for (String s : sang) {
            int num = Integer.parseInt(s);
            dict1.put(num, dict1.getOrDefault(num, 0) + 1);
        }


        int M = Integer.parseInt(br.readLine());
        String[] compare = br.readLine().split(" ");

        // 비교 카드에 대해 상근이 카드의 개수를 출력
        for (String s : compare) {
            int num = Integer.parseInt(s);
            sb.append(dict1.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        if(pq.size() == 1) {
            System.out.println(0);
        }
        else {
            while (true) {
                int last = pq.poll();
                int now = pq.poll();
                answer += (last + now);
                if (pq.isEmpty()) break;
                pq.add(last + now);
            }

            System.out.println(answer);
        }
    }
}

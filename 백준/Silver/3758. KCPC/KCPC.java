import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int len;
    static String end;
    static String first;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] data = new int[n+1][k+1];
            int[] count = new int[n+1];
            int[] lstSub = new int[n+1];
            int[] sum = new int[n+1];
            for(int i=1; i<=m; i++){
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                data[id][number] = Math.max(data[id][number], score);
                count[id]++;
                lstSub[id] = i;
            }

            for(int i=1; i<=n; i++) {
                int s = 0;
                for (int j = 1; j <= k; j++) {
                    s += data[i][j];
                }
                sum[i] = s;
            }

            List<Integer> teams = new ArrayList<>();
            for(int i= 1; i<=n; i++){
                teams.add(i);
            }

            teams.sort((o1, o2) ->{
                if(sum[o1] != sum[o2]){
                    return sum[o2] - sum[o1];
                }

                if(count[o1] != count[o2]){
                    return count[o1] - count[o2];
                }

                return lstSub[o1] - lstSub[o2];

            });

            int rank = 0;
            for (int i=0; i<teams.size(); i++){
                if(teams.get(i) == t){
                    rank = i +1;
                    break;
                }
            }

            System.out.println(rank);
        }

    }

}

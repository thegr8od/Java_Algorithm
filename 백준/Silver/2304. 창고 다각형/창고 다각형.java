
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[1001][1001];
        int n = Integer.parseInt(br.readLine());
        int maxY = 0;
        List<int[]> list = new ArrayList<>();
        int startX = 1001;
        int stdX = 0;
        int endX = 0;

        for(int i =0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[] hi = {x,y};
            list.add(hi);
            if(x < startX) {
                startX = x;
            }
            
            if(x > endX) {
                endX = x;
            }
            
            if(y >= maxY) {
                maxY = y;
                stdX = x;
            }
        }
        
        int curHeight = 0;
        for (int i = startX; i <= stdX; i++) {
            for (int[] now : list) {
                if (now[0] == i) {
                    curHeight = Math.max(curHeight, now[1]);
                }
            }
            for (int k = 0; k < curHeight; k++) {
                map[i][k] = 1;
            }
        }
        

        curHeight = 0;
        for (int i = endX; i > stdX; i--) {
            for (int[] now : list) {
                if (now[0] == i) {
                    curHeight = Math.max(curHeight, now[1]);
                }
            }
            for (int k = 0; k < curHeight; k++) {
                map[i][k] = 1;
            }
        }

        for(int i =0; i<1001; i++) {
            for(int j=0; j<1001; j++) {
                if(map[i][j] == 1) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}

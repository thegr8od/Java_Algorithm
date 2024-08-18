
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static int[][] score;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			score = new int[n][2];
			for (int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(score, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			int std = score[0][1];
			int ans = 1;
			for(int j=1; j<n;j++) {
				if(score[j][1] < std) {
					ans++;
					std=score[j][1];
				}
				
			}
			
			System.out.println(ans);
			
		}
	}
}

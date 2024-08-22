import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, ans;
	static int[] price,cal;
	static StringTokenizer st;
	static BufferedReader br;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc<=T; tc++) {
			price = new int[4];
			cal = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			ans = price[3];
			st = new StringTokenizer(br.readLine());
			for (int i =1; i<=12; i++) {
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(1,0);
			System.out.println("#" + tc + " " + ans);
		} // TC 끝
	}
	
	static void dfs(int month, int sum) {
		if(ans <= sum) return;
		
		if(month>12) {
			ans = Math.min(ans, sum);
			return;
		}
		
		if(cal[month] == 0) {
			dfs(month+1, sum);
		} else {
			dfs(month +1, sum + price[0] * cal[month]);
			dfs(month + 1, sum +price[1]);
			dfs(month+3, sum+price[2]);
		}
	}
}

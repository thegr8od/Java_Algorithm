
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		String quack = "quack";
		int remain = arr.length;
		int ans = 0;
		boolean chk =false;
		while(remain >0) {
			int idx = 0;
			chk = false;
			for(int i =0; i<arr.length; i++) {
				if(quack.charAt(idx) == arr[i]) {
					arr[i] = '\0';
					idx++;
				}
				if(idx==5) {
					remain-=5;
					idx=0;
					chk = true;
				}
				
			}
			
			if(chk) {
				ans++;
			}
			else break;
		}
		
		
		
		if(remain == 0) System.out.println(ans);
		else System.out.println(-1);
	}
}

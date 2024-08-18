
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static Integer[] ALP = new Integer[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<26; i++) {
			ALP[i] = 0;
		}
		
		for(int i =0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				if(j != str.length()-1) {
				ALP[str.charAt(j) - 'A'] += (int)Math.pow(10, str.length()-j-1);
				}
				else {
					ALP[str.charAt(j) - 'A'] += 1;
				}
			}
			
		}
		Arrays.sort(ALP, Collections.reverseOrder());
		int j = 9;
		for(int i =0; i<26; i++) {
			if (ALP[i] != 0) {
				ans += ALP[i] * j--;
			}
		}
		
		System.out.println(ans);
		
		
}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int start;
	static int end;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end += arr[i];
			if(arr[i] > start) {
				start = arr[i];
			}
		}
		
		while(start<=end) {
			int cnt = 1;
			int mid = (start+end)/2;
			
			for (int num : arr) {
				if(mid-num >=0 ) {
					mid -= num;
				}
				else {
					mid = (start+end)/2;
					cnt++;
					mid -= num;
				}
			}
			
			if(cnt <= m) {
				if((start+end)/2 < ans) {
					ans = (start+end)/2;
				}
				end = (start+end)/2-1;
			}
			else {
				start = (start+end)/2 +1;
			}
		}
		
		System.out.println(start);
		
	}

}

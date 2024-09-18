
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N,low,hi,ans;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		int maxV = Integer.MAX_VALUE;
		
		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		int start = 0;
		int end = N-1;
		
		while(start<end) {
			// <= 했는데 이러면 같은것도 start,end로 나와서 <로 해야함
			ans = arr[start] + arr[end];
			
			if(Math.abs(ans) < maxV) {
				low = start;
				hi = end;
				maxV = Math.abs(ans);
			}
			if(ans == 0) {
				break;
			}
			else if(ans < 0) start++;
			else end--;
		}
		if (ans == 0) {
			System.out.println(arr[start] + " " + arr[end]);
		}
		else {
		System.out.println(arr[low] + " " + arr[hi]);
		}
	}
}

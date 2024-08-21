
import java.util.Scanner;

public class Main {

	
	static int N,r,c, ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		while(N!=0) {
			N--;
			if (r <Math.pow(2, N) && c<Math.pow(2,N)) {
				ans += (int)(Math.pow(2, N) * Math.pow(2, N)) * 0;
			}
			
			else if (r <Math.pow(2, N) && c>=Math.pow(2,N)) {
				ans += (int)(Math.pow(2, N) * Math.pow(2, N)) * 1;
				c -= (int)Math.pow(2,N);
			}
			else if (r >=Math.pow(2, N) && c<Math.pow(2,N)) {
				ans += (int)(Math.pow(2, N) * Math.pow(2, N)) * 2;
				r -= (int)Math.pow(2,N);
			}
			
			else {
				ans += (int)(Math.pow(2, N) * Math.pow(2, N)) * 3;
				r -= (int)Math.pow(2,N);
				c -= (int)Math.pow(2,N);
			}
		}
		
		System.out.println(ans);
		
	}
	
	
	

}


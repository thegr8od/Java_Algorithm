
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		while(true) {
			if(n==0) {
				break;
			}
			if(n<3 && n!=0) {
				ans = -1;
				break;
			}
			if(n % 5 == 0) {
				ans += (n/5);
				break;
			}
			else {
				n -= 3;
				ans += 1;
			}
				
		}
		
		System.out.println(ans);
	}
}

import java.util.Scanner;

public class Main{
	
	static int T;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			int N = sc.nextInt();
			int X = sc.nextInt();
			int K = sc.nextInt();
			ans = X;
			for (int i =0; i<K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if (a==ans) {
					ans = b;
				}else if (b==ans) {
					ans = a;
				}
			}
			
			System.out.println(ans);
		}
}

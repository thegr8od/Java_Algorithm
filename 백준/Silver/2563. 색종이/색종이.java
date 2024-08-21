import java.util.Scanner;

public class Main {
	static int ans;
	static int[][] map = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int tc =0; tc<n; tc++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			for (int i=r; i<r+10; i++) {
				for (int j=c; j<c+10; j++) {
					map[i][j] = 1;
				}
			}
		
		}
		
		for (int i =0; i<100; i++) {
			for (int j =0; j<100; j++)
				if (map[i][j] ==1) {
					ans+=1;
				}
		}
		System.out.println(ans);
	}
}

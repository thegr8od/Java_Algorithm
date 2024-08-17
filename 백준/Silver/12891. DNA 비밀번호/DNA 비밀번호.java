
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S,P, ans;
	static int[] arr;
	static int a,c,g,t;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		int aC =0;
		int cC =0;
		int gC =0;
		int tC =0;
		int i = 0;
		for(; i<P; i++) {
			if(str.charAt(i) == 'A') {
				aC+=1;
			}
			else if (str.charAt(i) == 'C') {
				cC+=1;
			}
			else if (str.charAt(i) == 'G') {
				gC+=1;
			}
			else if (str.charAt(i) == 'T') {
				tC+=1;
			}
			
		}
		if(aC>=a && cC>=c && gC>=g && tC>=t) {
			ans += 1;
		}
		i--;
		
		while(i<S-1) {
			
			i++;
			if(str.charAt(i-P) == 'A') {
				aC-=1;
			}
			else if (str.charAt(i-P) == 'C') {
				cC-=1;
			}
			else if (str.charAt(i-P) == 'G') {
				gC-=1;
			}
			else if (str.charAt(i-P) == 'T') {
				tC-=1;
			}
			
			if(str.charAt(i) == 'A') {
				aC+=1;
			}
			else if (str.charAt(i) == 'C') {
				cC+=1;
			}
			else if (str.charAt(i) == 'G') {
				gC+=1;
			}
			else if (str.charAt(i) == 'T') {
				tC+=1;
			}
			
			if(aC>=a && cC>=c && gC>=g && tC>=t) {
				ans += 1;
			}
			
		}
		
		System.out.println(ans);
		
	}
}

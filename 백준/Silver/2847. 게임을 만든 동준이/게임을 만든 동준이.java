import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
	static int ans,std;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	num = new int[n];
    	for(int i =0 ;i<n; i++) {
    		num[i] = Integer.parseInt(br.readLine());
    	}
    	std = num[n-1];
    	
    	for(int i=n-2;i>=0;i--) {
    		if(num[i]>=std) {
    			ans += num[i] - std + 1;
    			std -= 1;
    		}
    		else {
    			std = num[i];
    		}
    	}
    	
    	System.out.println(ans);
    	
    }
}

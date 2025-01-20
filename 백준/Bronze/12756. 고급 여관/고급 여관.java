
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a,aLife,b,bLife;
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        aLife = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        bLife = Integer.parseInt(st.nextToken());
        
        while(true) {
        	if (aLife<=0 || bLife<=0) {
        		if(aLife>bLife && aLife>=0) {
        			System.out.println("PLAYER A");
        			break;
        		}
        		else if (bLife>aLife && bLife>=0) {
        			System.out.println("PLAYER B");
        			break;
        		}
        		else if (bLife<=0 && aLife<=0) {
        			System.out.println("DRAW");
        			break;
        		}
        	}
        	else {
        		aLife -= b;
        		bLife -= a;
        	}
        }
   
    }
}

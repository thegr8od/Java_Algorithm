import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int S = 0;
		int M = Integer.parseInt(br.readLine());
		
		while (M-- >0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("all")) {
				S = (1<<21)-1;
			}
			else if(cmd.equals("empty")) {
				S = 0;
			}
			else {
				int num = Integer.parseInt(st.nextToken());
				if(cmd.equals("add")) {
					S |= (1<<num);
				}
				else if(cmd.equals("remove")) {
					S &= ~(1<<num);
				}
				else if(cmd.equals("check")) {
					sb.append((S & (1 << num)) != 0? 1 :0).append("\n");
				}
				else if(cmd.equals("toggle"))
					S ^= (1<<num);
			}
		}
		System.out.println(sb);
	}
}

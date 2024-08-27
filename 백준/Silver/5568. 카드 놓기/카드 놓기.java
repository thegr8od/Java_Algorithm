import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N,K;
	static boolean[] visited;
	static String[] arr;
	static ArrayList<String> lst;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new String[N];
		visited = new boolean[N];
		lst = new ArrayList<>();
		for (int i =0; i<N; i++) {
			arr[i] = br.readLine();
		}
		dfs(0, "");
		System.out.println(lst.size());
		
	}
	
	static void dfs (int d, String tmp) {
		
		if (d == K) {
			if (!lst.contains(tmp)) {
				lst.add(tmp);
			}
			return;
		}
		
		
		for(int i =0; i<N; i++) {
			if (visited[i]) {
				continue;
			
			}
				visited[i] = true;
				dfs(d+1, tmp+arr[i]);
				visited[i] = false;
			}
		}
}

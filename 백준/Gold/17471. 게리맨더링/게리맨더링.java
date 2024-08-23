import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N,min;
	static int[] people;
	static boolean[] visited;
	static int[] arr;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		people = new int[N];
		arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i =0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i =0; i<=N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j =0; j<cnt; j++){{
				list.get(i).add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		// 선거구 조합
		subset(0);
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	public static void subset(int d) {
		// 모든 선거구 정해졌을 때
		if (d == N) {
			visited = new boolean[N+1];
			int a =0, b= 0;
			for (int i =0; i<N; i++) {
				if (arr[i+1] == 1) a += people[i];
				else if (arr[i+1] == 2) b += people[i];
			}
			
			int cnt = 0;
			
			for (int i = 1; i<=N ; i++) {
				if (visited[i]) continue;
				dfs(i, arr[i]);
				cnt++;
			}
			
			if (cnt ==2) min = Math.min(min, Math.abs(a-b));
			return;
		}
		
		// 선거구 1로 설정
		arr[d + 1] = 1;
		subset(d + 1);
		
		// 선거구 2로 설정
		arr[d + 1] = 2;
		subset(d+1);
		
	}
	
	public static void dfs(int num, int local) {
		visited[num] = true;
		
		// 현재 지역과 연결된 다음 지역들 탐색
		for (int next : list.get(num)) {
			if (arr[next] == local && !visited[next]) {
				dfs(next,local);
			}
		}
		
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M,ans = Integer.MAX_VALUE;
	static int [] comb;
	static List<Pair> home,store;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		store = new ArrayList<>();
		comb = new int[14];
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j <N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					home.add(new Pair(i,j));
				}
				else if(temp == 2) {
					store.add(new Pair(i,j));
				}
			}
		}
		combination(0,0);
		System.out.println(ans);
	}
	
	static void combination(int depth, int now) {
		if(depth == M) {
			ans = Math.min(ans, distance());
			return;
		}
		
		for(int i = now; i<store.size(); i++) {
			comb[depth] = i;
			combination(depth+1, i+1);
		}
	}
	
	static int distance() {
		int sum = 0;
		for(Pair p : home) {
			int minDist = Integer.MAX_VALUE;
			for(int i=0; i<M; i++) {
				Pair s = store.get(comb[i]);
				minDist = Math.min(minDist, Math.abs(p.x-s.x) + Math.abs(p.y - s.y));
			}
			sum += minDist;
		}
		return sum;
	}
	
	
	static class Pair{
		public int x,y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

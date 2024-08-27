import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,M; // 정점의 갯수, 간선의 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		//진입차수관리 배열
		int[] inDegree = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i =1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i =0; i<M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			inDegree[y]++;
		}
		ArrayList<Integer> res = new ArrayList();
		//위상정렬
		//0. 진입차수 관리하기
		//1. 진입차수가 0인 모든 정점을 큐에 삽입한다.
		Queue<Integer> q = new LinkedList<>();
		for(int i =1; i<=N; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		// 큐 사이즈가 0이면 위상정렬 불가
		
		//2. 큐에서 진입 차수가 0인 정점을 꺼내어 자신과 인접한 정점의 간선을 제거한다.
		// -> 인접한 정점의 진입차수를 1 감소시킨다.
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			res.add(cur);
			for(int idx : list[cur]) {
				inDegree[idx]--;
				
				if(inDegree[idx] == 0) {
					q.offer(idx);
				}
			}
		}
		//출력
		
		//출력
		
		for(Integer n : res) {
			System.out.println(n + " ");
		}
		System.out.println();
	}
}

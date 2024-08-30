import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T,n,m;
	static int[] parents;
	static StringBuilder sb;
	
	static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i; // make-set i : 자신의 부모를 자신으로하여 대표자가 되도록 설정
		}
	}
	static int findSet(int a) {
		
		if(a==parents[a]) return a; // 자신이 자신의 부모라면 루트노드이고 집합의 대표자가 됨
		//return findSet(parents[a]);
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false; // 두 집합의 대표자가 같으면 이미 같은 집합이므로 합집합 연산 불가
		// aRoot 에 bRoot를 흡수 : 두 집합 합치기
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int i =1; i<=T; i++) {			
			n = sc.nextInt();
			m = sc.nextInt();
			parents = new int[n+1];
			make();
			
			
			for(int j = 0; j<m; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a,b);
			}
			
			boolean[] isRoot = new boolean[n + 1];
			int cnt = 0;
			
			for (int k =1; k<= n; k++) {
				int root = findSet(k);
				if(!isRoot[root]) {
					isRoot[root] = true;
					cnt++;
				}
			}
			
			// 모든 원소에 대해 단위서로소집합 생성
			System.out.println("#"+ i +" " + cnt);
		}
		
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Triple{
	int height;
	int row;
	int col;
	
	public Triple(int height, int row, int col) {
		this.height = height;
		this.row = row;
		this.col = col;
	}
}


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Queue<Triple> queue = new LinkedList<>();
	static int M,N,H;
	static int[] dx = {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dh = {0,0,0,0,1,-1};
	static int arr[][][];
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];

		for (int i =0; i<H;i++) {
			for (int j =0; j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for (int k =0; k<M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k] == 1) queue.add(new Triple(i,j,k));
				}
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		
		while(!queue.isEmpty()) {
			Triple trip = queue.poll();
			int height = trip.height;
			int row = trip.row;
			int col = trip.col;
			//arr[H][N][M]
			for (int i =0; i<6; i++) {
				int nHeight = height + dh[i];
				int nRow = row + dx[i];
				int nCol = col + dy[i];
				
				if(nHeight < 0 || nHeight >= H || nRow <0 || nRow>=N || nCol <0 || nCol >=M) {
					continue;
				}
				
				if(arr[nHeight][nRow][nCol] == 0) {
					arr[nHeight][nRow][nCol] = arr[height][row][col] +1;
					queue.add(new Triple(nHeight, nRow, nCol));
				}
			}
		}
		
		int res = Integer.MIN_VALUE;
		
		for(int i =0; i<H; i++) {
			for (int j =0; j<N; j++) {
				for (int k=0; k<M; k++) {
					if(arr[i][j][k] ==0) return -1;
					res = Math.max(res, arr[i][j][k]);
				}
			}
		}
		
		return res-1;
		
	}
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	static int T, win, lose;
	static int[] qNum, iNum;
	static boolean[] check;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T;tc++) {
			qNum = new int[9];
			iNum = new int[9];
			numbers = new int[9];
			check = new boolean[19];
			win = 0;
			lose = 0;
	
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i<9; i++) {
				qNum[i] = Integer.parseInt(st.nextToken());
				check[qNum[i]] = true;
			}
			int j = 0;
			for (int i=1; i<19; i++) {
				if(check[i] == false) {
					iNum[j++] = i;
				}
			}
			perm(0,new boolean[10]);
			
			System.out.println("#" + tc + " " +win + " " + lose );
			
		}
		
		
	}
	static void perm(int cnt, boolean[] isSelected) {
		if(cnt == 9) {
			if (isWin(numbers)) {
				win++;
			} else {
				lose++;
			}
			return;
		}
		
		for(int i =0; i<9; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = iNum[i];
			perm(cnt+1, isSelected);
			isSelected[i] = false;
		}
	}
	
	static boolean isWin(int[] arr) {
		int res1 = 0;
		int res2 = 0;
		for(int i = 0; i<9; i++) {
			if(arr[i] > qNum[i] ) {
				res1 += (arr[i] + qNum[i]);
			}
			else {
				res2 += (qNum[i] + arr[i]);
			}
		}
		if (res1>res2) {
			return false;
		}
		else {
			return true;
		}
	}

}

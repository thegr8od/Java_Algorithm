import java.util.Scanner;

public class Solution {

    static int N,T, col[], ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
        	N = sc.nextInt();
        	ans = 0;
        col = new int[N + 1];
        
        setQueens(1);
        
        System.out.println("#" + tc+ " " + ans);
        }
    }

    static void setQueens(int rowNo) {
        if(!isAvailable(rowNo - 1)) return;
        
        if (rowNo > N) {
            // 무조건 답 !
            ans++;
            return;
        }
        
        for (int c = 1; c <= N; c++) {
            col[rowNo] = c;
            setQueens(rowNo + 1);
        }
    }
    
    private static boolean isAvailable(int rowNo) {
        
        for (int k = 1; k < rowNo; k++) {
            if (col[rowNo] == col[k] || rowNo-k == Math.abs(col[rowNo]-col[k])) return false;
        }
        
        return true;
    }
}

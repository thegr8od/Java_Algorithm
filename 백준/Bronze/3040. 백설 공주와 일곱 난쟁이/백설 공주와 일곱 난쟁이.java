
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] numArr;
    static int[] ans = new int[7];


    public static void main(String[] args) {
        numArr = new int[9];
        for (int i = 0; i < 9; i++) {
            numArr[i] = sc.nextInt();
        }
        combination(0, 0);
    }

    private static void combination(int cnt, int start) {
        if (cnt == 7) {
            int total = 0;
            for (int i = 0; i < ans.length; i++)
                total += ans[i];
            if (total == 100) {
                for (int i = 0; i < ans.length; i++)
                    System.out.println(ans[i]);
            }
            return;
        }

        for (int i = start; i < numArr.length; i++) {
            ans[cnt] = numArr[i];
            combination(cnt + 1, i + 1);
        }
    }
}

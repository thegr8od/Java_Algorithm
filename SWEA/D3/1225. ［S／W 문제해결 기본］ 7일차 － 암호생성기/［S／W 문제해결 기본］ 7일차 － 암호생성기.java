
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            Deque<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                queue.add(sc.nextInt());
            }

            while (true) {
                boolean finished = false;

                for (int i = 1; i <= 5; i++) {
                    int idx = queue.pollFirst() - i;
                    if (idx <= 0) {
                        idx = 0;
                        queue.addLast(idx);
                        finished = true;
                        break;
                    } else {
                        queue.addLast(idx);
                    }
                }

                if (finished) {
                    break;
                }
            }

            System.out.print("#" + n + " ");
            for (int num : queue) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

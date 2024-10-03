import java.util.*;

public class Main {
    static int maxV = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 순열 생성
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }

        // 모든 순열을 계산하여 최대값 구하기
        permute(list, 0, n);
        System.out.println(maxV);
    }

    // 순열 생성 및 계산
    static void permute(List<Integer> arr, int depth, int n) {
        if (depth == n) {
            calculate(arr);
            return;
        }

        for (int i = depth; i < n; i++) {
            Collections.swap(arr, depth, i);
            permute(arr, depth + 1, n);
            Collections.swap(arr, depth, i);
        }
    }

    // 순열에 따른 차이 계산
    static void calculate(List<Integer> arr) {
        int tmp = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            tmp += Math.abs(arr.get(i) - arr.get(i + 1));
        }
        maxV = Math.max(maxV, tmp); // 최대값 비교
    }
}

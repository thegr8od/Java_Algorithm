import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[101];

        for(int i=1; i<board.length; i++){
            board[i] = i;
        }

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }


        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        int result = bfs(1);
        System.out.println(result);



    }

    public static int bfs(int start){
        int[] check = new int[101];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(true){
            int idx = q.poll();
            for(int i=1; i<7; i++){
                int nextIdx = idx + i;

                if (nextIdx > 100){
                    continue;
                }

                if (check[board[nextIdx]] == 0){
                    q.add(board[nextIdx]);
                    check[board[nextIdx]] = check[idx] + 1;
                }
                if(board[nextIdx] == 100){
                    return check[100];
                }
            }
        }
    }

}

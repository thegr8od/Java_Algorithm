import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int[][] map;
    static int answer;
    static List<int[]> lst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        lst = new ArrayList<>();

        for(int i=0; i<9; i++){
            String now = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = now.charAt(j) - '0';
                if(map[i][j] == 0){
                    lst.add(new int[] {i,j});
                }
            }
        }

        play(0);




    }

    static void play(int d){

        if(lst.size() == d){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        int x = lst.get(d)[0];
        int y = lst.get(d)[1];

        boolean[] visited = new boolean[10];

        for(int i=0; i<9; i++){
            if(map[x][i] != 0){
                visited[map[x][i]] = true;
            }
        }

        for(int i=0; i<9; i++){
            if(map[i][y] != 0){
                visited[map[i][y]] = true;
            }
        }

        int startX = (x/3) * 3;
        int startY = (y/3) * 3;

        for(int i = startX; i<startX+3; i++){
            for(int j=startY; j<startY+3; j++){
                if(map[i][j] != 0){
                    visited[map[i][j]] = true;
                }
            }
        }

        for(int i=1; i<10; i++){
            if(!visited[i]) {
                map[x][y] = i;
                play(d+1);
                map[x][y] = 0;
            }
        }


    }
}

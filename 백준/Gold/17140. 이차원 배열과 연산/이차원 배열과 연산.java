import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int num;
    int count;

    public Node(int num, int count){
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Node o){
        if (this.count == o.count){
            return Integer.compare(this.num, o.num); // count 같으면 num 오름차순
        }
        return Integer.compare(this.count, o.count);
    }
}

public class Main {
    static int R,C,K,row,col;
    static StringTokenizer st;
    static int[][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[100][100];
        for(int i =0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        row = 3;
        col = 3;

        while(cnt < 101){

            if(data[R-1][C-1] == K){
                System.out.println(cnt);
                return;
            }

            if(row>=col){
                rowTurn();

            }
            else{
                colTurn();

            }

            cnt++;

        }

        System.out.println(-1);



        //1. 등장횟수 오름차순 2.숫자 오름차순
    }

    static void rowTurn(){
        int nextCol =0;
        for(int i=0; i<row; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<col; j++){
                if(data[i][j] != 0){
                    map.put(data[i][j], map.getOrDefault(data[i][j], 0) + 1);
                }

                nextCol = Math.max(nextCol, map.size()*2);
                if(nextCol >= 100) nextCol = 100;
            }
            List<Node> lst = new ArrayList<>();
            for(int key : map.keySet()){
                lst.add(new Node(key, map.get(key)));
            }

            Collections.sort(lst);
            int idx=0;
            for (int y=0; y<col; y++){
                data[i][y] = 0;
            }

            for(Node now : lst){
                data[i][idx] = now.num;
                data[i][idx+1] = now.count;
                idx +=2;
            }
        }
        col = nextCol;



    }

    static void colTurn(){
        int nextRow = 0;
        for(int i=0; i<col; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<row; j++){
                if(data[j][i] != 0) {
                    map.put(data[j][i], map.getOrDefault(data[j][i], 0) + 1);
                }

                nextRow = Math.max(nextRow, map.size()*2);
                if(nextRow >= 100) nextRow = 100;
            }
            List<Node> lst = new ArrayList<>();
            for(int key : map.keySet()){
                lst.add(new Node(key, map.get(key)));
            }
            Collections.sort(lst);
            int idx=0;
            for (int y=0; y<row; y++){
                data[y][i] = 0;
            }
            for(Node now : lst){
                data[idx][i] = now.num;
                data[idx+1][i] = now.count;
                idx +=2;
            }
        }
        row = nextRow;
    }

}

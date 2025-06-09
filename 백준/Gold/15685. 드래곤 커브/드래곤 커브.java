import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[][] check;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int answer;
    static List<Integer> lst;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        check = new int[101][101];
        for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            lst = new ArrayList<>();
            check[x][y] = 1;
            if(g!=0) {
                if (d == 0) {
                    lst.add(0);
                    y++;
                    check[x][y] = 1;
                    lst.add(1);
                    x--;
                    check[x][y] = 1;
                    makeDragon(x, y, g, 1);
                } else if (d == 1) {
                    lst.add(1);
                    x--;
                    check[x][y] = 1;
                    lst.add(2);
                    y--;
                    check[x][y] = 1;
                    makeDragon(x, y, g, 1);
                } else if (d == 2) {
                    lst.add(2);
                    y--;
                    check[x][y] = 1;
                    lst.add(3);
                    x++;
                    check[x][y] = 1;
                    makeDragon(x, y, g, 1);
                } else {
                    lst.add(3);
                    x++;
                    check[x][y] = 1;
                    lst.add(0);
                    y++;
                    check[x][y] = 1;
                    makeDragon(x, y, g, 1);
                }
            }
            else{
                if (d == 0) {
                    check[x][y] = 1;
                    check[x][y + 1] = 1;
                }
                else if (d == 1) {
                    check[x][y] = 1;
                    check[x-1][y] = 1;
                }
                else if (d == 2) {
                    check[x][y] = 1;
                    check[x][y - 1] = 1;
                }
                else {
                    check[x][y] = 1;
                    check[x+1][y] = 1;
                }





            }
        }

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                count(i,j);
            }
        }


        System.out.println(answer);

        // 0 오른쪽 1 위쪽 2 왼쪽 3 아랫쪽


        // 1세대 반대
        // 2세대 1개 반대
        // 3세대 2개 반대
        // 4세대 4개 반대
        // 5세대 8개 반대

    }

//    static int[] dx = {0,-1,0,1};
//    static int[] dy = {1,0,-1,0};
// 0,1,2,1,2,3,2,1
    static void makeDragon(int x, int y, int g, int nowG){

        if(nowG == g){
            return;
        }

        int std = lst.size()/2;
        int cnt = 0;
        List<Integer> preLst = new ArrayList<>(lst);
        List<Integer> nowLst = new ArrayList<>();
        for(int num : preLst){
            if(cnt++<std){
                lst.add((num+2)%4);
                nowLst.add((num+2)%4);
            }
            else{
                lst.add(num);
                nowLst.add(num);
            }
        }

        for(int i : nowLst){
            x += dx[i];
            y += dy[i];
            check[x][y] = 1;
        }

        makeDragon(x,y,g, nowG+1);

    }

    static void count (int x, int y){
        if(check[x][y] == 1 && check[x+1][y] ==1
        && check[x][y+1] ==1 && check[x+1][y+1] == 1) answer ++;
    }





}

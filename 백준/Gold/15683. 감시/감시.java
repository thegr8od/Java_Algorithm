import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M, H, answer;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static List<int[]> lst;
    static int minV;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로선 col
        M = Integer.parseInt(st.nextToken()); //놓여있는 가로선
        lst = new ArrayList<>();
        map = new int[N][M];
        minV = N*M;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1 || num ==2 || num ==3 || num ==4 || num == 5){
                    lst.add(new int[] {i,j});
                }
                map[i][j] = num;
            }
        }

        findAns(lst, 0, map);
        System.out.println(minV);


    }

    static void findAns(List<int[]> lst, int start, int[][] map){
        if(start == lst.size()){
            minV = Math.min(minV, count(map));
            return;
        }


            int[] cur = lst.get(start);
            int x = cur[0];
            int y = cur[1];
            if(map[x][y] == 1){
                int[][] nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,0);
                findAns(lst, start+1, nextMap);

                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,1);
                findAns(lst, start+1, nextMap);


                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,2);
                findAns(lst, start+1, nextMap);

                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,3);
                findAns(lst, start+1, nextMap);

            }
            else if(map[x][y] == 2){
                int[][] nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,0);
                nextMap = changeMap(nextMap, x,y,2);
                findAns(lst, start+1, nextMap);
                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,1);
                nextMap = changeMap(nextMap, x,y,3);
                findAns(lst, start+1, nextMap);

            }
            else if(map[x][y]==3){
                int[][] nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,0);
                nextMap = changeMap(nextMap, x,y,1);
                findAns(lst, start+1, nextMap);

                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,1);
                nextMap = changeMap(nextMap, x,y,2);
                findAns(lst, start+1, nextMap);

                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,2);
                nextMap = changeMap(nextMap, x,y,3);
                findAns(lst, start+1, nextMap);

                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,3);
                nextMap = changeMap(nextMap, x,y,0);
                findAns(lst, start+1, nextMap);


            }
            else if(map[x][y]==4){
                int[][] nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,3);
                nextMap = changeMap(nextMap, x,y,0);
                nextMap = changeMap(nextMap, x,y,1);
                findAns(lst, start+1, nextMap);

                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,0);
                nextMap = changeMap(nextMap, x,y,1);
                nextMap = changeMap(nextMap, x,y,2);
                findAns(lst, start+1, nextMap);

                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,1);
                nextMap = changeMap(nextMap, x,y,2);
                nextMap = changeMap(nextMap, x,y,3);
                findAns(lst, start+1, nextMap);

                nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,2);
                nextMap = changeMap(nextMap, x,y,3);
                nextMap = changeMap(nextMap, x,y,0);
                findAns(lst, start+1, nextMap);
            }
            else{
                int[][] nextMap = new int[map.length][];
                for (int l=0; l < map.length; l++) {
                    nextMap[l] = map[l].clone();
                }
                nextMap = changeMap(nextMap, x,y,0);
                nextMap = changeMap(nextMap, x,y,1);
                nextMap = changeMap(nextMap, x,y,2);
                nextMap = changeMap(nextMap, x,y,3);
                findAns(lst, start+1, nextMap);
            }

    }

    static int count(int[][] nextMap){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(nextMap[i][j] == 0){
                    cnt++;
                }
            }
        }


        return cnt;
    }

    static int[][] changeMap(int[][] map, int x, int y, int dir){
        while(true) {
            x = x + dx[dir];
            y = y + dy[dir];
            if (x < 0 || x >= N || y < 0 || y >= M) break;
            if (map[x][y] == 6) break;
            else {
                if (map[x][y] == 0) {
                    map[x][y] = -1;
                }
            }

        }


        return map;
    }





}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] map2;
    static int ice, maxIce, sum, l, len;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static List<int[]> lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        len = (int) Math.pow(2,n);
        map = new int[len][len];
        map2 = new int[len][len];
        for(int i=0; i<len; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<len; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<q; i++){
            l = Integer.parseInt(st.nextToken());
            fireStorm(l);
            melt();
        }

        for(int j=0; j<len; j++){
            for(int k=0; k<len; k++){
                sum += map[j][k];
            }
        }

        visited = new boolean[len][len];
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    ice = 0;
                    dfs(i,j);
                }
            }
        }
        System.out.println(sum);
        System.out.println(maxIce);
    }

    static void dfs (int x, int y){

        visited[x][y] = true;
        ice++;
        maxIce = Math.max(maxIce, ice);
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<len && ny>=0 && ny<len){
                if(!visited[nx][ny] && (map[nx][ny] != 0)) dfs(nx,ny);
            }
        }
    }

    static void fireStorm(int l){
        int size = (int) Math.pow(2,l);
        int std = len / size;

        for(int i=0; i<len; i+= size){
            for(int j=0; j<len; j+= size){
                int idx = 0;
                for(int x=size-1; x>=0; x--){
                    ArrayList<Integer> lst = new ArrayList<>();
                    for(int y=0; y<size; y++){
                        lst.add(map[i+x][j+y]);
                    }
                    for(int k=0; k<size; k++){
                        map2[i+k][idx+j] = lst.get(k);
                    }
                    idx++;
                }

            }
        }
    }

    static void melt() {

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(map2[i][j] == 0) {
                    map[i][j] = 0;
                    continue;
                }
                int x = i;
                int y = j;
                int cnt = 0;

                for(int k=0; k<4; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx>=0 && nx<len && ny>=0 && ny<len){
                        if(map2[nx][ny] != 0){
                            cnt++;
                        }
                    }
                }
                if(cnt<3){
                    map[i][j] = map2[i][j]-1;
                }
                else{
                    map[i][j] = map2[i][j];
                }
            }
        }
    }


}

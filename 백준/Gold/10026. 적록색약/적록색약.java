import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];
        char[][] map = new char[n][n];
        char[][] map2 = new char[n][n];

        for(int i =0; i<n;i++){
            String str = br.readLine();
            for(int j =0; j<n;j++){
                char a = str.charAt(j);
                if(a == 'G'){
                    map[i][j] = str.charAt(j);
                    map2[i][j] = 'R';
                }
                else {
                    map[i][j] = str.charAt(j);
                    map2[i][j] = str.charAt(j);
                }
            }
        }

        for(int i =0; i<n; i++){
            for(int j=0;j<n; j++){
                if(!visited[i][j]){
                    dfs(map[i][j], i,j,visited,map);
                    a++;
                }
                if(!visited2[i][j]){
                    dfs(map2[i][j], i,j,visited2,map2);
                    b++;
                }
            }
        }



        System.out.print(a + " ");
        System.out.println(b);



    }

    public static void dfs(char now, int x, int y, boolean[][] visited, char[][] map){
        visited[x][y] = true;

        for(int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(!visited[nx][ny]){
                    if(map[nx][ny] == now){
                        dfs(now, nx, ny, visited, map);
                    }
                }
            }
        }

    }

}

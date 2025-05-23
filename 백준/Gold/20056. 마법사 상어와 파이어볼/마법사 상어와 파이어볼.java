import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] map;
    static int N,M,K;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static Queue<int[]> queue;
    static int[][] mData;
    static int[][] sData;
    static List<Integer>[][] dData;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        mData= new int[N][N];
        dData= new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dData[i][j] = new ArrayList<>();
            }
        }
        sData= new int[N][N];
        queue = new ArrayDeque<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            queue.add(new int[] {r,c,m,s,d});
        }

        while(K-- >0){
            mData = new int[N][N];
            sData = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dData[i][j] = new ArrayList<>();
                }
            }
            while(!queue.isEmpty()){
                int[] now = queue.poll();
                int r = now[0];
                int c = now[1];
                int m = now[2];
                int s = now[3];
                int d = now[4];
                int move = s % N;
                int nx = (r + dx[d]*move + N) % N;
                int ny = (c + dy[d]*move + N) % N;
                mData[nx][ny] += m;
                sData[nx][ny] += s;
                dData[nx][ny].add(d);
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(dData[i][j].size() == 1){
                        queue.add(new int[] {i,j,mData[i][j],sData[i][j], dData[i][j].get(0)});
                    }
                    else if(dData[i][j].size() > 1){
                        boolean even = true;
                        boolean odd = true;
                        for(int num : dData[i][j]){
                            if(num%2 == 0){
                                odd = false;
                            }
                            else{
                                even = false;
                            }
                        }
                        if((even && !odd) || (odd && !even)) {
                            if (mData[i][j] / 5 > 0) {
                                queue.add(new int[] {i, j, mData[i][j]/ 5, sData[i][j]/dData[i][j].size(),0});
                                queue.add(new int[] {i, j, mData[i][j]/ 5, sData[i][j]/dData[i][j].size(),2});
                                queue.add(new int[] {i, j, mData[i][j]/ 5, sData[i][j]/dData[i][j].size(),4});
                                queue.add(new int[] {i, j, mData[i][j]/ 5, sData[i][j]/dData[i][j].size(),6});
                            }
                        }
                        else{
                            if (mData[i][j] / 5 > 0) {
                                queue.add(new int[]{i, j, mData[i][j] / 5, sData[i][j] / dData[i][j].size(), 1});
                                queue.add(new int[]{i, j, mData[i][j] / 5, sData[i][j] / dData[i][j].size(), 3});
                                queue.add(new int[]{i, j, mData[i][j] / 5, sData[i][j] / dData[i][j].size(), 5});
                                queue.add(new int[]{i, j, mData[i][j] / 5, sData[i][j] / dData[i][j].size(), 7});
                            }
                        }
                    }
                }
            }


        }

        long ans = 0;
        for (int[] f : queue){
            ans += f[2];
        }
        System.out.println(ans);



    }


}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M,K;
    static Deque<Integer>[][] treeMap;
    static int[][] addMap;
    static int[][] nowMap;
    static int[] dx ={-1,-1,-1,0,0,1,1,1};
    static int[] dy ={-1,0,1,-1,1,-1,0,1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        treeMap = new ArrayDeque[N][N];
        addMap = new int[N][N];
        nowMap = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                nowMap[i][j] = 5;
                addMap[i][j] = Integer.parseInt(st.nextToken());
                treeMap[i][j] = new ArrayDeque<>();
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            treeMap[x][y].add(age);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                List<Integer> temp = new ArrayList<>(treeMap[i][j]);
                Collections.sort(temp);
                treeMap[i][j] = new ArrayDeque<>(temp);
            }
        }

        for(int i=0; i<K; i++){
            spring();
            fall();
            winter();
        }
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer += treeMap[i][j].size();
            }
        }

        System.out.println(answer);



    }

    static void spring(){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(treeMap[i][j].size() != 0) {
                    int nowN = nowMap[i][j];
                    Deque<Integer> cur = treeMap[i][j];
                    Deque<Integer> live = new ArrayDeque<>();
                    int deadTree = 0;
                    while(!cur.isEmpty()){
                        int age = cur.poll();

                        if(nowMap[i][j] >= age){
                            nowMap[i][j] -= age;
                            live.add(age+1);
                        }
                        else{
                            deadTree += age/2;
                        }
                    }

                    treeMap[i][j] = live;
                    summer(i,j,deadTree);
                }
            }
        }
    }

    static void summer(int x, int y, int deatTree){
        nowMap[x][y] += deatTree;
    }

    static void fall(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(treeMap[i][j].size() >0){
                    for(int age : treeMap[i][j]){
                        if(age%5 ==0){
                            for(int k =0; k<8; k++){
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if(nx>=0 && nx<N && ny>=0 && ny<N){
                                    treeMap[nx][ny].push(1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                nowMap[i][j] += addMap[i][j];
            }
        }
    }



}

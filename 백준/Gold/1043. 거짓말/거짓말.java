import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Array;
import java.util.*;


public class Main {
    static int N,M;
    static int answer;
    static boolean[] visited;
    static boolean[] visitedM;
    static ArrayList<ArrayList<Integer>> lst;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        visitedM = new boolean[M];

        lst = new ArrayList<>();
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());

        for(int i=0; i<people; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> miniLst = new ArrayList<>();
            for(int j=0; j<num; j++){

                miniLst.add(Integer.parseInt(st.nextToken()));
            }
            lst.add(miniLst);

        }

        answer = M;
        bfs();

        System.out.println(answer);


    }

    public static void bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        for(int p : set){
            visited[p] = true;
            queue.add(p);
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            for (int i =0; i<M; i++){
                if(!visitedM[i] && lst.get(i).contains(now)){
                    visitedM[i] = true;
                    answer--;

                    for (int np : lst.get(i)) {
                        if (!visited[np]) {
                            visited[np] = true;
                            queue.add(np);
                        }
                    }
                }
            }
        }
    }

}

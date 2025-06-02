import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }



}

public class Main {
    static int N,M,L,K;
    static ArrayList<Node> lst;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        lst = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lst.add(new Node(x,y));
        }

        int res = 0;
        for (Node a : lst) {
            for (Node b : lst) {
                res = Math.max(res, isBound(a.x, b.y, L));
            }
        }


        System.out.println(K - res);


    }

    static int isBound(int i, int j, int l){
        int cnt = 0;
        for(Node s : lst){
            if(s.x >=i && s.x <= i+l && s.y >=j && s.y <= j+l){
                cnt++;
            }
        }

        return cnt;
    }

}

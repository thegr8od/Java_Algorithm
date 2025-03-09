import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static ArrayList<Node> list = new ArrayList<>();
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            list.add(new Node(num, gold, silver, bronze, 0));

        }
        Collections.sort(list);
        list.get(0).rank = 1;

        for(int i =1; i< list.size(); i++){
            Node now = list.get(i);

            int prevG = list.get(i-1).gold;
            int prevS = list.get(i-1).silver;
            int prevB = list.get(i-1).bronze;

            if(list.get(i).num == K){
                ans = i;
            }
            if(now.gold == prevG && now.silver == prevS && now.bronze == prevB){
                list.get(i).rank = list.get(i-1).rank;
            }
            else{
                list.get(i).rank = i+1;
            }
        }


        System.out.println(list.get(ans).rank);
    }


}
class Node implements Comparable<Node> {
    int num, gold, silver, bronze, rank;

    Node(int num, int gold, int silver, int bronze, int rank) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Node n) {
        if (this.gold == n.gold) {
            if (this.silver == n.silver) {
                return n.bronze - this.bronze;
            } else {
                return n.silver - this.silver;
            }
        } else {
            return n.gold - this.gold;
        }
    }
}
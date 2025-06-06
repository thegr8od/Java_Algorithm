import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Player{
        int level;
        String name;
        boolean check;

        Player(int level, String name){
            this.level = level;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Player[] players = new Player[p];

        for(int i =0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players[i] = new Player(level, name);
        }

        for(int i=0; i<p; i++){
            ArrayList<Player> room = new ArrayList<>();
            if(!players[i].check){
                for(int j=i; j<p; j++){
                    if (room.size() == m) break;
                    int level = players[j].level;
                    String name = players[j].name;
                    if(!players[j].check && players[i].level - 10 <= level && level <= players[i].level + 10){
                        players[j].check = true;
                        room.add(new Player(level, name));
                    }
                }

                room.sort((o1, o2) -> o1.name.compareTo(o2.name));

                if (room.size() == m) {
                    sb.append("Started!\n");
                } else {
                    sb.append("Waiting!\n");
                }
                for(Player player : room){
                    sb.append(player.level).append(" ").append(player.name).append("\n");
                }
            }

        }
        System.out.println(sb);
    }

}



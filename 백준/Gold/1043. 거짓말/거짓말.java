import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer;
    static List<List<Integer>> parties;
    static List<List<Integer>> personToParties;
    static boolean[] visitedPerson, visitedParty;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) N, M 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2) 진실을 아는 사람들 초기화
        st = new StringTokenizer(br.readLine());
        int cntKnow = Integer.parseInt(st.nextToken());
        List<Integer> trueList = new ArrayList<>();
        for (int i = 0; i < cntKnow; i++) {
            trueList.add(Integer.parseInt(st.nextToken()));
        }

        // 3) 파티별 참석자, 사람→파티 인접 리스트 초기화
        parties = new ArrayList<>(M);
        personToParties = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) personToParties.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>(k);
            for (int j = 0; j < k; j++) {
                int p = Integer.parseInt(st.nextToken());
                list.add(p);
                personToParties.get(p).add(i);
            }
            parties.add(list);
        }

        // 4) 상태 배열 초기화
        visitedPerson = new boolean[N + 1];
        visitedParty  = new boolean[M];
        answer = M;

        // 5) DFS 전파 시작
        for (int p : trueList) {
            if (!visitedPerson[p]) {
                dfsPerson(p);
            }
        }

        // 6) 결과 출력
        System.out.println(answer);
    }

    // 사람 p가 진실을 전파하는 재귀 함수
    static void dfsPerson(int p) {
        visitedPerson[p] = true;
        for (int pi : personToParties.get(p)) {
            if (!visitedParty[pi]) {
                visitedParty[pi] = true;
                answer--;
                for (int np : parties.get(pi)) {
                    if (!visitedPerson[np]) {
                        dfsPerson(np);
                    }
                }
            }
        }
    }
}

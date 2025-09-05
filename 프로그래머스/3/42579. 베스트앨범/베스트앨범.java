import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Integer> lst = new ArrayList<>();
        for (String key : map.keySet()) {
            lst.add(map.get(key));
        }
        Collections.sort(lst, Collections.reverseOrder());

        // 장르 총합 내림차순대로 장르명을 담음
        List<String> answerKey = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            for (String key : map.keySet()) {
                // Integer 비교는 equals로!
                if (Objects.equals(map.get(key), lst.get(i))) {
                    answerKey.add(key);
                }
            }
        }

        // ans: answerKey 순서(장르 총합 내림차순)로 각 장르의 재생수 리스트
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < answerKey.size(); i++) { // lst.size() 대신 answerKey.size() 사용
            ans.add(new ArrayList<>());
        }

        for (int i = 0; i < genres.length; i++) {
            for (int j = 0; j < answerKey.size(); j++) {
                if (genres[i].equals(answerKey.get(j))) {
                    ans.get(j).add(plays[i]);
                }
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            Collections.sort(ans.get(i), Collections.reverseOrder());
        }

        // finalAns: 뽑힌 "재생수"
        // finalAnsGenre: 같은 위치의 "장르"를 병렬 저장 (값 중복/혼동 방지)
        List<Integer> finalAns = new ArrayList<>();
        List<String> finalAnsGenre = new ArrayList<>();

        for (int g = 0; g < ans.size(); g++) {
            List<Integer> num = ans.get(g);
            int take = Math.min(2, num.size());   // 장르별 최대 2곡만
            for (int i = 0; i < take; i++) {
                finalAns.add(num.get(i));
                finalAnsGenre.add(answerKey.get(g));
            }
        }

        // 값+장르로 전역 인덱스 매핑, 같은 곡 재사용 방지
        List<Integer> finalA = new ArrayList<>();
        boolean[] used = new boolean[plays.length];

        for (int i = 0; i < finalAns.size(); i++) {
            int targetPlay = finalAns.get(i);
            String targetGenre = finalAnsGenre.get(i);

            for (int j = 0; j < plays.length; j++) {
                if (!used[j]
                        && plays[j] == targetPlay
                        && targetGenre.equals(genres[j])) {
                    finalA.add(j);
                    used[j] = true;
                    break;
                }
            }
        }

        int[] answer = new int[finalA.size()];
        for (int i = 0; i < finalA.size(); i++) {
            answer[i] = finalA.get(i);
        }
        return answer;
    }
}

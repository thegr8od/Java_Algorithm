import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        Integer[] mats2 = new Integer[mats.length];
        for(int i=0; i<mats.length; i++){
            mats2[i] = mats[i];
        }
        Arrays.sort(mats2, Collections.reverseOrder());
        
        for(int n : mats2){
            for(int i=0; i<park.length; i++){
                for(int j=0; j<park[i].length; j++){
                    if(park[i][j].equals("-1")){
                        if(i+n <=park.length && j+n <= park[i].length){
                            int cnt = 0;
                            for(int x=i; x<i+n; x++){
                                for(int y=j; y<j+n; y++){
                                    if(park[x][y].equals("-1")) cnt++;
                                }
                            }
                            if(cnt == (n*n)) {
                                return n;
                            }
                        }
                    }
                }
            }
        }
        return answer;
        
    }
}
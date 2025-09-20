class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        int cnt = 0;
        for(String now : skill_trees){
            int idx = -1;
            boolean flag = false;
            for(int i=0; i<now.length(); i++){
                if(!flag){
                    for(int j=0; j<skill.length(); j++){
                        if(skill.charAt(j) == now.charAt(i)){
                            if((j- idx) != 1){
                                flag = true;
                                break;
                            }
                            idx = j;
                        }
                    }
                }
            }
            if(!flag) cnt++;
        }
        return cnt;
    }
}
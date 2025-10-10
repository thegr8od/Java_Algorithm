class Solution {
    static int cnt;
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int limit = health;
        int day = bandage[0]; // 얼마나 연속
        int plus = bandage[1];
        int bonus = bandage[2];
        int now = 0;
        for(int[] attack : attacks){
            if(now < attack[0]){
                for(int i = now ; i< attack[0]; i++){
                    now++;
                    cnt++;
                    if(cnt < day){
                        health += plus;
                    }
                    else{
                        health += bonus;
                        health += plus;
                        cnt = 0;
                    }
                    
                    if(health > limit){
                        health = limit;
                    }
                }
            }
            
            if(now == attack[0]){
                health -= attack[1];
                cnt = 0;
                if(health <= 0){
                    return -1;
                }
                now++;
            }
            
            
        }
        return health;
    }
}
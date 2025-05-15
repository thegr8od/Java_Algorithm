class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int t = bandage[0]; // t초 동안
        int x = bandage[1]; // x만큼 회복
        int y = bandage[2]; // t초 연속 회복시 보너스
        int time = 1;
        int atkIdx = 0;
        int nowH = health;
        int cnt =0;
        while(true){
            int atkTime = attacks[atkIdx][0];
            int damage = attacks[atkIdx][1];
            if(time < atkTime) {
                nowH += x;
                cnt++;
                if(cnt==t){
                    nowH += y;
                    cnt = 0;
                }
                if(nowH>health) nowH=health;
               
            }
            else if(time==atkTime){
                nowH -= damage;
                if(nowH <= 0) return -1;
                cnt = 0;
                atkIdx++;
                if(atkIdx == attacks.length){
                    return nowH;
                }
                
                
            }
            time++;
                
        }
        
    }
}
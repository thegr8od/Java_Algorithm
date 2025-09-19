class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
    
        for(int x=0; x<timelogs.length; x++){
            int day = startday;
            int cnt = 0;
            int hour2 = schedules[x] / 100;
            int minute2 = schedules[x] % 100;
            int time2 = hour2 * 60 + minute2;
            for(int i=0; i<timelogs[x].length; i++){
                if(day > 7) day = 1;
                if(day == 6 || day == 7 ){
                    day++;
                    continue;
                }
                else{
                    int hour = timelogs[x][i] / 100;
                    int minute = timelogs[x][i] % 100;
                    int time = hour * 60 + minute;
                    if(time <= time2 || (time - time2) <= 10) cnt++;
                }
                day++;
            }
            if(cnt == 5) answer++;
        }
        
        return answer;
        
    }
}
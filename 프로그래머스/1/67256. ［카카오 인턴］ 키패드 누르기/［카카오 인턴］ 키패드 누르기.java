import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lx = 3;
        int ly = 0;
        int rx = 3;
        int ry = 2;
        
        for(int num : numbers){
            if(num == 1){
                answer += "L";
                lx = 0;
                ly = 0;
            }
            else if(num == 4){
                answer += "L";
                lx = 1;
                ly = 0;
            }
            else if(num == 7){
                answer += "L";
                lx = 2;
                ly = 0;

            }
            else if(num == 3){
                answer += "R";
                rx = 0;
                ry = 2;
            }
            else if(num == 6){
                answer += "R";
                rx = 1;
                ry = 2;
            }
            else if(num == 9){
                answer += "R";
                rx = 2;
                ry = 2;
            }
            else if(num == 2){
                int lSum = Math.abs(lx-0) + Math.abs(ly-1);
                int rSum = Math.abs(rx-0) + Math.abs(ry-1);

                if(lSum == rSum) {
                    if(hand.equals("right")){
                        answer += "R";
                        rx = 0;
                        ry = 1;
                    }
                    else{
                        answer += "L";
                        lx = 0;
                        ly = 1;
                    }
                }
                else if (lSum < rSum) {
                    answer += "L";
                    lx = 0;
                    ly = 1;
                }
                else{
                    answer += "R";
                    rx = 0;
                    ry = 1;
                }
            }
            else if(num == 5){
                int lSum = Math.abs(lx-1) + Math.abs(ly-1);
                int rSum = Math.abs(rx-1) + Math.abs(ry-1);
                if(lSum == rSum) {
                    if(hand.equals("right")){
                        answer += "R";
                        rx = 1;
                        ry = 1;
                    }
                    else{
                        answer += "L";
                        lx = 1;
                        ly = 1;
                    }
                }
                else if (lSum < rSum) {
                    answer += "L";
                    lx = 1;
                    ly = 1;
                }
                else{
                    answer += "R";
                    rx = 1;
                    ry = 1;
                }
            }
            else if(num == 8){
                int lSum = Math.abs(lx-2) + Math.abs(ly-1);
                int rSum = Math.abs(rx-2) + Math.abs(ry-1);
                if(lSum == rSum) {
                    if(hand.equals("right")){
                        answer += "R";
                        rx = 2;
                        ry = 1;
                    }
                    else{
                        answer += "L";
                        lx = 2;
                        ly = 1;
                    }
                }
                else if (lSum < rSum) {
                    answer += "L";
                    lx = 2;
                    ly = 1;
                }
                else{
                    answer += "R";
                    rx = 2;
                    ry = 1;
                }
            }
            else if(num == 0){
                int lSum = Math.abs(lx-3) + Math.abs(ly-1);
                int rSum = Math.abs(rx-3) + Math.abs(ry-1);
                if(lSum == rSum) {
                    if(hand.equals("right")){
                        answer += "R";
                        rx = 3;
                        ry = 1;
                    }
                    else{
                        answer += "L";
                        lx = 3;
                        ly = 1;
                    }
                }
                else if (lSum < rSum) {
                    answer += "L";
                    lx = 3;
                    ly = 1;
                }
                else{
                    answer += "R";
                    rx = 3;
                    ry = 1;
                }
            }
            
            
            
        }
        return answer;
    }
    
}
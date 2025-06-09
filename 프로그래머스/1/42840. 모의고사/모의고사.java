class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int oneIdx = 0;
        int twoIdx = 0;
        int threeIdx = 0;
        
        int oneAns = 0;
        int twoAns = 0;
        int threeAns = 0;
        
        for(int num : answers){
            if(one[oneIdx++ % one.length] == num){
                oneAns++;
                if(oneIdx == one.length){
                    oneIdx = 0;
                }
            }
            
            if(two[twoIdx++ % two.length] == num){
                twoAns++;
                if(twoIdx == two.length){
                    twoIdx = 0;
                }
            }
            
            if(three[threeIdx++% three.length] == num){
                threeAns++;
                if(threeIdx == three.length){
                    threeIdx = 0;
                }
            }
            
        }
        int maxNum = Math.max(Math.max(oneAns, twoAns), threeAns);
        
        int size = 0;
        if(maxNum == oneAns){
            size++;
        }
        if(maxNum == twoAns){
            size++;
        }
        if(maxNum == threeAns){
            size++;
        }
        int idx = 0;
        int[] answer = new int[size];
        if(maxNum == oneAns){
            answer[idx++] = 1;
        }
        if(maxNum == twoAns){
            answer[idx++] = 2;
        }
        if(maxNum == threeAns){
            answer[idx++] = 3;
        }
        
        
        
        return answer;
    }
}
class Solution {
    public int solution(String s) {
        int answer = 0;
        String ans = "";
        String temp = "";
        String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                ans += s.charAt(i);
            }
            else{
                temp += s.charAt(i);
            }
            for(int j=0; j<10; j++){
                    if(temp.equals(numbers[j])){
                        ans += j;
                        temp = "";
                    }
                
            }
        }
        answer = Integer.parseInt(ans);
        return answer;
    }
}
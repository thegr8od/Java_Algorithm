import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] data = new String[numbers.length];
        
        for(int i=0; i<data.length; i++){
            data[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(data, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        if(data[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : data){
            sb.append(str);
        }
        
        
        return sb.toString();
        
    }
}
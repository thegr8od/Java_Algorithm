import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<Node> lst = new ArrayList<>();
        for(int i =0; i<files.length; i++){
            String file = files[i];
            int dot = file.lastIndexOf(".");
            if(dot == -1){
                dot = file.length();
            }
            String namePart = file.substring(0, dot);
            int idx = 0;
            while(idx<namePart.length() && !Character.isDigit(namePart.charAt(idx))){
                idx++;
            }
            
            int start = idx;
            while(idx<namePart.length() && Character.isDigit(namePart.charAt(idx))){
                idx++;
            }
            
            String head = namePart.substring(0, start).toLowerCase();
            int number = Integer.parseInt(namePart.substring(start, idx));
            lst.add(new Node(file,head,number,i));
            
        }
        Collections.sort(lst);
        String[] answer = new String[lst.size()];
        for(int i=0; i<lst.size(); i++){
            answer[i] = lst.get(i).file;
        }
        return answer;
    }
    
    class Node implements Comparable<Node>{
        String file;
        String head;
        int number;
        int index;
        
        public Node(String file, String head, int number, int index){
            this.file = file;
            this.head = head;
            this.number = number;
            this.index = index;
        }
        
        @Override
        public int compareTo(Node o){
            if (this.head.equals(o.head) && this.number == o.number){
                return Integer.compare(this.index, o.index);
            }
            else if (this.head.equals(o.head)){
                return Integer.compare(this.number, o.number);
            }
            return this.head.compareTo(o.head);
        }
    }
        
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] bing;
    static int[][] ans;
    static int cnt,line,howC;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
    	
    	bing = new int[5][5];
    	ans = new int[5][5];
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


       
       for(int i=0; i<5; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   for (int j=0; j<5; j++) {
    		   bing[i][j] = Integer.parseInt(st.nextToken());
    	   }
       }
       
       for(int i=0; i<5; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   for(int j=0; j<5; j++) {
    		   int target = Integer.parseInt(st.nextToken());
    		   howC++;
    		   write(target);
   	  		if(cnt>=3) {
	  			System.out.println(howC);
	  			return;
	  		}
    		   
    	   }

       }
    }
    
    static void write(int target) {
    	for (int i=0; i<5; i++) {
    		for (int j=0; j<5; j++) {
    			if(bing[i][j] == target) {
    				ans[i][j] =1;
    		  		findAnsRow(i,j,0);
    		  		findAnsCol(i,j,0);
    		  		if(i+j == 4) {
    		  		findAnsDG2(i,j,0);
    		  		}
    		  		if(i==j) {
        		  	findAnsDG(i,j,0);
    		  		}
    			}
    		}
    	}
    	
    }
    
    static void findAnsRow(int x, int y, int k) {
    	for (int i=0; i<5; i++) {
    		if(ans[x][i] == 1) {
    			k++;
    		}
    	}
    	if(k==5) {
    		cnt++;
    	}
    }
    
    static void findAnsCol(int x, int y, int k) {
    	for (int i=0; i<5; i++) {
    		if(ans[i][y] == 1) {
    			k++;
    		}
    	}
    	if(k==5) {
    		cnt++;
    	}
    }
    
    static void findAnsDG(int x, int y, int k) {
    	for(int i=0; i<5; i++) {
    		if(ans[i][i] == 1) {
    			k++;
    		}
    	}
    	if(k==5) {
    		cnt++;
    	}
    	
    }
    
    static void findAnsDG2(int x, int y, int k) {
    	for(int i=0; i<5; i++) {
    		if(ans[i][4-i] == 1) {
    			k++;
    		}
    	}
    	if(k==5) {
    		cnt++;
    	}
    	
    }
}

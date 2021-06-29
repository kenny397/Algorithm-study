package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C1339 {
    public static void main(String[] args) {
        
       
        Scanner sc = new Scanner(System.in);
        int[]alpha=new int[26];
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
        	String t=sc.next();
        	int l=t.length();
        	for(int j=0; j<l; j++) {
        		alpha[t.charAt(j)-'A']+=Math.pow(10, l-1-j);
        	}
        }
        int ret=0;
        int idx=9;
        Arrays.sort(alpha);
        for(int i=25; i>=0; i--) {
        	ret+=idx*alpha[i];
        	idx--;
        }
        	
        System.out.println(ret);
        
        
       
    }
}
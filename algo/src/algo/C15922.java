package algo;

import java.util.Scanner;

public class C15922 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long[][]lines=new long[n][2];
		for(int i=0; i<n; i++) {
			lines[i][0]=sc.nextLong();
			lines[i][1]=sc.nextLong();
		}
		long ret=0;
		long start=lines[0][0];
		long end=lines[0][1];
		for(int i=1; i<n; i++) {
			if(lines[i][1]<=end) {
				continue;
			}
			else if(lines[i][0]<=end) {
				
					end=lines[i][1];
				
			}else {
				ret+=end-start;
				start=lines[i][0];
				end=lines[i][1];
			}
		
			
		}
		ret+=end-start;
		System.out.println(ret);
	}
	
}

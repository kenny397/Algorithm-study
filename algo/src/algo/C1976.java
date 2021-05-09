package algo;

import java.util.Scanner;

public class C1976 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[]plan=new int[m];
		int[][]map=new int[n][n];
		
		for(int i=0;i<n; i++) {
			for(int j=0; j<n; j++) {
				int q=sc.nextInt();
				
				map[i][j]=q;
                if(i==j)map[i][j]=1;
			}
		}
		for(int i=0; i<m; i++) {
			plan[i]=sc.nextInt();
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0;i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][k]==1&&map[k][j]==1){
                       map[i][j]=1; 
                    }
				}
			}
		}
		boolean flag=false;
		for(int i=0;i<m-1; i++) {
			if(map[plan[i]-1][plan[i+1]-1]==0) {
				flag=true;
				break;
			}
			
		}
		if(!flag)System.out.println("YES");
		if(flag)System.out.println("NO");
		
	}


}

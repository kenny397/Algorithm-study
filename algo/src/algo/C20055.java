package algo;
import java.util.*;
public class C20055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] belt=new int[2*n];
		boolean[]robot=new boolean[n];
		int left=0;
		int right=n-1;
		for(int i=0; i<belt.length; i++) {
			belt[i]=sc.nextInt();
		}
		int count=0;
		while(k>0) {
			count++;
			left--;
			right--;
			if(left<0) {
				left=left+2*n;
			}
			if(right<0) {
				right=right+2*n;
			}	
			for(int i=n-2; i>=0;i--) {
				robot[i+1]=robot[i];
				
			}robot[0]=false;
			robot[n-1]=false;
			//1
			
			
			for(int i=n-2; i>=0; i--) {
				if(robot[i]) {
					int idx2=i+left+1;
						if(idx2>=2*n)idx2-=2*n;
					
					if(belt[idx2]>=1) {
						if(!robot[i+1]) {
							robot[i]=false;
							   if(i+1 < n-1)
			                        robot[i + 1] = true;
							
							belt[idx2]--;
							if(belt[idx2]==0) {
							k--;
						}
						}
						
					}
				}
			}
			//2
			if(belt[left]>0) {
				robot[0]=true;
				belt[left]--;
				if(belt[left]==0) {
				k--;
			}
			}
			
			//3
			
		}
		System.out.println(count);
		
	}
	

}

package algo;
import java.util.*;
public class C2110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int answer=0;
		int n=sc.nextInt();
		int[]houses=new int[n];
		int c=sc.nextInt();
		for(int i=0; i<n; i++) {
			houses[i]=sc.nextInt();
		}
		Arrays.sort(houses);
		if(c==2) {
			answer=houses[n-1]-houses[0];
		}else {
			c=1;
			for(int i=0; i<c; i++) {
				int start=houses[0];
				int end=houses[n-1];
				int midv=(houses[n-1]-houses[0])/2;
			
				
			}
			
		}
	}

}

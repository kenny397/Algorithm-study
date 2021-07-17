import java.util.Arrays;
import java.util.Scanner;

public class C2579 {
static int n;
static int cache[];
static int steps[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		steps=new int[301];
		cache=new int[301];
		Arrays.fill(cache, -1);
		for(int i=1;i<=n; i++) {
			steps[i]=sc.nextInt();
			
		}
		cache[0]=steps[0];
		cache[1]=steps[1];
		cache[2]=steps[2]+steps[1];
		System.out.println(dp(n));
	}
	static int dp(int k) {
		
		if(cache[k]!=-1)return cache[k];
		
		
		cache[k]=Math.max(dp(k-2),dp(k-3)+steps[k-1])+steps[k];
		
					
			
		return cache[k];
		
		
	}

}

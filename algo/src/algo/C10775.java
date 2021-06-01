package algo;

import java.util.Scanner;

public class C10775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int g=sc.nextInt();
		int p=sc.nextInt();
		int[] G=new int[g+1];
		boolean[]v=new boolean[g+1];
		int answer=0;
		boolean flag=false;
		for(int i=0; i<p; i++) {
			int a=sc.nextInt();
			while(a>0) {
				if(flag)break;
				if(!v[a]) {
					v[a]=true;
					answer++;
					break;
				}
				a--;
			}
			if(a==0) {
				flag=true;
			}
		}
		System.out.println(answer);
	}

}

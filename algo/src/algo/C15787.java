package algo;

import java.util.HashSet;
import java.util.Scanner;

public class C15787 {
static int [][]trains;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		HashSet<String> checktrain=new HashSet<>();
		trains =new int[n][20];
		for(int i=0; i<m; i++) {
			int command=sc.nextInt();
			if(command<3) {
				setTrain(command,sc.nextInt()-1,sc.nextInt()-1);
			}else {
				setTrain(command,sc.nextInt()-1,0);
			}
		}
		for(int i=0; i<n; i++) {
			String s="";
			for(int j=0; j<20; j++) {
				s+=trains[i][j];
			}
			checktrain.add(s);
		}
		System.out.println(checktrain.size());
	}
	public static void setTrain(int command,int train,int target) {
		if(command==1) {
			trains[train][target]=1;
		}
		if(command==2) {
			trains[train][target]=0;
		}
		if(command==3) {
			for(int i=19; i>0; i--) {
				trains[train][i]=trains[train][i-1];
			}
			trains[train][0]=0;
		}
		if(command==4) {
			for(int i=0; i<19; i++) {
				trains[train][i]=trains[train][i+1];
			}
			trains[train][19]=0;
		}
	}

}

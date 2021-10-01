package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_특이한자석 {
static int[][] wheels;
static ArrayList<Node> al;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int k=Integer.parseInt(br.readLine());
			 wheels=new int[4][8];
			 al=new ArrayList<>();
			 for(int i=0; i<4; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					wheels[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int sum=0;
			for(int i=0; i<k; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				int target=Integer.parseInt(st.nextToken())-1;
				int dir=Integer.parseInt(st.nextToken());
				operate(target,dir);
				
				for(int j=0; j<al.size(); j++) {
					rotate(al.get(j).target, al.get(j).dir);
				}
//				for(int z=0; z<4; z++) {
//					System.out.println();
//					for(int j=0; j<8; j++) {
//						System.out.print(wheels[z][j]+" ");
//					}
//					
//				}
			
				al=new ArrayList<>();
			}	
			for(int j=0; j<4; j++) {
					sum+=wheels[j][0]<<j;
			}
			System.out.println("#"+t+" "+sum);
		}
	}
	static void rotate(int target,int dir) {
		if(dir==1) {
			int temp=wheels[target][7];
			for(int i=7; i>0; i--) {
				wheels[target][i]=wheels[target][i-1];
			}
			wheels[target][0]=temp;
		}
		if(dir==-1) {
			int temp=wheels[target][0];
			for(int i=0; i<7; i++) {
				wheels[target][i]=wheels[target][i+1];
			}
			wheels[target][7]=temp;
		}
	}
	static void operate(int target,int dir) {
		int idx=target;
		int d=dir;
		al.add(new Node(target,dir));
		while(true) {
			if(idx==3)break;
			if(wheels[idx][2]==wheels[idx+1][6]) {
				break;
			}else {
				al.add(new Node(idx+1,d*-1));
				d*=-1;
				idx++;
			}
		}
		d=dir;
		idx=target;
		while(true) {
			if(idx==0)break;
			if(wheels[idx][6]==wheels[idx-1][2]) {
				break;
			}else {
				al.add(new Node(idx-1,d*-1));
				d*=-1;
				idx--;
			}
		}
	
		
	}
	static class Node{
		int target,dir;

		public Node(int target, int dir) {
			super();
			this.target = target;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Node [target=" + target + ", dir=" + dir + "]";
		}
		
	}

}

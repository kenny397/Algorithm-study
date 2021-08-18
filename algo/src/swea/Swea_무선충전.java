package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_무선충전 {
static int dx[]= {0,-1,0,1,0};
static int dy[]= {0,0,1,0,-1};
static int a;
static int m;
static int[]moveA;
static int[]moveB;
static Ap[] aps;
static Map[][] map;
static int ret;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
		ret=0;
		StringTokenizer st= new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		a=Integer.parseInt(st.nextToken());
		moveA=new int[m];
		moveB=new int[m];
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			moveA[i]=Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			moveB[i]=Integer.parseInt(st.nextToken());
		}
		aps=new Ap[a];
		for(int i=0; i<a; i++) {
			st= new StringTokenizer(br.readLine());
			
			aps[i]=new Ap(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
		}
		map=new Map[10][10];
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				map[i][j]=new Map(new ArrayList<>());
			}
		}
		insert();
//		for(int i=0; i<10; i++) {
//			for(int j=0; j<10; j++) {
//				System.out.print(map[i][j].list+"\t");
//			}
//			System.out.println();
//		}

		walk();
		System.out.println("#"+t+" "+ret);
		}
	}
	static void walk() {
		// TODO Auto-generated method stub
		int ax=0;
		int ay=0;
		int bx=9;
		int by=9;
		
		ret+=charge(ax,ay,bx,by);
		for(int i=0; i<m; i++) {
			ax=ax+dx[moveA[i]];
			ay=ay+dy[moveA[i]];
			bx=bx+dx[moveB[i]];
			by=by+dy[moveB[i]];
			
			ret+=charge(ax,ay,bx,by);
			
//			System.out.println((i+1)+" "+ret);
//			if(i==9) {
//				System.out.println(ax+" "+ay);
//			}
		}
	}
	static int charge(int ax,int ay,int bx,int by){
		int sum=0;
		int max=0;
		int maxidx=-2;
		int bmax=0;
		int bmaxidx=-1;
		for(int i=0; i<map[ax][ay].list.size(); i++) {
			if(aps[map[ax][ay].list.get(i)].p>max) {
				max=aps[map[ax][ay].list.get(i)].p;
				maxidx=map[ax][ay].list.get(i);
			}
		}
		for(int i=0; i<map[bx][by].list.size(); i++) {
			if(aps[map[bx][by].list.get(i)].p>bmax) {
				bmax=aps[map[bx][by].list.get(i)].p;
				bmaxidx=map[bx][by].list.get(i);
			}
		}
		if(bmaxidx!=maxidx) {
			sum=max+bmax;
		}else {
			if(map[ax][ay].list.size()==1) {
				if(map[bx][by].list.size()==1) {
					sum=max;
				}else {
					int bmax2=0;
					int bmax2idx=-1;
					for(int i=0; i<map[bx][by].list.size(); i++) {
						if(aps[map[bx][by].list.get(i)].p>=bmax2&&bmaxidx!=map[bx][by].list.get(i)) {
							bmax2=aps[map[bx][by].list.get(i)].p;
							bmax2idx=map[bx][by].list.get(i);
						}
					}
					sum=max+bmax2;
				}
				
			}
			else {
				if(map[bx][by].list.size()==1) {
					int max2=0;
					int max2idx=-1;
					for(int i=0; i<map[ax][ay].list.size(); i++) {
						if(aps[map[ax][ay].list.get(i)].p>=max2&&maxidx!=map[ax][ay].list.get(i)) {
							max2=aps[map[ax][ay].list.get(i)].p;
							max2idx=map[ax][ay].list.get(i);
						}
					}
					sum=max2+bmax;
				}else {
					int max2=0;
					int max2idx=-1;
					for(int i=0; i<map[ax][ay].list.size(); i++) {
						if(aps[map[ax][ay].list.get(i)].p>=max2&&maxidx!=map[ax][ay].list.get(i)) {
							max2=aps[map[ax][ay].list.get(i)].p;
							max2idx=map[ax][ay].list.get(i);
						}
					}
					int bmax2=0;
					int bmax2idx=-1;
					for(int i=0; i<map[bx][by].list.size(); i++) {
						if(aps[map[bx][by].list.get(i)].p>=bmax2&&bmaxidx!=map[bx][by].list.get(i)) {
							bmax2=aps[map[bx][by].list.get(i)].p;
							bmax2idx=map[bx][by].list.get(i);
						}
					}
					if(max2>bmax2) {
						sum=max2+bmax;
					}else {
						sum=max+bmax2;
					}
				}
			}
		}
		
		
		
		return sum;
	}
	static void insert(){
		for(int i=0; i<a; i++) {
			Ap ap=aps[i];
			int x=ap.x-ap.c;
			for(int j=0; j<=ap.c; j++) {
				for(int k=0; k<=j; k++) {
					if(checkMap(x+j,ap.y+k)) {
						if(!map[x+j][ap.y+k].list.contains(ap.no))
						map[x+j][ap.y+k].list.add(ap.no);
					}
					if(checkMap(x+j,ap.y-k)) {
						if(!map[x+j][ap.y-k].list.contains(ap.no))
						map[x+j][ap.y-k].list.add(ap.no);
					}
				}
			}
			x=ap.x;
			for(int k=1; k<=ap.c; k++) {
				for(int j=ap.c-k;j>=0; j--) {
				if(checkMap(x+k,ap.y+j)) {
					if(!map[x+k][ap.y+j].list.contains(ap.no))
					map[x+k][ap.y+j].list.add(ap.no);
				}
				if(checkMap(x+k,ap.y-j)) {
					if(!map[x+k][ap.y-j].list.contains(ap.no))
					map[x+k][ap.y-j].list.add(ap.no);
				}
				
				}
			}
			
			
			
		}
	}
	static class Ap{
		int x,y,c,p,no;

		public Ap(int y, int x, int c, int p,int no) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
			this.no=no;
		}
		
	}
	static class Map{
		ArrayList<Integer>list;

		public Map(ArrayList<Integer> list) {
			super();
			this.list = list;
		}
	}
	static boolean checkMap(int x, int y) {
		if(x<0||x>=10||y<0||y>=10)return false;
		return true;
	}

}

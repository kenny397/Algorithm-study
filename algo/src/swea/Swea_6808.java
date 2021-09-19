package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_6808 {
static int win;
static int lose;
static int[] cards;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = pI(st.nextToken());
	
		for (int t = 1; t <= T; t++) {
			cards=new int[9];
			win=0;
			lose=0;
			int flag = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int card = pI(st.nextToken());
				cards[i]=card;
				flag = flag | 1 << card;
			}
			
			play(0,flag,0,0);
			System.out.println("#"+t+" "+win+" "+lose);
			
		}

	}
	static void play(int deep,int flag,int apoint,int bpoint) {
		if(deep==9) {
			if(apoint>bpoint)win++;
			if(apoint<bpoint)lose++;
			return;
		}
		for(int i=1; i<=18; i++) {
			if((flag&(1<<i))==0) {
				if(cards[deep]>i) {
					play(deep+1,(flag|(1<<i)),apoint+cards[deep]+i,bpoint);
				}
				if(cards[deep]<i) {
					play(deep+1,(flag|(1<<i)),apoint,bpoint+cards[deep]+i);
				}
				
			}
		}
	}

	private static int pI(String readLine) {
		// TODO Auto-generated method stub
		return Integer.parseInt(readLine);
	}

}

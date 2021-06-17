package algo;

import java.util.Scanner;

public class C17281 {

	static int result;
	static int[][] players;
	static boolean[]v;
	static int[]player;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		players = new int[n][9];
		result = 0;
		v = new boolean[9];
		player = new int[9];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 9; j++) {
				players[i][j] = sc.nextInt();
			}
		}
		v[3]=true;
		player[3]=0;
		dfs(1);
		System.out.println(result);

	}
	static void dfs(int count) {
		if(count ==9) {
			play();
		}else {
			for(int i=0; i<9; i++) {
				if(!v[i]) {
					v[i]=true;
					player[i]=count;
					dfs(count+1);
					v[i]=false;
				}
			}
		}
	}

	static void play() {
	
		int start=0;
		
		int score=0;
		for(int i=0; i<n; i++) {
			int outcnt = 0;
			boolean state1=false;
			boolean state2=false;
			boolean state3=false;
			while (outcnt < 3) {
				if (players[i][player[start]] == 0) {
					outcnt++;
					
				}
				else if (players[i][player[start]] == 1) {
					if(state3) {
						score++;
						state3=false;
					}
					if(state2) {
						state3=true;
						state2=false;
					}
					if(state1) {
						state2=true;
					}
					state1=true;
					
				}
				else if (players[i][player[start]] == 2) {
					if(state3) {
						score++;
						state3=false;
					}
					if(state2) {
						score++;
						state2=false;
					}
					if(state1) {
						state3=true;
						state1=false;
					}
					state2=true;
					
				}
				else if (players[i][player[start]] == 3) {
					if(state3) {
						score++;
						state3=false;
					}
					if(state2) {
						score++;
						state2=false;
					}
					if(state1) {
						score++;
						state1=false;
					}
					state3=true;
					
				}
				else if (players[i][player[start]] == 4) {
					if(state3) {
						score++;
						state3=false;
					}
					if(state2) {
						score++;
						state2=false;
					}
					if(state1) {
						score++;
						state1=false;
					}
					
					score++;
				}
				start++;
				if(start==9)start=0;
			}
		}
		result=Math.max(result, score);

	}

}

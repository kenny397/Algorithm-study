package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C1260 {
static int N;
static int M;
static int V;
static int [][] map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			map[start][end]=1;
			map[end][start]=1;
		}
		boolean[]v=new boolean[N+1];
		v[V]=true;
		dfs(V,v);
		System.out.println();
		bfs();
	}
	private static void bfs() {
		Queue<Integer> q= new LinkedList<>();
		q.offer(V);
		boolean[]v=new boolean[N+1];
		v[V]=true;
		while(!q.isEmpty()) {
			int current = q.poll();
			System.out.print(current+" ");
			for(int i=1; i<=N;i++ ) {
				if(map[current][i]==1&&!v[i]) {
					v[i]=true;
					q.add(i);
				}
			}
		}
	}
	private static void dfs(int now,boolean[] v) {
		System.out.print(now+ " ");
		for(int i=1; i<=N; i++) {
			if(!v[i]&&map[now][i]==1) {
				v[i]=true;
				dfs(i,v);
			}
		}
	}

}

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class C17619 {
static int[] parent;
static int[] size;
	public static void main(String[] args)throws IOException {
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
		Scanner sc=new Scanner(System.in);
		int n = Integer.parseInt(temp[0]);
		int q=Integer.parseInt(temp[1]);
		Tree[] trees=new Tree[n+1];
		parent=new int[n+1];
		size=new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i]=i;
			size[i]=1;
            temp = br.readLine().split(" ");
            trees[i] = new Tree( Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),i);
        }trees[0]=new Tree(-1,-1,-1,-1);
		Arrays.sort(trees);
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++ ) {
				if(trees[i].x2>=trees[j].x1) {
				union(trees[i].idx,trees[j].idx);
			}else {
				break;
			}
		}
			
		}
		StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);

            int r1=find(u);
            int r2 =find(v);

            if (r1 == r2) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }
        System.out.print(sb);
    }
		
	
	static void union(int x,int y) {
		int a=find(x);
		int b=find(y);
		if(size[a]>size[b]) {
			int temp=a;
			a=b;
			b=temp;
		}
		parent[a]=b;
		size[b]+=size[a];
	}
	static int find(int x) {
		if(parent[x]==x) {
			return x;
		}
		return parent[x]=find(parent[x]);
	}
	static class Tree implements Comparable<Tree>{
		int x1;
		int x2;
		int y;
		int idx;
		Tree(int x1, int x2,int y,int idx){
			this.x1=x1;
			this.x2=x2;
			this.y=y;
			this.idx=idx;
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			if(this.x1==o.x1) {
				return this.x2-o.x2;
			}
			return this.x1-o.x1;
		}
	}

}

package programmers;

import java.util.Arrays;

public class PS_섬연결하기 {
static int[] parent;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int[][]c= {{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4},{2,4,6},{4,0,7}};
		solution(n,c);
	}
	
	//union find
	// 그래프 알고리즘 
	// 가장 짧은거 연결하고 연결 됬는지 확인하기
	public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent=new int[n+1];
        for(int i=0; i<n; i++) {
        	parent[i]=i;
        }
        
        
        
        boolean[]v=new boolean[n];
        Arrays.sort(costs,(o1,o2)->o1[2]-o2[2]);
        int idx=0;
        int sum=0;
        while(true) {
        	boolean flag=false;
        	for(int i=0; i<n; i++) {
        		if(find(parent[i])!=0)flag=true;
        	}
        	if(!flag)break;
        	if(find(parent[costs[idx][0]])!=find(parent[costs[idx][1]])) {
        		sum+=costs[idx][2];
        		union(costs[idx][0],costs[idx][1]);
        	//	System.out.println(costs[idx][0]+" "+costs[idx][1]+" "+costs[idx][2]+" ");
        		
        	}
        	
        	idx++;
        	
        }
        
      //  System.out.println(sum);
        return sum;
    }
	
	
	static int find(int x) {
    	if(x==parent[x])return x;
    	return parent[x]=find(parent[x]);
    }static void union(int x, int y) {
    	x=find(x);
    	y=find(y);
    	if(x==y)return;
    	if(x>y) {
    		parent[x]=y;
    	}else {
    		parent[y]=x;
    	}
    }


}

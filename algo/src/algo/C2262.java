package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C2262 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//int[] arr = new int[n];
		List<Integer> list = new ArrayList<Integer>();
		int min = 0;
		
		for(int i=0; i<n; i++) 
			list.add(scan.nextInt());
			
		int max = n;	// 가장 랭킹이 낮은(숫자가 높은) 선수 
		for(int i=0; i<n-1; i++) {
			int idx = list.indexOf(max);	// 랭킹이 낮은 선수의 인덱스
			
			// 랭킹이 가장 낮은 선수가 가장 앞에 있을경우 => 그 뒤 선수와의 차이
			if(idx == 0)
				min += list.get(idx) - list.get(idx + 1);
			// 랭킹이 가장 낮은 선수가 가장 끝에 있을경우 => 그 앞 선수와의 차이
			else if(idx == list.size()-1) 
				min += list.get(idx) - list.get(idx -1);
			
			// 랭킹이 가장 낮은 선수가 중앙 어딘가에 있을경우 => 앞, 뒤 선수중 차이가 작은 선수와 매칭
			else
				min += Math.min(list.get(idx) - list.get(idx-1), list.get(idx) - list.get(idx+1));
			
			list.remove(idx);	// 랭킹이 가장 높은 선수는 매칭이 끝났으므로 제거,
			max --;
		}
		
		System.out.println(min);
		scan.close();
	}

}
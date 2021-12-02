package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C14719 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] map= new int[W];
		int left=0;
		int right=0;
		int ret=0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int N = Integer.parseInt(st.nextToken());
			map[i] = N;
		}

		// 인덱스마다 모이는 빗물 계산 ( 1번째 기둥과 마지막 기둥의 위치는 제외 )
		for (int i = 1; i < W - 1; i++) {
			left = right = 0;
			// 왼쪽에서 가장 높은 건물의 높이
			for (int j = 0; j < i; j++) {
				left = Math.max(map[j], left);
			}
			// 오른쪽에서 가장 높은 건물의 높이
			for (int j = i + 1; j < W; j++) {
				right = Math.max(map[j], right);
			}
            // 더 낮은 건물을 기준으로 현재 인덱스에 모이는 빗물
			if (map[i] < left && map[i] < right) {
				ret += Math.min(left, right) - map[i];
			}
		}
		System.out.println(ret);
	}
}

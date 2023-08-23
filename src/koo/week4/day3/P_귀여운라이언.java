package koo.week4.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 98퍼센트에서 틀림 -> 예외처리
 * 1의 위치를 배열로 받음
 * k 사이즈만큼 거리를 계산함 -> 최솟값처리
 * 인덱스 범위 넘어가면 break;
 * 
 * 메모리 : 78208kb
 * 속도 : 420ms
 * @author SSAFY
 *
 */
public class P_귀여운라이언 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		int[] ans = new int[n];
		int index = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == 1) {
				ans[index] = i;
				index++;
			}
		}
		if(k == 1 && index != 0) {
			System.out.println(1);
			return;
		}else if(k == 1 && index == 0) {
			System.out.println(-1);
			return;
		}
		int target = k-1;
		int sta = 0;
		int answer = Integer.MAX_VALUE;
		while(target < n) {
			
			int tempA = ans[sta];
			int tempB = ans[target];
			if(tempB == 0) {
				break;
			}
			answer = Math.min(tempB - tempA + 1, answer);
			sta++;
			target++;
		}
		if(answer != Integer.MAX_VALUE) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
		
		
//		if(k == 1) {
//			System.out.println(1);
//			return;
//		}
//		int start = 0;
//		int end = 0;
//		int lion = 0;
//		int length = 0;
//		int maxLen = -1;
//		
//		while(start <= end) {
//			if(arr[end] == 1 && !visited[end]) {
//				lion += 1;
//				visited[end] = true;
//			}
//			
//			
//			if(lion == k) {
//				if(arr[start] != 1) {
//					start++;
//					length--;
//				}else {
//					maxLen = Math.min(length, maxLen);	
//					start++;
//					lion--;
//					length--;
//				}
//			}
//			if(lion < k) {
//				visited[end] = false;
//				end++;
//				length++;
//			}
//			if(end >= n) {
//				break;
//			}
//		}
//		
//		System.out.println(maxLen);
	}
}

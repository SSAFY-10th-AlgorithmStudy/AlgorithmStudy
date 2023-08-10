package com.ssafy.ps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_boj_13504_XOR {
	static int[] p;
	static int N;
	static boolean[] visited;
	static int res;
	static int temp;
	static int temp2;
	static int T,NN;
	static int max;
	static HashSet<Integer> set;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			res = 0;
			temp= 0;
			temp2 = 0;
			max = 0;
			N = Integer.parseInt(br.readLine());
			p = new int[N];
			set = new HashSet<Integer>();
			visited = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				
				p[j] = Integer.parseInt(st.nextToken());
				max = Math.max(max,p[j]);
			}
			char[] a = String.valueOf(Integer.toBinaryString(max)).toCharArray();
			for (int j = 0; j < a.length; j++) {
				if(a[j] == '0') { 
					a[j] = '1';}
			}
			String temp = new String(a);
			max=Integer.valueOf(temp,2);
			subset(0);
			System.out.println(res);
		}

	}

	private static void subset(int cnt) {
		if (cnt == N) {
			if(res==max) return;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					temp = p[i];
					temp2 = temp ^ temp2;
//					System.out.println(Integer.toBinaryString(temp2));
					res = Math.max(res, temp2);
				}
			}
			return;
		}
		if(res==max) return;
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);

	}

}

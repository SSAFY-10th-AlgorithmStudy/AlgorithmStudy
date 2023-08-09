package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_13504_XOR {
	static int[] p;
	static int n = p.length;
	static boolean[] visited;
	static int res;
	static int temp;
	static int temp2;
	static int T,NN;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			res = 0;
			temp= 0;
			temp2 = 0;
			NN = Integer.parseInt(br.readLine());
			p = new int[NN];
			visited = new boolean[NN];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < NN; j++) {
				p[j] = Integer.parseInt(st.nextToken());
			}
			subset(0);
			System.out.println(res);
		}

	}

	private static void subset(int cnt) {
		if (cnt == n) {
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					temp = p[i];
					temp2 = temp ^ temp2;
					res = Math.max(res, temp2);
				}
			}
			return;
		}
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);

	}

}

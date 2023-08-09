package koo.week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산 {
	static int n;
	static int m;
	static int targetA;
	static int targetB;
	static int[][] map;
	static boolean[] visited;
	static boolean flag = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		targetA = Integer.parseInt(st.nextToken())-1;
		targetB = Integer.parseInt(st.nextToken())-1;
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = 1;
			map[y - 1][x - 1] = 1;
		}
		recur(targetA,targetB,1);
		if(!flag) {
			System.out.println(-1);
		}

	}

	public static void recur(int index, int target,int depth ) {
		visited[index] = true;
		for (int i = 0; i < n; i++) {
			if (map[index][i] == 1) {
				if (i == target) {
					flag = true;
					System.out.println(depth);
					return;
				} else {
					if (!visited[i]) {
						recur(i, target,depth+1);
					}
				}
			}
		}
	}
}

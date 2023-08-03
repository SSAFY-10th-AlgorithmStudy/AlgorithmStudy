package koo.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_스티커_9465 {
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[2][n];
			visited = new boolean[2][n];
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		dfs(0,0,0);
		
	}

	public static void dfs(int x, int y, int value) {
		visited[x][y] = true;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				value += map[i][j];
				for (int k = 0; k < dx.length; k++) {
					
					int mx = i + dx[k];
					int my = j + dy[k];
					System.out.println(mx + " " + my);
					if (mx >= 0 && mx < 2 && my >= 0 && my < n && !visited[mx][my]) {
						visited[mx][my] = true;
						dfs(mx, my, value);
						visited[mx][my] = false;
					}else {
						return;
					}
				}				
			}
		}
		
	}

}

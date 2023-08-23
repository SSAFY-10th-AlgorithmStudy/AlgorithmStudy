package koo.week5.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import utils.PrintUtils;

public class 백준_불_4179 {
	static int n;
	static int m;
	static char[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<int[]> que = new LinkedList<>();
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n+2][m+2];
		visited = new boolean[n+2][m+2];
		int startX = 0;
		int startY = 0;
		for (int i = 1; i < n+1; i++) {
			
			String str = " "+ br.readLine();
			
			for (int j = 1; j < m+1; j++) {
				map[i][j] = str.charAt(j);  
				if(map[i][j] == 'F') {
					que.offer(new int[] {i,j,1,0});
				}
				if(map[i][j] == 'J') {
					startX = i;
					startY = j;
				}
			}
			
		} 
		init();
		que.offer(new int[] {startX,startY,0,0});
		
		BFS();
		
	}
	public static void init() {
		for(int i = 0; i<n+2;i++) {
			for (int j = 0; j < m+2; j++) {
				if(i == 0 || j == 0){
					map[i][j] = '*';	
				}
				if(i == n+1 || j == m+1) {
					map[i][j] = '*';
				}
			}
		}
	}
	public static void BFS() {
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int tx = temp[0];
			int ty = temp[1];
			int type = temp[2];
			int cnt = temp[3];
			visited[tx][ty] = true;
			for (int i = 0; i < dx.length; i++) {
				int mx = tx + dx[i];
				int my = ty + dy[i];
				if(check(mx,my) && !visited[mx][my]) {
					if(type == 1) {
						if(map[mx][my] == '.' || map[mx][my] == 'J') {
							map[mx][my] = 'F';
							que.offer(new int[] {mx,my,1,0});
						}
					}
					if(type == 0) {
						if(map[mx][my] == '.') {
							map[mx][my] = 'J';
							que.offer(new int[] {mx,my,0,cnt+1});
						}
						if(map[mx][my] == '*') {
							System.out.println(cnt+1);
							return;
						}
					}
					
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
	private static boolean check(int mx, int my) {
		// TODO Auto-generated method stub
		return mx>=0 && mx < n+2 && my >= 0 && my < m+2;
	}
	
}

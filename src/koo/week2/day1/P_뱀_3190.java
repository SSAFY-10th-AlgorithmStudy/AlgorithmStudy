package koo.week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import koo.utils.PrintUtils;

public class P_뱀_3190 {
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static HashMap<Integer,String> dirMap;
	static int n;
	static Queue<Move> movingTable = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());	
		map = new int[n][n];
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = 1;
		}
		dirMap = new HashMap<>();
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			dirMap.put(min+1, dir);
		}
		
		move(0,0,0,1);
		
		
	}
	static class Move{
		int x;
		int y;
		public Move(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	
	public static void move(int x,int y,int dir,int depth) {
		
		movingTable.add(new Move(x,y));
		map[x][y] = 2;
		System.out.println("depth = " + depth);
		PrintUtils.print2Array(map);
		int mx = x + dx[dir];
		int my = y + dy[dir];
		if(dirMap.containsKey(depth)) {
			if(dirMap.get(depth).equals("D")) {
				dir += 1;
			}
			else if(dirMap.get(depth).equals("L")) {
				dir -= 1;
			}
			if(dir < 0) {
				dir = 3;
			}else if(dir > 3) {
				dir = 0;
			}
			mx = x + dx[dir];
			my = y + dy[dir];
		}
		
		if(mx >= 0 && mx < n && my >= 0 && my < n && map[mx][my] != 2) {
			if(map[mx][my] == 0) {
				Move m = movingTable.poll();
				map[m.x][m.y] = 0;
			}
			move(mx,my,dir,depth+1);
		}else {
			System.out.println(depth);
			return;
		}
	}
}

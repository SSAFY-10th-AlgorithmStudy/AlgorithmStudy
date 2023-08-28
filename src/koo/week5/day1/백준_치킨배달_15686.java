
package koo.week5.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import utils.PrintUtils;

/**
 * 2의 개수를 구하고 조합으로 map의 경우의수를 생각하고 que에 2의 좌표를 넣어 BFS로 1의 위치를 탐색
 * 
 * 2의 좌표와 1의 좌표를 미리 arraylist 에 저장 후 거리계산할때 순회하는 방식으로 진행하면 속도를 더 줄일 수 있음
 * 
 * 메모리 : 258902 kb
 * 시간 : 524 ms
 * 
 * @author SSAFY
 *
 */
public class 백준_치킨배달_15686 {
	static int n;
	static int k;
	static int[][] map;
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static ArrayList<Point> points;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map= new int[n][n];
		points = new ArrayList<>();
		int size = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if( map[i][j] == 2) {
					points.add(new Point(i, j));
					size++;
					map[i][j] = 0;
				}
			}
		}
		comb(0,0,new Point[k]);
		System.out.println(ans);
	}
	static int ans = Integer.MAX_VALUE;
	public static void comb(int cnt,int index, Point[] p) {
		if(cnt == k) {
			
			ans = Math.min(BFS(p), ans);
			return;
		}
		for (int i = index; i < points.size(); i++) {
			Point temp = points.get(i);
			map[temp.x][temp.y]= 2; 
			p[cnt] = points.get(i);
			comb(cnt+1,i + 1,p);
			map[temp.x][temp.y]= 0; 
		}
	}
	
	public static int BFS(Point[] p) {
		Queue<int[]> que = new LinkedList<>();
		for(Point ps : p) {
			que.offer(new int[] {ps.x,ps.y,0});
		}
		boolean[][] visited= new boolean[n][n];
		int value = 0;
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			
			int tx = temp[0];
			int ty = temp[1];
			visited[tx][ty] = true;
			for (int i = 0; i < dx.length; i++) {
				int mx = tx + dx[i];
				int my = ty + dy[i];
				if(check(mx,my) && !visited[mx][my]) {
					visited[mx][my] = true;
					if(map[mx][my] == 1) {
						value += (temp[2] + 1);
					}
					que.add(new int[] {mx,my,temp[2]+1});
				}
			}
		}
		que.clear();
		return value;
	}

	private static boolean check(int mx, int my) {
		// TODO Auto-generated method stub
		return mx>=0 && mx < n && my >=0 && my <n;
	}
	
}

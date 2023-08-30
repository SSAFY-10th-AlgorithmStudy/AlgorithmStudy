package bj.elec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 일반적인 크루스칼 문제
// 하지만, 교수님이 알려주신 시간을 줄이는 방법 (r 배열 사용)을 사용하지 않으면 시간초과가 일어난다.
// 그리고 0 0 입력전까지 무한으로 입력받는 이상한 문제 입출력
public class Main {
	
	static class Node implements Comparable<Node> {
		int a;
		int b;
		int w;
		public Node(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {	
			return this.w - o.w;
		}
		
	}
	
	static int V, E, min, max;
	static PriorityQueue<Node> points;
	static int[] p, r;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 

		while(true){
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if(V==0 && E==0) break;
			
			points = new PriorityQueue<Node>();
			min=0;
			max=0;
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				points.add(new Node(a,b,w));
				max += w;
			}
			p = new int[V];
			r = new int[V];
			for (int i = 0; i < V; i++) {
				p[i] = i;
				r[i] = i;
			}
			
			int pqsize = points.size();
			for (int i = 0; i < pqsize; i++) {
				Node n = points.poll();
				if(union(n.a,n.b)) {
					min += n.w;
				}
			}

			System.out.println(max-min);

		}
		br.close();

	}
	private static boolean union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x==y) return false;
		else {
			if(r[x] < r[y]) {
				r[y] += r[x];
				p[x]=y;
			} else {
				r[x]+=r[y];
				p[y]=x;
			}
		}
		return true;
	}
	
	private static int find(int a) {
		if(p[a] == a) return a;
		else return (a=find(p[a]));
	}
}

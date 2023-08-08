import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] map;
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		map = new int[N][N];
		
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
	
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
    // 플로이드를 응용해서 풀이했지만,
    // 일반 dfs를 이용해서 풀이하는 것이 훨씬 빠른 속도를 보인다.
		for (int k = 0; k < N; k++) {
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					if(map[k][a]>0 && map[k][b]>0) {
						if(map[a][b] == 0) {
							map[a][b] = map[k][a] + map[k][b];
							map[b][a] = map[a][b];
						} else {
							int min = Math.min(map[a][b],map[k][a] + map[k][b]);
							map[a][b] = min;
							map[b][a] = min;
						}
					}
				}
			}
		}
		int answer = map[p1-1][p2-1];
		if(answer != 0) {
			System.out.println(answer);
		} else System.out.println("-1");
	}
}

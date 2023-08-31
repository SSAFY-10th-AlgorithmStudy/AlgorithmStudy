import java.io.*;
import java.util.*;

public class Main {
/* 코드의 전체 적인 해석
 * 1. 최소한의 빠른 탈출이기 때문에 이 문제는 항상 bfs로 풀어야한다. 두 가지 큐를 사용하는 BFS로 문제를 풀었다. 
 * 2. 먼저 que에 지훈이와 불이위치를 두 가지 큐에 담았다./ ( 이렇게 하지않으면 전체적인 matrix를 모두 찾아야하기때문)
 * 3. 예전에 수업시간에 했던 탈출문제처럼, 큐에 담아져 있는 사이즈만큼 큐를 돌린다.
 * 4. while문에 size를 초기화 함으로써, 관리가 더 쉬워진다.
 * 5. 지훈이는 리턴값이 int형인데 불필요한 코드를 줄일 수있다.
 * 6. 불의 bfs는 지훈이까지 다 바꿔준다.
 * 7. 지훈이는 항상 1개만 유지할 필요가없다. 최소한 시간을 탈출이기 때문에
 * 주의 할점  두 가지 큐를 사용하기 때문에 보통 복사해서사용하는데, nr nc의 조건을 잘 확인하는것이 좋다. que값등등
 */
	static int N, M;
	static char[][] map;
	static Queue<int[]> jihun;
	static Queue<int[]> fire;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		jihun = new ArrayDeque<>();
		fire = new ArrayDeque<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'J') {
					jihun.offer(new int[] { i, j ,1});
				}
				if (map[i][j] == 'F')
					fire.offer(new int[] { i, j });
			}
		}
		int count = 0;
		while (true) {
			if(jihun.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				break;
			}
            goFire();
			count = goJihun();
			if (count>0) {
				System.out.println(count);
				break;
			}
			
			
		}
	}

	private static void goFire() {
		int size = fire.size();
		while(size-->0) {
			int temp[] = fire.poll();
			int r = temp[0];
			int c = temp[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(exit(nr,nc)) continue;
//				if(map[nr][nc] == '#') continue;
				if(map[nr][nc] == '.' ||map[nr][nc] == 'J' ) {
					map[nr][nc] = 'F';
					fire.offer(new int[] {nr,nc});
				}
			}
		}
	}

	private static int goJihun() {
		int size = jihun.size();
		while(size-->0) {
			int temp[] = jihun.poll();
			int r = temp[0];
			int c = temp[1];
			int time = temp[2];
			for (int d = 0; d < 4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				if(exit(nr,nc)) return time;
				if(map[nr][nc] == '#' ||map[nr][nc] == 'F' ) continue;
				if(map[nr][nc] == '.') {
					map[nr][nc] = 'J';
					jihun.offer(new int[] {nr,nc,time+1});
				}
			}
		}
		return -1;
	}

	private static boolean exit(int r, int c) {
		return r<0 || c<0 || r>=N | c>=M;
	}

}

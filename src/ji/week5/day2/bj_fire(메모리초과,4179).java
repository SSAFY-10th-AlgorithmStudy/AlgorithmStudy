import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, W, cnt ,nh,nw,nexth,nextw;
	static char[][] map;
	static int answer = -1; 
	static Queue<int[]> que_player = new LinkedList<>();
	static Queue<int[]> que_fire = new LinkedList<>();
	static final int[] dh = new int[] {-1,0,1,0};
	static final int[] dw = new int[] {0,1,0,-1};
	/// main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		
		// map setting
		for (int h = 0; h < H; h++) {
			String ipt = br.readLine();
			char[] line = ipt.toCharArray();
			for (int w = 0; w < W; w++) {
				map[h][w] = line[w];
				if(line[w] == 'J') {
					que_player.add(new int[] {h,w});
				}
				if(line[w] == 'F') {
					que_fire.add(new int[] {h,w});
				}
			}
		} // end -roof
	
		
		while(!que_player.isEmpty()) {
			fire();
			answer = movePlayer(); 
			if (answer != -1) {
				System.out.println(answer);
				break;
			}
		}
		
		if(answer == -1) {
			System.out.println("INPOSSIBLE");
		}
	}
	
	
	private static int movePlayer() {
		cnt++;
		int que_size = que_player.size();
		for (int i = 0; i < que_size; i++) {
			int[] curr = que_player.poll();
			nh = curr[0];
			nw = curr[1];
			if(nh==0 || nh == H-1 || nw == 0 || nw == W-1) { // 탈출 성공
				que_player.clear();
				return cnt;
			}
			map[nh][nw] = 'J';
			for(int d=0; d<4; d++) {
				nexth = nh + dh[d];
				nextw = nw + dw[d];
				if(!check(nexth, nextw)) continue;
				if(map[nexth][nextw] != '.') continue;
				char nextTile = map[nexth][nextw];
				que_player.add(new int[] {nexth, nextw});
				}  
			} // end -roof
		return -1;
	}
	
	private static void fire() {
		int que_size = que_fire.size();
		for(int i=0; i<que_size; i++) {
			int[] curr = que_fire.poll();
			nh = curr[0];
			nw = curr[1];
			
			for(int d=0; d<4; d++) {
				nexth = nh + dh[d];
				nextw = nw + dw[d];
				if(!check(nexth, nextw)) continue;
				char nextTile = map[nexth][nextw];
				if(nextTile == '.' || nextTile == 'J') {
					que_fire.add(new int[] {nexth, nextw});
					map[nexth][nextw] = 'F';
				}
			} // end -roof
		}
		
		
	}
	
	private static boolean check(int h, int w) {
		if(h<0 || h>=H || w<0 || w>=W) {
			return false;
		}
		return true;
	}
}

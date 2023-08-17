import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static long H=1, W, N;
	public static long start_h = 1; 
	public static long start_w = 1; 
	public static long target_h; 
	public static long target_w; 
	public static Queue<Character> queStr = new LinkedList<>();
	public static String start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) H = H*2;
		W = H;
		start = st.nextToken();
		char[] arrChar = start.toCharArray();
		for (char c : arrChar) queStr.add(c);
		st = new StringTokenizer(br.readLine());
		long go_w = Long.parseLong(st.nextToken());
		long go_h = -Long.parseLong(st.nextToken());
		dc_start(0,0,H-1, W-1);
		target_h = start_h+go_h;
		target_w = start_w+go_w;
		if(!check(target_h,target_w)) System.out.println(-1);
		else dc_target(0,0,H-1, W-1,"");
	}
	
	private static boolean check(long h, long w) {
		if(h<0 || h>=H || w<0 || w>=W) return false;
		return true;
	}

	public static void dc_start(long p1h, long p1w, long p2h, long p2w) {
		if(p1h == p2h && p1w == p2w) {
			start_h = p1h;
			start_w = p1w;
			return;
		}
		if(queStr.isEmpty()) return;
		char now = queStr.poll();
		if(now == '1') {
			dc_start(p1h, p1w+(p2w-p1w)/2+1, p1h+(p2h-p1h)/2, p2w); // 1사분
		} else if (now == '2'){
			dc_start(p1h, p1w, p1h+(p2h-p1h)/2 , p1w+(p2w-p1w)/2); // 2사분
		} else if (now == '3') {
			dc_start(p1h+(p2h-p1h)/2+1, p1w, p2h, p1w+(p2w-p1w)/2); // 3사분
		} else if (now == '4') {
			dc_start(p1h+(p2h-p1h)/2+1, p1w+(p2w-p1w)/2+1, p2h, p2w); // 4사분
		}  
	}
	
	private static void dc_target(long p1h, long p1w, long p2h, long p2w, String now) {
		if(p1h==target_h && p1w==target_w && p2h==target_h && p2w==target_w ) {
			System.out.println(now);
			return;
		}
		if(p1h > target_h || p2h < target_h || p1w > target_w || p2w < target_w ) return;
		dc_target(p1h, p1w+(p2w-p1w)/2+1, p1h+(p2h-p1h)/2, p2w,now+"1"); // 1사분
		dc_target(p1h, p1w, p1h+(p2h-p1h)/2 , p1w+(p2w-p1w)/2,now+"2"); // 2사분
		dc_target(p1h+(p2h-p1h)/2+1, p1w, p2h, p1w+(p2w-p1w)/2,now+"3"); // 3사분
		dc_target(p1h+(p2h-p1h)/2+1, p1w+(p2w-p1w)/2+1, p2h, p2w,now+"4"); // 4사분
	}
	
}

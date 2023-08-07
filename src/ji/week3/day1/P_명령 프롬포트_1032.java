import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String first_line = br.readLine();
		N = first_line.length();
		count = new int[N];
		
		for (int i = 0; i < N; i++) {
			count[i] = 0;
		}
		
		for (int t = 0; t < T-1; t++) {
			String next_line = br.readLine();
			for (int i=0; i<N; i++) {
				if(first_line.charAt(i) == next_line.charAt(i)) {
					count[i]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if(count[i] == T-1) {
				sb.append(first_line.charAt(i));
			} else {
				sb.append("?");
			}
		}
		System.out.println(sb);
		
	}
}

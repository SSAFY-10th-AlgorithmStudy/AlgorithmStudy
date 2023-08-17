import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, n_set; 
	public static int min=1000001;
	public static ArrayList<Integer> lions = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		n_set=Integer.parseInt(st.nextToken());	
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int item = Integer.parseInt(st.nextToken());	
			if(item == 1) lions.add(i);
		}
		
		if (lions.size() < n_set) {
			System.out.println(-1);
		} else {
			int diff = 0;
			for (int i = 0; i < lions.size()-(n_set-1); i++) {
				diff = lions.get(i + n_set-1) -  lions.get(i) + 1;
				if(min > diff) min = diff;
				if(min == n_set) {
					break;
				}
			}
			System.out.println(min);	
		}
	}
}

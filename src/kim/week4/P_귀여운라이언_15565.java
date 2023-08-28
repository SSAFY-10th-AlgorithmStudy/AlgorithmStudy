package kim.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P_귀여운라이언_15565 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String in = br.readLine();

		List<Integer> list = new ArrayList<Integer>(k << 1);
		for (int i = 0; i < n; ++i) {
			if (in.charAt(2 * i) == '1') {
				list.add(i);
			}
		}

		int v = n, length;
		if (list.size() < k) v = -2;
		else {
			for (int i = k - 1; i < list.size() && v != k - 1; ++i) {
				length = list.get(i) - list.get(i - (k - 1));
				v = length < v ? length : v;
			}
		}
		System.out.print(v + 1);
	}
}
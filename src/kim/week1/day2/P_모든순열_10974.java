package kim.week1.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P_모든순열_10974 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		short n = Short.parseShort(br.readLine()), i, tmp;
		byte c = 0;
		for (i = tmp = 5; i <= n; tmp = i += 5) {
			while (tmp % 5 == 0) {
				c += 1;
				tmp /= 5;
			}
		}
		System.out.println(c);
	}
}
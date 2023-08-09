package kim.week2.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P_종이접기_1802 {
	static String input;
	static int mid;
	static boolean posi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		short n = Short.parseShort(br.readLine());

		StringBuilder sb = new StringBuilder();
		while ((n-- ^ 0) != 0) {
			posi = false;
			input = br.readLine();
			mid = input.length() / 2;
			solve(mid, mid);
			sb.append(posi ? "YES" : "NO").append('\n');
		}
		System.out.print(sb);
	}

	static boolean solve(int mid, int length) {
		if (length == 0) {
			posi = true;
			return true;
		}
		if (length == 1) {
			posi = check(mid - 1) ^ check(mid + 1);
			return check(mid);
		}
		posi &= check((mid - 1 + mid - length) / 2) ^ check((mid + 1 + mid + length) / 2);
		posi &= solve((mid - 1 + mid - length) / 2, length / 2) ^ solve((mid + 1 + mid + length) / 2, length / 2);
		return check(mid);
	}

	static boolean check(int i) {
		return input.charAt(i) == '0';
	}
}
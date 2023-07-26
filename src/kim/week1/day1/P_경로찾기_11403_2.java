package kim.week1.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P_경로찾기_11403_2 {
	static byte n;
	static boolean map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Byte.parseByte(br.readLine());
		map = new boolean[n][n];
		byte i, j;
		String input;
		for (i = 0; i < n; ++i) {
			input = br.readLine();
			for (j = 0; j < n; ++j) {
				if (input.charAt(j * 2) == '1')
					map[i][j] = true;
			}
		}
		for (i = 0; i < n; ++i) {
			check(i);
		}

		StringBuilder sb = new StringBuilder();
		for (boolean[] row : map) {
			for (i = 0; i < n; ++i) {
				sb.append(row[i] ? '1' : '0').append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	static void check(byte from) {
		for (byte i = 0; i < n; ++i) {
			check(from, i);
			check(i, from);
		}
	}

	static void check(byte from, byte to) {
		for (byte i = 0; i < n; ++i) {
			if (map[from][to] && map[to][i]) {
				map[from][i] = true;
			}
		}
	}
}
package kim.week1.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P_경로찾기_11403_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte n = Byte.parseByte(br.readLine()), i, j;
		String input;
		List<HashSet<Byte>> map = new ArrayList<HashSet<Byte>>(n);
		for (i = 0; i < n; ++i) {
			map.add(0, new HashSet<Byte>(n));
		}

		for (i = 0; i < n; ++i) {
			input = br.readLine();
			for (j = 0; j < n; ++j) {
				if (input.charAt(j * 2) == '1') {
					map.get(i).add(j);
				}
			}
		}

		for (i = 0; i < n; ++i) {
			for (j = 0; j < n; ++j) {
				if (map.get(i).contains(j)) {
					map.get(i).addAll(map.get(j));
				}
				if (map.get(j).contains(i)) {
					map.get(j).addAll(map.get(i));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (HashSet<Byte> set : map) {
			for (i = 0; i < n; ++i) {
				sb.append(set.contains(i) ? '1' : '0').append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
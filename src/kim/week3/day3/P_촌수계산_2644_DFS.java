package kim.week3.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P_촌수계산_2644_DFS {
	static List<Byte> family[];
	static byte target, cnt = -1;
	static boolean checked[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		byte i, j;
		byte n = Byte.parseByte(br.readLine());
		family = new List[n + 1];
		for (i = 0; i <= n; ++i) {
			family[i] = new ArrayList<Byte>(3);
		}
		checked = new boolean[n + 1];
		st = new StringTokenizer(br.readLine());
		byte start = Byte.parseByte(st.nextToken());
		target = Byte.parseByte(st.nextToken());
		byte line = Byte.parseByte(br.readLine());
		while (--line >= 0) {
			st = new StringTokenizer(br.readLine());
			i = Byte.parseByte(st.nextToken());
			j = Byte.parseByte(st.nextToken());
			family[i].add(j);
			family[j].add(i);
		}

		search(start, (byte) 0);

		System.out.println(cnt);
	}

	static void search(byte one, byte step) {
		if (cnt != -1) return;
		if (one == target) {
			cnt = step;
			return;
		}
		checked[one] = true;
		for (byte next : family[one]) {
			if (!checked[next]) {
				search(next, (byte) (step + 1));
			}
		}
	}
}
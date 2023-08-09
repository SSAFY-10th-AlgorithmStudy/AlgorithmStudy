package kim.week3.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class P_촌수계산_2644_BFS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		byte i, j;
		byte n = Byte.parseByte(br.readLine());
		List<Byte> family[] = new List[n + 1];
		for (i = 0; i <= n; ++i) {
			family[i] = new ArrayList<Byte>(3);
		}

		st = new StringTokenizer(br.readLine());
		byte t1 = Byte.parseByte(st.nextToken());
		byte t2 = Byte.parseByte(st.nextToken());
		byte line = Byte.parseByte(br.readLine());
		while (--line >= 0) {
			st = new StringTokenizer(br.readLine());
			i = Byte.parseByte(st.nextToken());
			j = Byte.parseByte(st.nextToken());
			family[i].add(j);
			family[j].add(i);
		}

		i = 0;
		boolean checked[] = new boolean[n + 1];
		Deque<Byte> que = new ArrayDeque<Byte>(line >> 1);
		que.add(t1);
		que.add((byte) -1);
		while (que.size() > 1) {
			j = que.poll();
//			System.out.println(j);
			if (j == -1) {
				i += 1;
				que.add(j);
				continue;
			}
			if (j == t2) {
				System.out.println(i);
				return;
			}
			checked[j] = true;
			for (byte one : family[j]) {
				if (!checked[one]) que.add(one);
			}
		}
		System.out.println(-1);
	}
}
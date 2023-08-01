package kim.week2.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P_뱀_3190 {
	static byte n;
	static boolean map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Byte.parseByte(br.readLine());
		byte i = Byte.parseByte(br.readLine()), dir[][] = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } }, r, c;
		map = new boolean[n][n];

		String line;
		while (--i >= 0) {
			line = br.readLine();
			r = Byte.parseByte(line.substring(0, line.indexOf(" ")));
			c = Byte.parseByte(line.substring(1 + line.indexOf(" ")));
			map[r - 1][c - 1] = true;
		}

		i = Byte.parseByte(br.readLine());
		Turn turns[] = new Turn[i];
		Turn turn;
		for (r = 0; r < i; ++r) {
			line = br.readLine();
			turn = new Turn(Short.parseShort(line.substring(0, line.indexOf(" "))),
					line.charAt(line.length() - 1) == 'D');
			turns[r] = turn;
		}

		Place place = new Place((byte) -1, (byte) -1);
		List<Place> list = new ArrayList<Place>();
		byte compass = 0;
		short sec = 1;
		list.add(new Place((byte) 0, (byte) 0));
		for (r = dir[0][compass], c = dir[1][compass], i = 0; !isOver(r, c); r += dir[0][compass], c += dir[1][compass], ++sec) {
			place = new Place(r, c);
			if (list.contains(place)) {
				break;
			}

			list.add(place);
			if (map[r][c]) {
				map[r][c] = false;
			} else {
				list.remove(0);
			}

			if (i < turns.length && turns[i].time == sec) {
				if (turns[i].di) {
					compass = (byte) ((compass + 1) % 4);
				} else {
					compass = (byte) ((compass + 3) % 4);
				}
				i += 1;
			}
//			print(list);
		}
		System.out.println(sec);
	}

	static boolean isOver(byte r, byte c) {
		if (r < 0 || r >= n || c < 0 || c >= n) {
			return true;
		}
		return false;
	}

//	static void print(List<Place> list) {
//		StringBuilder sb = new StringBuilder();
//		for (byte i = 0; i < n; ++i) {
//			for (byte j = 0; j < n; ++j) {
//				if (list.contains(new Place(i, j))) {
//					sb.append('*');
//				} else if (map[i][j]) {
//					sb.append('O');
//				} else {
//					sb.append('.');
//				}
//			}
//			sb.append('\n');
//		}
//		System.out.println(sb);
//	}
}

class Turn {
	short time;
	boolean di;

	Turn(short t, boolean di) {
		this.time = t;
		this.di = di;
	}
}

class Place {
	public byte r, c;

	public Place(byte r, byte c) {
		this.r = r;
		this.c = c;
	}

	public boolean equals(Object obj) {
		Place o = (Place) obj;
		return r == o.r && c == o.c;
	}
}
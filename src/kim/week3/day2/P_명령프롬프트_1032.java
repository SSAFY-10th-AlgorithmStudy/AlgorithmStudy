package kim.week3.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P_명령프롬프트_1032 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte n = Byte.parseByte(br.readLine());
		n -= 1;
		StringBuilder one = new StringBuilder(br.readLine());
		byte l = (byte) one.length();
		StringBuilder another;
		byte i;
		while (--n >= 0) {
			another = new StringBuilder(br.readLine());
			for (i = 0; i < l; ++i) {
				if (one.charAt(i) != '?' && one.charAt(i) != another.charAt(i)) {
					one.replace(i, i + 1, "?");
				}
			}
		}
		System.out.println(one);
	}
}

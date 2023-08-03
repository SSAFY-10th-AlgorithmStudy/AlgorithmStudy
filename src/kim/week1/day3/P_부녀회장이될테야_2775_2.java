package kim.week1.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P_부녀회장이될테야_2775_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		byte i, j, floor, num;
		short t = Short.parseShort(br.readLine());
		long arr[];
		while (--t >= 0) {
			i = Byte.parseByte(br.readLine());
			j = Byte.parseByte(br.readLine());
			arr = new long[j + 1];
			for (num = 1; num <= j; ++num) {
				arr[num] = num;
			}
			for (floor = 1; floor <= i; ++floor) {
				for (num = 1; num <= j; ++num) {
					arr[num] += arr[num - 1];
				}
			}
			sb.append(arr[j]).append('\n');
		}
		System.out.print(sb);
	}
}
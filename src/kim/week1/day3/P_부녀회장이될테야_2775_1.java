package kim.week1.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P_부녀회장이될테야_2775_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		byte i, j;
		short t = Short.parseShort(br.readLine());
		int arr[][] = new int[15][15];
		for (i = 0; i < 15; ++i) {
			arr[0][i] = i;
		}
		for (i = 1; i < 15; ++i) {
			for (j = 1; j < 15; ++j) {
				arr[i][j] = (arr[i][j - 1] + arr[i - 1][j]);
			}
		}
		while (--t >= 0) {
			i = Byte.parseByte(br.readLine());
			j = Byte.parseByte(br.readLine());
			sb.append(arr[i][j]).append('\n');
		}
		System.out.print(sb);
	}
}
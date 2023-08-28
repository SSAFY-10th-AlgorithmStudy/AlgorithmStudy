package koo.week4.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 첫시도 런타임(numberFormatException) x,y가 2의 50승 확인 (1,125,899,906,842,624) 
 * 1: 롱타입으로 변경 경우의 수 따졌을때 2의 50승을 해결하기엔 역부족 
 * 그래도 한번 재귀를 탈때 50번을 타는 거니까, 50 * 4 정도?
 * 괜찮지 않을까? 배열의 인덱스는 2^31 - 1
 *
 * 영역 나누기가 어렵다.
 * 
 * num이 50자리의 수를 가지면 numberformat 에러 발생 -> String 형 변경 처리
 * long 으로 받아도 에러남
 * 
 * 메모리 : 14260kb
 * 시간 : 132ms
 * 
 * @author SSAFY
 *
 */
public class P_사분면_1891 {
	static long[][] map;
	static long targetX;
	static long targetY;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String numToString = st.nextToken();
		long size = (long)Math.pow(2, n);
		
		long half = size;
		
		long tx = 0;
		long ty = 0;
		// n이 50일 경우 터짐
		for (int i = 0; i < numToString.length(); i++) {

			char ch = numToString.charAt(i);
			half = half / 2;
			if (ch == '1') {
				tx = tx;
				ty = ty + half;
			} else if (ch == '2') {
				tx = tx;
				ty = ty;
			} else if (ch == '3') {
				tx = tx + half;
				ty = ty;
			} else if (ch == '4') {
				tx = tx + half;
				ty = ty + half;
			}
		}

		st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());

		targetX = tx - y;
		targetY = ty + x;
		if(!(targetX >= 0 && targetX < size && targetY >= 0 && targetY < size)) {
			System.out.println(-1);
			return;
		}

		recur(0, 0, size, "");
		System.out.println(sb);
	}

	public static void recur(long x, long y, long size, String str) {
		if (size == 1) {
			sb.append(str);
			return;
		}

		long half = size / 2;

		long mx = x + half;
		long my = y + half;

		if (mx > targetX && my > targetY) {
			recur(x, y, half, str + "2");
		} else if (mx <= targetX && my > targetY) {
			recur(x + half, y, half, str + "3");
		} else if (mx > targetX && my <= targetY) {
			recur(x, y + half, half, str + "1");
		} else if (mx <= targetX && my <= targetY) {
			recur(x + half, y + half, half, str + "4");
		}

		
	}
}
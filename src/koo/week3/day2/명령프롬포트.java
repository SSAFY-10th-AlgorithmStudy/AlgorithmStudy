package koo.week3.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 명령프롬포트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				if (map.containsKey(j)) {
					if (!map.get(j).equals(s.charAt(j))) {
						map.put(j, '?');
					}
				} else {
					map.put(j, s.charAt(j));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Integer t : map.keySet()) {
			sb.append(map.get(t));
		}
		System.out.println(sb.toString());
	}
}
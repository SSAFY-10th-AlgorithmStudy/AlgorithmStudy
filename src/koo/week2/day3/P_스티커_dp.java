package koo.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import koo.utils.PrintUtils;

public class P_스티커_dp {
	static Integer[][] dp;	
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		dp = new Integer[2][100000];
		arr = new int[2][100000];
		
		for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = null;
				}
			}
			
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];

			
			System.out.println(Math.max(DP(1, n - 1), DP(0, n - 1)));
		}
	}

	public static int DP(int x, int y) {

		if (dp[x][y] != null || y<=1) {
			return dp[x][y];
		}
		
		int temp = (x+1)%2;
			
		dp[x][y] = Math.max(DP(temp,y-1), DP(temp,y-2))+ arr[x][y];

		return dp[x][y];
	}
}

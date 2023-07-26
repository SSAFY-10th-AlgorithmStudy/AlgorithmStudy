package com.ssafy.edu;
import java.util.Scanner;
public class P_2775_부녀회장이될테야 {
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		for (int x = 0; x < T; x++) {
			int k = scann.nextInt();
			int n = scann.nextInt();
			int[][] dp = new int[15][15];
			for (int i = 0; i < 15; i++) dp[0][i] = i+1;
			for (int i = 0; i < 15; i++) dp[i][0] = 1;
			for (int i = 1; i < 15; i++) for (int j = 1; j < n; j++) dp[i][j] = dp[i-1][j] + dp[i][j-1];
			System.out.println(dp[k][n-1]);
			}
			
		}
	}



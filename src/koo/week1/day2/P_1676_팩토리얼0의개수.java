package koo.week1.day2;

import java.util.Scanner;

public class P_1676_팩토리얼0의개수 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		
		while(n >= 5) {
			cnt += n/5;
			n = n / 5;
		}
		System.out.println(cnt);
			
	}
	
}

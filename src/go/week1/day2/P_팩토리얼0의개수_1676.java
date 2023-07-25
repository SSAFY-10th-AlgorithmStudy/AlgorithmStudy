package java0723;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P_팩토리얼0의개수_1676 {
	 static int factorial(int n) {
		 if (n<=1) return 1;
		 return factorial(n-1)*n;
	}
	public static void main(String[] args) throws IOException{
	
			System.setIn(new FileInputStream("src/java0723/res/input.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
	        int n = Integer.parseInt(st.nextToken());
//			String a =String.valueOf(factorial(n));
//			int idx = a.length();
			int res = n/5+n/25+n/125;
//			for(int i = idx-1; i>=0; i--) {
//				if (a.charAt(i)!='0') break;
//				else res++;
//			}
//			System.out.println(res);
			System.out.println(res);
			
	}
}
	

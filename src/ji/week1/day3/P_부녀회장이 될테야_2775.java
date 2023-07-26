import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int a;
	public static int b;
	public static int[] room;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			a = sc.nextInt();
			b = sc.nextInt();
			room = new int[b];
			for (int i = 0; i < b; i++) {
				room[i] = i+1;
			}
			
			recur(1);
			System.out.println(room[b-1]);
			
		}
		return;
	}
	
	public static void recur(int floor) {

		for (int i = b-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				room[i] += room[j];
			}
		}

		if (floor == a) {
			return;
		} 
		floor++;
		recur(floor);
		return;
	}

}

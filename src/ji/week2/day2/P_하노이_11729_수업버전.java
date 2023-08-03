import java.util.Scanner;

public class Main_hanoi {

    static int N;
    static StringBuilder sb;
    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        N=scann.nextInt();
        sb=new StringBuilder();

        hanoi(N, 1, 3, 2);
        System.out.println((1<<N)-1);
        System.out.println(sb.toString());
    }
    static void hanoi(int n) {
        hanoi(n, 1, 3, 2);
    }
    static void hanoi(int n, int a, int b, int c) {
        if(n==1) {
            sb.append(a+" "+b+"\n");
            return;
        }
        hanoi(n-1, a,c ,b);
        sb.append(a+" "+b+"\n");
        hanoi(n-1, c,b ,a);
    }
}

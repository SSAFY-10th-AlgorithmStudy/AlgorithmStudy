import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = factorial(N);

        System.out.println(answer);

    }

    public static int factorial(int N) {
        int zero_count = 0;
        int sum=1;

        for (int i = N; i > 1; i--) {
            sum = sum * i;
            // 오버플로우를 방지하는 것이 문제의 핵심
            // 뒤에 0이 있는 숫자는 무엇을 곱해도 0이 유지가 되므로
            // 0을 따로 카운트하고 자리수를 줄인다.
            while(sum > 0) {
                int temp = sum % 10;
                if (temp == 0) {
                    zero_count++;
                    sum = sum / 10;
                } else {
                    break;
                }
            }
            if (sum==0) { // 0 곱해지는 현상 방지 (ex : 100!)
                sum = 1;
            } else if(sum > 1000000) { // 단순 숫자로만 자리수를 채운다면 4자리만큼만 잘라낸다.
                sum = sum % 10000;
            }
        }
        return zero_count;
    }
}

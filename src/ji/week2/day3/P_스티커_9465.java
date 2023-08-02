import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int N;

    public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N+1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];
            for (int i=2; i<=N; i++) {
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + map[0][i];
                dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + map[1][i];
            }

            int answer = Math.max( dp[0][N], dp[1][N]);
            System.out.println(answer);

        }
    }

}

package koo.week2.day3;

import java.io.*;

public class f{
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        dp = new int[2][100001];
        arr = new int[2][100001];
        for(int i=0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            
            // 우선 원 배열 저장 수행
            for(int j=0; j < 2; j++){
                String line[] = br.readLine().split(" ");
                for(int k=1; k <= n; k++){
                    arr[j][k] = Integer.parseInt(line[k-1]);
                    dp[j][k] = -1;
                }
            }
            
//        	dp[0][0] = arr[0][0];
//			dp[1][0] = arr[1][0];
//			dp[0][1] = dp[1][0] + arr[0][1];
//			dp[1][1] = dp[0][0] + arr[1][1];
//			
			
			
            dp[0][1] = arr[0][1]; 
            dp[1][1] = arr[1][1];
            dp[0][2] = dp[1][1] + arr[0][2]; 
            dp[1][2] = dp[0][1] + arr[1][2];
            
            int result = Math.max(topDown(0, n), topDown(1, n));
            bw.write(String.valueOf(result) + "\n");
        }
        
        bw.flush();
        br.close();
    }
    
    // Top-down 방식, 행을 y, 열을 x로 표현하자
    public static int topDown(int x, int y){
        if(y <= 2 || dp[x][y] >= 0) return dp[x][y]; // 기존의 값이 있는 경우
        
        int temp = (x+1)%2;
        dp[x][y] = Math.max(topDown(temp, y-1), topDown(temp, y-2)) + arr[x][y];
        
        return dp[x][y];
    }
}
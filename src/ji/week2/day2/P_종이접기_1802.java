package com.solve.paper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 잘못생각한 이유 => 멀쩡한 종이에서 접는 과정을 구현 시도
// 해당부분이 규칙에 만족하는지만 확인하면 됨 
// 패턴1. 중간은 결과에 영향 X
// 패턴2. 중간 기준으로 대칭 위치는 다른값
public class Main {
    public static int[] paper;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split("");
            N = line.length;
            paper = new int[N];
            for (int i = 0; i < N; i++) {
                paper[i] = Integer.parseInt(line[i]);
            }

            boolean answer = check(0,N-1);
            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean check(int start, int end) {
        if(start==end) {
            return true;
        }
        int mid = (start + end) / 2;
        for(int i=start; i<mid; i++) {
            if(paper[i] + paper[end-i] != 1) {
                return false;
            }
        }
        return check(start, mid - 1) && check(mid + 1, end);
    }

}

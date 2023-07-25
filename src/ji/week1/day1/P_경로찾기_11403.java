package com.solve.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] map;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        // 수업시간에 배웠던 내용
        // readLine()으로 받아올 String 객체를 기본형 타입인 int와 형변환이 안되므로
        // Wrapper Class 사용 (Integer) ==> int 타입 변수를 객체로 포장함
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int h=0; h<N; h++) {
            String line[] = br.readLine().split(" ");
            for (int w=0; w< N; w++) {
                map[h][w] = Integer.parseInt(line[w]);
            }
        }
        // <거쳐간다> 키워드 => 플로이드 => 공식 Dab = min(Dab, Dak+Dkb)
        for (int k=0; k<N; k++) {
            for (int a=0; a<N; a++) {
                for (int b=0; b<N; b++) {
                    if (map[a][k] == 1 && map[k][b] == 1) {
                        map[a][b] = 1;
                    }
                }
            }
        }
        print();
    }
    // 너무 공식에 얽메여서 오히려 돌아갔던 문제, 일반적인 플로이드는 0자리 대신 INF로 설정하면
    // Dak+Dkb (a -> k -> b) 경로가 없을 때 값이 너무커져서 걸러지는데,
    // 여긴 간선이 없을 땐 0이라서 공식을 사용하면 모든 자리에 값이 들어가버려 원인을 찾는 데 시간이 걸렸다.
    // 3중 반복문 변수 순서도 주의할 것 (k a b)

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int h=0; h<N; h++) {
            for (int w=0; w<N; w++) {
                sb.append(map[h][w] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

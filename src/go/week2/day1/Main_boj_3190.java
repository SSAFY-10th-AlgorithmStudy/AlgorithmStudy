package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_3190 {
    static int N, K, L;
    static int[][] Matrix;
    static boolean[][] app;
    static String[][] vec;
    static StringTokenizer st;
    final static int[] dr = {0, 1, 0, -1};
    final static int[] dc = {1, 0, -1, 0};
    static int curDir;
    static Queue<int[]> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        Matrix = new int[N][N];
        app = new boolean[N][N];
        curDir = 0;
        int r, c;
        //사과 받기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            app[r][c] = true;
        }
        //방향 받기
        L = Integer.parseInt(br.readLine());
        vec = new String[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            vec[i][0] = st.nextToken();
            vec[i][1] = st.nextToken();
        }

        int time = game(true);
        System.out.println(time);
    }

    static int game(boolean start) {
        int r = 0;
        int c = 0;
        int time = 0;
        int snake_len = 1;
        Matrix[r][c] = 1;
        snake.add(new int[]{r, c});

        while (start) {
            time++;
            r += dr[curDir];
            c += dc[curDir];

            if (r < 0 || c < 0 || r >= N || c >= N || Matrix[r][c] == 1) {
                break;
            }

            if (app[r][c]) {
                snake_len++;
                app[r][c] = false;
            } else {
                int[] tail = snake.poll();
                Matrix[tail[0]][tail[1]] = 0;
            }
            Matrix[r][c] = 1;
            snake.add(new int[]{r, c});

            for (int i = 0; i < L; i++) {
                if (time == Integer.parseInt(vec[i][0])) {
                    spin(vec[i][1]);
                }
            }
        }

        return time;
    }

    static void spin(String dir) {
        if (dir.equals("D")) {
            curDir = (curDir + 1) % 4;
        } else {
            curDir = (curDir + 3) % 4;
        }
    }
}

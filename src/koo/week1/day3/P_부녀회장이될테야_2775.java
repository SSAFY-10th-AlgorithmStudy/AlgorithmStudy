package week6.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P_부녀회장이될테야_2775{
    static int size = 15;
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T>0) {
            map = new int[size][size];
            init();
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            play(k,n-1);
            T--;
        }
    }
    public static void play(int k,int n) {
        for (int i = 1; i <= map.length; i++) {
            for (int j = 1; j <= map.length; j++) {
                if(i>= 1 && i < 15 && j >= 1 && j < 15) {
                    map[i][j] = map[i-1][j] + map[i][j-1];
                }
                if(map[k][n] != 0) {
                    System.out.println(map[k][n]);
                    return;
                }
            }
        }
    }
    public static void init() {
        for (int i = 0; i < map.length; i++) {
            map[0][i] = i+1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
        }
    }
}
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 뱀의 이동경로를 추적해서 길이를 조절하는 것이 포인트
// Queue로 뱀의 이동 좌표를 보관한다.
// 사과를 만나면 add
// 빈공간이면 poll을 하면 꼬리부분이 없어짐 (선입선출)
public class Main {
    public static int[][] map;
    public static int time =0;
    public final static int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
    public static int now_direct = 0;
    public static int now_h = 0;
    public static int now_w = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, String> hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        // snake queue
        Queue<Point> queue = new LinkedList<>();

        int N_apple = Integer.parseInt(br.readLine());
        for (int i = 0; i < N_apple; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp_h = Integer.parseInt(st.nextToken());
            int temp_w = Integer.parseInt(st.nextToken());
            map[temp_h-1][temp_w-1] = 2;
        }

        int N_angle = Integer.parseInt(br.readLine());;
        for (int i = 0; i < N_angle; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            String value = st.nextToken();
            hm.put(key, value);
        }

        map[0][0] = 1;
        queue.add(new Point(0,0));

        while (true) {
            time++;
            int next_h = now_h + direct[now_direct][0];
            int next_w = now_w + direct[now_direct][1];
            if(next_h >= N || next_h < 0 || next_w >= N || next_w < 0) {
                break;
            }
            
            if (map[next_h][next_w] == 2) { // 사과 좌표로 이동
                now_h = next_h;
                now_w = next_w;
                queue.add(new Point(next_h,next_w));
                map[next_h][next_w] = 1;
            } else if (map[next_h][next_w] == 1) { // 본인 꼬리 밟음
                break;
            } else { // 빈 공간으로 이동
                map[next_h][next_w] = 1;
                now_h = next_h;
                now_w = next_w;
                Point p = queue.poll();
                map[p.x][p.y] = 0;
                queue.add(new Point(next_h,next_w));
            }

            if (hm.containsKey(time)) {
                String move_to = hm.get(time);
                if (move_to.equals("D")) {
                    now_direct++;
                } else {
                    now_direct--;
                }
                if (now_direct >= 4) {
                    now_direct = now_direct % 4;
                }
                if (now_direct < 0) {
                    now_direct += 4;
                }
            }
        }

        System.out.println(time);

    }

//    public static void print(int n) {
//        StringBuilder sb = new StringBuilder();
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                sb.append(map[i][j] + " ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

}

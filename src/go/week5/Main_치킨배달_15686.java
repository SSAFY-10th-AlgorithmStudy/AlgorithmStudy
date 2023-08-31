import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_치킨배달_15686 {
/* 코드의 전체 적인 해석
 * 1. BFS를 사용하지 않아도 되는걸 어렵게 풀었음..
 * 2. 여러 개 중에 중복을 허용해도 되는 경우라 combination을 사용했다.
 * 3. inner클래스를 사용했는데, 굳이 사용 안해도 된다. 하지만 코드의 가독성이 편해진다.
 * 4. 먼저 이전에 풀었던 치즈 문제와 비슷하게 combination을 사용하고 copy.clone을 사용함으로써 초기화작업을 해줬다.
 * 5. combi에서 치킨집의 위치를 불러온다.
 * 6. 치킨집 기준으로 bfs를 사용해서 집의 위치를 더하고 더해준다.
 * 7. 마지막으로 최소값인 것이 정답이다.
 */
    static class Location {
        int r, c, dis;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
            this.dis = 0;
        }
    }

    static int N, M;
    static int[] P;
    static int chickens;
    static int R;
    static int[] nums;
    static int[][] map, copy;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] visited;
    static int res;
    static List<Location> chi, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chi = new ArrayList<>();
        h = new ArrayList<>();
        map = new int[N][N];
        copy = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    map[i][j] = a;
                    copy[i][j] = a;
                    h.add(new Location(i, j));
                } else if (a == 2) {
                    chi.add(new Location(i, j));
                    chickens++;
                }
            }
        }

        R = M;
        P = new int[chickens];
        for (int i = 0; i < chickens; i++) {
            P[i] = i;
        }
        res = Integer.MAX_VALUE;
        nums = new int[R];
        combi(0, 0);
        System.out.println(res);
    }

    static void combi(int cnt, int start) {
        if (R == cnt) {
            int tot = 0;
            cInit();

            for (int i = 0; i < R; i++) {
                int tempR = chi.get(nums[i]).r;
                int tempC = chi.get(nums[i]).c;
                map[tempR][tempC] = 2;
            }
            hInit();
            for (int x = 0; x < R; x++) {
                int tempR = chi.get(nums[x]).r;
                int tempC = chi.get(nums[x]).c;
                visited = new int[N][N];
                bfs(tempR, tempC);
            }
            tot = hAdd(tot);
            res = Math.min(res, tot);
            return;
        }

        for (int i = start; i < P.length; i++) {
            nums[cnt] = P[i];
            combi(cnt + 1, i + 1);
            nums[cnt] = 0;
        }
    }

    private static void cInit() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(copy[i], 0, map[i], 0, N);
        }
    }

    private static int hAdd(int tot) {
        for (Location loc : h) {
            tot += loc.dis;
        }
        return tot;
    }

    private static void hInit() {
        for (Location loc : h) {
            loc.dis = 0;
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{r, c});
        visited[r][c] = 1;
        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int xr = temp[0];
            int xc = temp[1];
            if (map[xr][xc] == 1) {
                for (Location loc : h) {
                    int vis = visited[xr][xc];
                    if (loc.r == xr && loc.c == xc) {
                        if (loc.dis == 0) {
                            loc.dis = vis - 1;
                        } else {
                            loc.dis = Math.min(loc.dis, vis - 1);
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nr = xr + dr[i];
                int nc = xc + dc[i];

                if (!check(nr, nc)) continue;
                if (visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[xr][xc] + 1;
                    que.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N && map[r][c] != 2;
    }
}

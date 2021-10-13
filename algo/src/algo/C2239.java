package algo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class C2239{
    static int[][] map;
    static ArrayList<Node> blank;
    public static boolean isFinished;

    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];
        blank=new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= 9; j++) {
                map[i][j] = temp.charAt(j - 1) - '0';
                if (map[i][j] == 0) {
                    blank.add(new Node(i, j));
                }

            }
        }
        dfs(0);

    }


    public static void dfs(int idx) {
        if (idx == blank.size()) {
            isFinished = true;
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if (isFinished) return;
        Node cur = blank.get(idx);
        for (int j = 1; j <= 9; j++) {
            if (map[cur.x][cur.y] == 0 && check(cur.x, cur.y, j)) {
                map[cur.x][cur.y] = j;
                dfs(idx + 1);
                map[cur.x][cur.y] = 0;
            }

        }
    }


    public static boolean check(int x, int y, int val) {
        for (int i = 1; i <= 9; i++) {
            if (y != i && map[x][i] == val)
                return false;
            if (x != i && map[i][y] == val)
                return false;
        }
        int xRange, yRange;
        if (x % 3 == 0)
            xRange = x - 2;
        else
            xRange = x - x % 3 + 1;
        if (y % 3 == 0)
            yRange = y - 2;
        else
            yRange = y - y % 3 + 1;

        for (int i = xRange; i < xRange + 3; i++) {
            for (int j = yRange; j < yRange + 3; j++) {
                if (x != i && y != j && map[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
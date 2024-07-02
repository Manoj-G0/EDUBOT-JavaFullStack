import java.util.*;

public class MazeSolver {
    private static final int N = 5;

    private static boolean isValid(int x, int y, int[][] maze, boolean[][] visited) {
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 0 && !visited[x][y];
    }

    private static boolean solveMaze(int[][] maze, int[] start, int[] end, boolean[][] visited) {
        int x = start[0];
        int y = start[1];

        if (x == end[0] && y == end[1]) {
            return true;
        }

        if (isValid(x, y, maze, visited)) {
            visited[x][y] = true;

            if (solveMaze(maze, new int[]{x + 1, y}, end, visited) ||
                solveMaze(maze, new int[]{x - 1, y}, end, visited) ||
                solveMaze(maze, new int[]{x, y + 1}, end, visited) ||
                solveMaze(maze, new int[]{x, y - 1}, end, visited)) {
                return true;
            }

            visited[x][y] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };

        boolean[][] visited = new boolean[N][N];
        int[] start = {0, 0};
        int[] end = {4, 4};

        if (solveMaze(maze, start, end, visited)) {
            for (boolean[] row : visited) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("No path found");
        }
    }
}

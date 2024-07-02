import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class MazeSolver {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
    public static boolean solveMazeDFS(int[][] maze, int startX, int startY, int endX, int endY) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                return true; 
            }

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (isValidMove(maze, visited, nx, ny)) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }

        return false; 
    }

    public static boolean solveMazeBFS(int[][] maze, int startX, int startY, int endX, int endY) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                return true; 
            }

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (isValidMove(maze, visited, nx, ny)) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return false; 
    }

    private static boolean isValidMove(int[][] maze, boolean[][] visited, int x, int y) {
        int rows = maze.length;
        int cols = maze[0].length;
        return x >= 0 && x < rows && y >= 0 && y < cols && maze[x][y] == 0 && !visited[x][y];
    }

    public static void printPath(int[][] maze, int startX, int startY, int endX, int endY) {
        boolean pathFoundDFS = solveMazeDFS(maze, startX, startY, endX, endY);
        boolean pathFoundBFS = solveMazeBFS(maze, startX, startY, endX, endY);

        if (pathFoundDFS) {
            System.out.println("Path found using DFS:");
            printMaze(maze, startX, startY, endX, endY);
        } else {
            System.out.println("No path found using DFS.");
        }

        if (pathFoundBFS) {
            System.out.println("Path found using BFS:");
            printMaze(maze, startX, startY, endX, endY);
        } else {
            System.out.println("No path found using BFS.");
        }
    }
    private static void printMaze(int[][] maze, int startX, int startY, int endX, int endY) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == startX && j == startY) {
                    System.out.print("S ");
                } else if (i == endX && j == endY) {
                    System.out.print("E ");
                } else if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else if (visited[i][j]) {
                    System.out.print(". ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0}
        };

        System.out.println("Maze:");
        printMaze(maze, 0, 0, 4, 4);

        System.out.println("Solving maze using DFS and BFS:");
        printPath(maze, 0, 0, 4, 4);
    }
}

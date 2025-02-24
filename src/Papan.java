public class Papan {
    private char[][] grid;
    public int N, M;

    public Papan(int N, int M) {
        this.N = N;
        this.M = M;
        this.grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = '.';
            }
        }
    }

    public int getRows() {
        return N;
    }

    public int getCols() {
        return M;
    }

    public boolean isFull() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] findNextEmptyCell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public boolean canPlace(int[][] shape, int row, int col) {
        int shapeN = shape.length;
        int shapeM = shape[0].length;
    
        if (row + shapeN > N || col + shapeM > M) {
            return false;
        }
    
        for (int i = 0; i < shapeN; i++) {
            for (int j = 0; j < shapeM; j++) {
                if (shape[i][j] == 1) {  
                    int newRow = row + i;
                    int newCol = col + j;
    
                    if (newRow >= N || newCol >= M || grid[newRow][newCol] != '.') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public void placeBlock(int[][] shape, int row, int col, char id) {
        if (!canPlace(shape, row, col)) {
            System.out.println("Blok tidak bisa ditempatkan di posisi (" + row + ", " + col + ")");
            return;
        }
    
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] == 1) {  
                    grid[row + i][col + j] = id;
                }
            }
        }
    }
    
    public void removeBlock(int[][] shape, int row, int col) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] == 1) {  
                    grid[row + i][col + j] = '.';
                }
            }
        }
    }    

    public char[][] getGrid() {
        return grid;
    }

    private String getColor(char c) {
        switch (c) {
            case 'A': return "\u001B[31m"; 
            case 'B': return "\u001B[32m"; 
            case 'C': return "\u001B[33m"; 
            case 'D': return "\u001B[34m"; 
            case 'E': return "\u001B[35m"; 
            case 'F': return "\u001B[36m"; 
            case 'G': return "\u001B[37m"; 
            default: return "\u001B[0m"; 
        }
    }

    public void printBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == '.') {
                    System.out.print("  "); 
                } else {
                    System.out.print(getColor(cell) + cell + "\u001B[0m" + " ");
                }
            }
            System.out.println();
        }
    }
}

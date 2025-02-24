import java.util.*;

public class Blok {
    public char id; 
    public List<int[][]> transformasi = new ArrayList<>();

    public Blok(char id, List<String> shapeLines) {
        this.id = id;
        boolean[][] baseShape = parseShape(shapeLines);
        generateTransformasi(baseShape);
    }

    private boolean[][] parseShape(List<String> shapeLines) {
        int rows = shapeLines.size();
        int cols = shapeLines.get(0).length();
        boolean[][] shape = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = shapeLines.get(i);
            for (int j = 0; j < cols; j++) {
                shape[i][j] = (line.charAt(j) != ' ');
            }
        }
        return shape;
    }

    private void generateTransformasi(boolean[][] baseShape) {
        Set<String> seenShapes = new HashSet<>();
        Queue<boolean[][]> queue = new LinkedList<>();
        queue.add(baseShape);

        while (!queue.isEmpty()) {
            boolean[][] shape = queue.poll();
            if (seenShapes.add(Arrays.deepToString(shape))) {
                transformasi.add(convertToIntArray(shape)); 
                queue.add(rotateRight(shape));
                queue.add(mirror(shape));
            }
        }
    }

    private boolean[][] rotateRight(boolean[][] shape) {
        int rows = shape.length, cols = shape[0].length;
        boolean[][] rotated = new boolean[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                rotated[j][rows - 1 - i] = shape[i][j];
        return rotated;
    }

    private boolean[][] mirror(boolean[][] shape) {
        int rows = shape.length, cols = shape[0].length;
        boolean[][] mirrored = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mirrored[i][cols - 1 - j] = shape[i][j];
        return mirrored;
    }

    private int[][] convertToIntArray(boolean[][] shape) {
        int rows = shape.length, cols = shape[0].length;
        int[][] intArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                intArray[i][j] = shape[i][j] ? 1 : 0;  
            }
        }
        return intArray;
    }
}

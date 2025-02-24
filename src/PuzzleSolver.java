import java.util.List;

public class PuzzleSolver {
    private int iterasi = 0;
    private long startTime;

    public boolean solve(Papan papan, List<Blok> blokList, int index) {
        if (index == 0) {
            startTime = System.currentTimeMillis(); 
        }
        
        if (index == blokList.size()) {
            if (papan.isFull()) {
                papan.printBoard();
                long waktuPencarian = System.currentTimeMillis() - startTime;
                System.out.println("Waktu pencarian: " + waktuPencarian + " ms");
                System.out.println("Banyak kasus yang ditinjau: " + iterasi);
                return true;
            } else {
                return false;
            }
        }
        
        int[] pos = papan.findNextEmptyCell();
        if (pos == null) {
            return false;
        }
        int i = pos[0];
        int j = pos[1];
        
        Blok blok = blokList.get(index);
        for (int[][] bentuk : blok.transformasi) {
            if (papan.canPlace(bentuk, i, j)) {
                papan.placeBlock(bentuk, i, j, blok.id);
                iterasi++;

                if (solve(papan, blokList, index + 1)) {
                    return true;
                }
                papan.removeBlock(bentuk, i, j);
            }
        }
        return false;
    }
    public long getExecutionTime() {
        return System.currentTimeMillis() - startTime;
    }
    public int getIterationCount() {
        return iterasi;
    }
}

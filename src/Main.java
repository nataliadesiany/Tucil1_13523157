import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { 
            System.out.print("Masukkan nama file test case: ");
            String filename = scanner.nextLine();

            List<String> data = TxtHandler.readFile(filename);
            if (data.isEmpty()) {
                System.out.println("Error membaca file!");
                return;
            }

            String[] meta = data.get(0).split(" ");
            int N = Integer.parseInt(meta[0]);
            int M = Integer.parseInt(meta[1]);

            Papan papan = new Papan(N, M);
            List<Blok> blokList = new ArrayList<>();

            for (int i = 2; i < data.size(); i++) {
                blokList.add(new Blok(data.get(i).charAt(0), Collections.singletonList(data.get(i))));
            }

            PuzzleSolver solver = new PuzzleSolver();
            boolean solved = solver.solve(papan, blokList, 0);
            long waktuEksekusi = solver.getExecutionTime();
            int jumlahIterasi = solver.getIterationCount();

            if (!solved) {
                System.out.println("Tidak ada solusi.");
            } else {
                System.out.print("Apakah anda ingin menyimpan solusi? (ya/tidak): ");
                String pilihan = scanner.nextLine().trim().toLowerCase();
                if (pilihan.equals("ya")) {
                    saveSolution(papan, filename, waktuEksekusi, jumlahIterasi);
                }
            }
        }
    }

    private static void saveSolution(Papan papan, String filename, long executionTime, int iterationCount) {
        try {
            File folder = new File("test");
            if (!folder.exists() && !folder.mkdir()) {
                System.out.println("Gagal membuat folder 'test/'");
                return;
            }

            File file = new File("test/solusi_" + new File(filename).getName());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (char[] row : papan.getGrid()) {
                    writer.write(new String(row) + "\n");
                }

                writer.write("\nWaktu pencarian: " + executionTime + " ms\n");
                writer.write("Banyak kasus yang ditinjau: " + iterationCount + "\n");
            }

            System.out.println("Solusi berhasil disimpan di: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Gagal menyimpan solusi: " + e.getMessage());
        }
    }
}
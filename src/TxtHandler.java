import java.io.*;
import java.util.*;

public class TxtHandler {
    public static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan.");
        }
        return lines;
    }
}
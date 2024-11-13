
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {

    public static void brutForce(String text, String path) {
        try {
            if (!Files.exists(Path.of(path))) {
                Files.createDirectory(Path.of(path));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < DataFile.ALPHABET.length; i++) {
            String s = DataFile.fileToString(text, Integer.toString(i));
            FileManager.writeFile(path + "/" + (i + 1) + ".txt", s);
        }
    }

}
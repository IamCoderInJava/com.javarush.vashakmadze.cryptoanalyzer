
public class Encryption {

    public static String encrypt(String text, int key) {
        StringBuilder sb = new StringBuilder();

        if (key > DataFile.ALPHABET.length) {
            key %= DataFile.ALPHABET.length;
        }
        if (key < 0) {
            key %= -DataFile.ALPHABET.length;
            key += DataFile.ALPHABET.length;
        }

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < DataFile.ALPHABET.length; j++) {
                if (text.charAt(i) == DataFile.ALPHABET[j]) {
                    if (j + key < DataFile.ALPHABET.length) {
                        sb.append(DataFile.ALPHABET[j + key]);
                    } else {
                        sb.append(DataFile.ALPHABET[(j + key) % DataFile.ALPHABET.length]);
                    }
                }
            }
        }
        return sb.toString();
    }

}


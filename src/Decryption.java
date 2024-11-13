
public class Decryption {

    public static String decrypt(String text, int key) {
        return Encryption.encrypt(text, -key);
    }

}
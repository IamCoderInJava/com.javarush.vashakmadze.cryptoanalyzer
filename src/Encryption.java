public class Encryption {

    static String encryption(String encryptTextBefore, int encryptKey){
        char[] encryptCharBefore = encryptTextBefore.toCharArray();
        char[] encryptCharAfter = new char[encryptCharBefore.length];
        boolean isPresence = false;
        for (int i = 0; i < encryptCharBefore.length; i++) {
            for (int k = 0; k < CharacterData.ALPHABET_FULL_SIZE; k++) {
                if (encryptCharBefore[i] == CharacterData.ALPHABET_FULL[k]) {
                    isPresence = true;
                }
                if (isPresence){
                    encryptCharAfter[i] = CharacterData.ALPHABET_FULL[(k + encryptKey)% CharacterData.ALPHABET_FULL_SIZE];
                    isPresence = false;
                }
            }
        }
        return new String(encryptCharAfter);
    }
}

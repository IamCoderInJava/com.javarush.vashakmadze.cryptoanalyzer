
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Validator validator = new Validator();

        boolean executing = true;
        while (executing) {
            String title = "Введите цифру из списка ниже, чтобы выбрать операцию, которую необходимо выполнить:";
            System.out.println("=".repeat(title.length()));
            System.out.println(title);
            System.out.println("=".repeat(title.length()));
            System.out.println("\t1. Шифрование");
            System.out.println("-".repeat(50));
            System.out.println("\t2. Расшифровка с ключом");
            System.out.println("-".repeat(50));
            System.out.println("\t3. Brute Force");
            System.out.println("-".repeat(50));
            System.out.println("\t0. Выход");
            System.out.println("=".repeat(50));

            int choice = console.nextInt();
            console.nextLine();

            switch (choice) {
                case 1:
                    encryptFile(console, validator);
                    break;
                case 2:
                    decryptFile(console, validator);
                    break;
                case 3:
                    bruteForceDecrypt(console, validator);
                    break;
                case 0:
                    System.out.println("Работа программы завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный код. Пожалуйста, введите цифру из списка выше.");
            }
        }
    }

    private static void encryptFile(Scanner console, Validator validator) {
        System.out.println("Введите путь файла для шифрования текста:");
        String file = console.nextLine();
        System.out.println("Введите ключ для шифрования ввиде цифры:");
        String key = console.nextLine();
        System.out.println("Введите путь для создания файла и записи зашифрованного текста:");
        String cryptedFile = console.nextLine();

        if (validator.isFileExists(file) && validator.isFileNotEmpty(file) && validator.isValidKey(key)) {
            List<String> list = FileManager.readFile(file);
            StringBuilder sb = new StringBuilder();
            for (String line : list) {
                String cryptText = Encryption.encrypt(line, Integer.parseInt(key));
                sb.append(cryptText).append("\n");
            }
            FileManager.writeFile(cryptedFile, sb.toString());
            System.out.println("Файл зашифрован и записан по указанному пути.");
        }
    }

    private static void decryptFile(Scanner console, Validator validator) {
        System.out.println("Введите путь к файлу для расшифровки текста:");
        String text = console.nextLine();
        System.out.println("Введите ключ для расшифрования ввиде цифры:");
        String key = console.nextLine();
        System.out.println("Введите путь для создания файла и записи расшифрованного текста:");
        String deCryptedFile = console.nextLine();

        if (validator.isFileExists(text) && validator.isFileNotEmpty(text) && validator.isValidKey(key)) {
            List<String> list = FileManager.readFile(text);
            StringBuilder sb = new StringBuilder();
            for (String line : list) {
                String decryptText = Decryption.decrypt(line, Integer.parseInt(key));
                sb.append(decryptText).append("\n");
            }
            FileManager.writeFile(deCryptedFile, sb.toString());
            System.out.println("Файл расшифрован и записан по указанному пути.");
        }
    }

    private static void bruteForceDecrypt(Scanner console, Validator validator) {
        System.out.println("Введите путь к файлу для расшифровки текста:");
        String path = console.nextLine();
        System.out.println("Введите путь к ДИРЕКТОРИИ (повторяю к директории) для сохранения расшифрованных файлов");
        String newPath = console.nextLine();

        if (validator.isFileExists(path) && validator.isFileNotEmpty(path)) {
            BruteForce.brutForce(path, newPath);
            System.out.println("Расшифрованные файлы сохранены");
        }
    }
}
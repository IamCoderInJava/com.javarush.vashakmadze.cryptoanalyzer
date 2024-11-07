import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println();
        Scanner console = new Scanner(System.in);
        String title = "Введите цифру из списка ниже, чтобы выбрать операцию, которую необходимо выполнить:";
        System.out.println("=".repeat(title.length()));
        System.out.println("Введите цифру из списка ниже, чтобы выбрать операцию, которую необходимо выполнить:");
        System.out.println("=".repeat(title.length()));
        System.out.println("\t1. Шифрование");
        System.out.println("-".repeat(50));
        System.out.println("\t2. Расшифровка с ключом");
        System.out.println("-".repeat(50));
        System.out.println("\t0. Выход");
        System.out.println("=".repeat(50));


        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            switch (console.nextInt()) {
                case 1: {
                    console.nextLine();
                    System.out.println("Введите путь файла для шифрования текста:");
                    byte[] buffer = Files.readAllBytes(Path.of(reader.readLine()));
                    String encryptTextBefore = new String(buffer, StandardCharsets.UTF_8);

                    System.out.println("Введите ключ для шифрования ввиде цифры:");
                    int encryptKey = Integer.parseInt(reader.readLine());

                    System.out.println("Введите путь для создания файла и записи зашифрованного текста:");
                    Path encryptFile = Files.createFile(Path.of(reader.readLine()));
                    Files.writeString(encryptFile, Encryption.encryption(encryptTextBefore, encryptKey));

                    System.out.println("Файл зашифрован и записан по указанному пути");
                    break;


                }


                case 2: {
                    console.nextLine();

                    System.out.println("Введите путь файла для расшифрования текста:");

                    byte[] buffer = Files.readAllBytes(Path.of(reader.readLine()));
                    String decryptTextBefore = new String(buffer, StandardCharsets.UTF_8);

                    System.out.println("Введите ключ для расшифрования ввиде цифры:");
                    int decryptKey = Integer.parseInt(reader.readLine());


                    System.out.println("Введите путь для создания файла и записи расшифрованного текста:");
                    Path decryptFile = Files.createFile(Path.of(reader.readLine()));
                    Files.writeString(decryptFile, Decryption.decryption(decryptTextBefore, decryptKey));

                    System.out.println("Файл расшифрован и записан по указанному пути");
                    break;
                }

                case 0:
                    System.out.println("Работа программы завершена");
                    System.exit(0);
                    break;
            }

        } catch (IOException e) {
            System.out.println("Такого файла не существует: " + e.getMessage());
        }

    }
}
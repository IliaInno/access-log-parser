import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        while (true) {
            String path = new Scanner(System.in).nextLine();

            File file = new File(path);
            boolean fileExists = file.exists();

            boolean isDirectory = file.isDirectory();


            if (!fileExists || isDirectory) {
                System.out.println("Указанный файл не существует или путь является путём к папке");
                continue;
            }

            if (fileExists) {
                System.out.println("Путь указан верно");
                System.out.println("Это файл номер " + count);
                count++;

                if (!fileExists || isDirectory) {
                    System.out.println("Указанный файл не существует или путь является путём к папке");
                }

                try {
                    int minLength = Integer.MAX_VALUE;
                    int maxLength = 0;
                    int totalLinesCount = 0;

                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;

                    while ((line = reader.readLine()) != null) {
                        int currentLength = line.length();
                        if (currentLength > 1024) {
                            throw new RuntimeException("Длина строки более 1024 символов");
                        }
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                        }
                        if (currentLength < minLength) {
                            minLength = currentLength;
                        }
                        totalLinesCount++;
                    }
                    System.out.println("Общее количество строк в файле: " + totalLinesCount);
                    System.out.println("Длина самой длинной строки в файле: " + maxLength);
                    System.out.println("Длина самой короткой строки в файле: " + minLength);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
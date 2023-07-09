import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        int totalLinesCount = 0;
        int yandexBotCount = 0;
        int googleBotCount = 0;


        while (true) {
            System.out.println("Укажите путь к файлу:");
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
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;

                    while ((line = reader.readLine()) != null) {
                        int currentLength = line.length();
                        if (currentLength > 1024) {
                            throw new RuntimeException("Длина строки более 1024 символов");
                        }
                        totalLinesCount++;

                        String[] lineFragments = (line.split("\""));
                        String userAgentInfo = lineFragments[lineFragments.length - 1];
                        String firstBrackets = userAgentInfo.replaceAll(".*\\(|\\).*", "");
                        String[] parts = firstBrackets.split(";");
                        if (parts.length >= 2) {
                            String fragment = parts[1];
                            String botName = fragment.trim().split("/")[0];

                            if (botName.equalsIgnoreCase("YandexBot")) {
                                yandexBotCount++;
                            } else if (botName.equalsIgnoreCase("GoogleBot")) {
                                googleBotCount++;
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Общее количество строк в файле: " + totalLinesCount);
                System.out.println("------------");
                System.out.println("Общее количество строк с YandexBot: " + yandexBotCount);
                System.out.println("Доля запросов от YandexBot относительно общего числа сделанных запросов: " +
                        String.format("%.2f", (double) yandexBotCount / totalLinesCount * 100) + "%");
                System.out.println("------------");
                System.out.println("Общее количество строк c GoogleBot: " + googleBotCount);
                System.out.println("Доля запросов от GoogleBot относительно общего числа сделанных запросов: " +
                        String.format("%.2f", (double) googleBotCount / totalLinesCount * 100) + "%");
            }
        }
    }
}
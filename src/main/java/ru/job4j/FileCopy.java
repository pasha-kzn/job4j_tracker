package ru.job4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    private static final int BUFFER_SIZE = 1024;
    private static final int PAUSE_SIZE = 1024 * 1024 * 5; // 5 MB
    private static final int PAUSE_TIME_MS = 5000; // 50 second
    private static final int PAUSE_TIME_AFTER_COPY = 1000; // 1 second

    public static void main(String[] args) {
        // Укажите исходную и целевую папки
        var start = System.currentTimeMillis();
        String sourceDirectory = "F:\\Фотовидеоархив\\Фото\\с фотика без разбора\\182CANON\\нескопир";
        String targetDirectory = "C:\\FotoVideoArchive\\Фото\\с фотика без разбора\\182CANON\\нескопир";
        copyDirectory(sourceDirectory, targetDirectory);
        var finish = System.currentTimeMillis();
        long minutes = (finish - start) / 1000 / 60;
        System.out.println("Files copied to " + targetDirectory + " in " + minutes + " minutes.");
    }

    public static void copyDirectory(String sourceDir, String targetDir) {
        File sourceFolder = new File(sourceDir);
        File targetFolder = new File(targetDir);
        // Создаем целевую папку, если она не существует
        if (!targetFolder.exists()) {
            targetFolder.mkdirs();
        }

        // Получаем список файлов и папок в исходной папке
        File[] files = sourceFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Копируем файлы
                    copyFile(file, new File(targetFolder, file.getName()));
                    try {
                        Thread.sleep(PAUSE_TIME_AFTER_COPY);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else if (file.isDirectory()) {
                    // Рекурсивно копируем подкаталоги
                    copyDirectory(file.getPath(), new File(targetFolder, file.getName()).getPath());
                }
            }
        }
    }

    public static void copyFile(File sourceFile, File targetFile) {
        if (targetFile.exists()) {
            System.out.println("File already exists, skipping: " + targetFile.getName());
            return;
        }

        try (FileInputStream inStream = new FileInputStream(sourceFile);
             FileOutputStream outStream = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            long totalBytesRead = 0;

            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
                totalBytesRead += length;

                // Проверяем, прочитали ли мы 1 МБ данных
                if (totalBytesRead >= PAUSE_SIZE) {
                    System.out.println("Длительное копирование файла: " + targetFile.getName());
                    Thread.sleep(PAUSE_TIME_MS);
                    totalBytesRead = 0; // Сбросить счетчик байтов после паузы
                }
            }
            System.out.println("File copied: " + sourceFile.getName());

        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to copy file: " + sourceFile.getName());
            e.printStackTrace();
        }
    }
}

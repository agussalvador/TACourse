package com.solvd.talab.lecture7;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;
import static org.apache.commons.io.FileUtils.*;


public class CalculateWords {
    private final static String PATH_FILE = "D:\\Documentos\\Solvd Course\\javacourse\\src\\main\\resources\\text.txt";

    public static void main(String[] args) {
        File file = new File(PATH_FILE);
        writeFile("<!--Count of unique words is: " + countUniqueWords(file) + "-->", file);

    }

    private static void removeCount(File file) {
        List<String> fileContent = null;
        try {
            fileContent = readLines(file, (String) null);
            for (int e = 0; e < fileContent.size(); e++) {
                if (fileContent.get(e).startsWith("<!--")) {
                    fileContent.remove(e);
                }
            }
            //Override de file without the last count
            writeLines(file, fileContent);
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }

    public static int countUniqueWords(File file) {
        //Hash set to store unique words
        HashSet<String> uniqueWords = new HashSet<>();
        //Call local method to remove if exist the last count of words
        removeCount(file);
        try {
            String fileContent = readFileToString(file, (String) null);

            //Split content
            String temp[] = fileContent.split("\\s+|\n+|\t+");

            for (String s : temp) {
                uniqueWords.add(s);
            }
            
            return uniqueWords.size();
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }

        return 0;
    }

    public static void writeFile(String msg, File file) {

        try {
            writeStringToFile(file, msg, true);
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}

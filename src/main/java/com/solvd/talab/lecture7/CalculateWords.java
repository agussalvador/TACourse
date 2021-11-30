package com.solvd.talab.lecture7;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;
import static org.apache.commons.io.FileUtils.*;


public class CalculateWords {
    private final static String PATH_TEXT_FILE = "src/main/resources/text.txt";
    private final static String PATH_RESULT_FILE = "src/main/resources/countResult.txt";
    private final static String PATH_STRING_FILE = "src/main/resources/strings.txt";

    public static void main(String[] args) throws IOException {
        File text = new File(PATH_TEXT_FILE);
        File result = new File(PATH_RESULT_FILE);
        writeFile("<!--Count of unique words is: " + countUniqueWords(text) + "-->", result);

        //File util methods

        File task2 = new File(PATH_STRING_FILE);
        String strings = readFileToString(task2, (String) null);
        LOGGER.log(Level.INFO, "File last modified: " + task2.lastModified());
        LOGGER.log(Level.INFO, "File absolute path: " + task2.getAbsolutePath());
        writeStringToFile(task2, "New file content", (String) null, false);

        LOGGER.log(Level.INFO, "===================");
        //String utils methods.

        LOGGER.log(Level.INFO, "To lower case: " + strings.toLowerCase());
        LOGGER.log(Level.INFO, "To upper case: " + strings.toUpperCase());
        LOGGER.log(Level.INFO, (strings.isEmpty()) ? "Is empty" : "Not empty");
        LOGGER.log(Level.INFO, "Text content: ".concat(strings));
        String asf = strings.substring(3);
        LOGGER.log(Level.INFO, "Substring: " + strings.substring(3));

    }

    //This method was created because I wrote result of the count in the same txt file. But now I Write it in another file
//    private static void removeCount(File file) {
//        List<String> fileContent = null;
//        try {
//            fileContent = readLines(file, (String) null);
//            for (int e = 0; e < fileContent.size(); e++) {
//                if (fileContent.get(e).startsWith("<!--")) {
//                    fileContent.remove(e);
//                }
//            }
//            //Override de file without the last count
//            writeLines(file, fileContent);
//        } catch (IOException e) {
//            LOGGER.log(Level.INFO, e.getMessage());
//        }
//    }

    public static int countUniqueWords(File file) {
        //Hash set to store unique words
        HashSet<String> uniqueWords = new HashSet<>();
        try {
            String fileContent = readFileToString(file, (String) null);

            //Split content. Maybe I could improve this regex usage.
            String[] temp = fileContent.split("\\s+|\n+|\t+");

            uniqueWords.addAll(Arrays.asList(temp));

            return uniqueWords.size();
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }

        return 0;
    }

    public static void writeFile(String msg, File file) {

        try {
            writeStringToFile(file, msg, (String) null, true);
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}

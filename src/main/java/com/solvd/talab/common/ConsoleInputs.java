package com.solvd.talab.common;

import java.io.*;
import java.util.logging.Level;

import static com.solvd.talab.common.LoggerClass.LOGGER;

public class ConsoleInputs {
    private final static String filePath = "src/com/solvd/lab1/lecture4/files/text.txt";

    public static void main(String[] args) {

        writeFileOutputStream();
        //printFile(filePath);
    }


    //String input from console
    public static String stringInput() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please insert a string value: ");
        String input = reader.readLine();
        return input;
    }

    //Method to write file
    public static void writeFileOutputStream() {
        // Using try-with-resources
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            String msg = stringInput();
            byte byteArray[] = msg.getBytes(); //converting string into byte array
            fileOutputStream.write(byteArray);
            LOGGER.log(Level.INFO, "Message written to file successfuly!");
        } catch (Exception exception) {
            LOGGER.log(Level.INFO, exception.getMessage());
        }
    }

    public static void printFile(String fileName) {
        File file = new File(fileName);
        int n = -1;
        byte[] b = new byte[100];
        try {
            FileInputStream f = new FileInputStream(file);
            while ((n = f.read(b, 0, 50)) != -1) {
                String str = new String(b, 0, n, "utf-8");
                LOGGER.log(Level.INFO, "This is the file content: " + str);
                System.out.println(str);
            }
            f.close();
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}

package weather;

import java.io.*;

public class Logger {

    private static BufferedWriter writer = null;

    public static void newFile(String filename) throws IOException {
        if (Logger.writer != null) {
            writer.close();
        }
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
    }

    public static void log(String message) {
        try {
            System.out.println(message);
            Logger.writer.write(message + '\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing to simulation.txt file");
            System.exit(1);
        }
    }
}
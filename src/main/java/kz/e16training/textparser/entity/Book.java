package kz.e16training.textparser.entity;

import kz.e16training.textparser.Run;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Model of Book.
 *
 */
public class Book {
    private static Logger log = LogManager.getLogger(Run.class.getName());
    private String filePath;
    private String textEncoding;

    public Book(String filePath, String textEncoding) {
        this.filePath = filePath;
        this.textEncoding = textEncoding;
    }
    /*
    Get text from book
     */
    public String getText() {
        StringBuilder result = new StringBuilder(1024);
        try  (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(filePath)), textEncoding))) {
            String textLine;
            while ((textLine = reader.readLine()) != null) {
                result.append(textLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return result.toString();
    }

}

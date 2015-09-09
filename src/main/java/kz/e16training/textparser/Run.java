package kz.e16training.textparser;

import kz.e16training.textparser.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author DK
 * @version 1.0.0
 *
 */
public class Run {
    private static Logger log = LogManager.getLogger(Run.class.getName());
    public static void main(String[] args) {
        log.info("App started");
        Text text = new Text(new Book("btl.txt", "UTF8"));
        System.out.println(text);
        text.sort();
        System.out.println(text);
        log.info("App stopped");
    }
}

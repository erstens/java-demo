import org.apache.log4j.Logger;

import java.util.Arrays;

public class Main {
    static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.debug("Hello this is a debug message{}");
        log.info("Hello this is an info message");
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
        java.util.Map<Thread, StackTraceElement[]> ts = Thread.getAllStackTraces();

        StackTraceElement[] ste = ts.get(Thread.currentThread());

        for (StackTraceElement s : ste) {

            System.out.println(s.toString());

        }
    }
}

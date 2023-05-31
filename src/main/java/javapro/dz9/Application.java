import java.io.IOException;
import java.text.DateFormat;


public class Application {
    public static void main(String[] args) {
        try {
            FileLoggerConfiguration config = FileLoggerConfigurationLoader.load("c:/temp/dz009/logger-config.properties");

            FileLogger logger = new FileLogger(config);
            // FileLogger logger = new FileLogger(config, fileWriter, dateFormat);

            logger.debug("This is a debug message.");
            logger.info("This is an info message.");
        } catch (IOException | FileMaxSizeReachedException e) {
            e.printStackTrace();
        }
    }
}

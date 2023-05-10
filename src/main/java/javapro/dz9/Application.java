import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            FileLoggerConfiguration config = FileLoggerConfigurationLoader.load("c:/temp/dz009/logger-config.properties");

            FileLogger logger = new FileLogger(config);

            logger.debug("This is a debug message.");
            logger.info("This is an info message.");
        } catch (IOException | FileMaxSizeReachedException e) {
            e.printStackTrace();
        }
    }
}

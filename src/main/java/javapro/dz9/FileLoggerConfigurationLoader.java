import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String configFilePath) throws IOException {
        Properties props = new Properties();
        FileInputStream input = new FileInputStream(configFilePath);
        props.load(input);

        String filePath = props.getProperty("FILE");
        LoggingLevel loggingLevel = LoggingLevel.valueOf(props.getProperty("LEVEL"));
        long maxFileSize = Long.parseLong(props.getProperty("MAX-SIZE"));
        String logFormat = props.getProperty("FORMAT");

        return new FileLoggerConfiguration(filePath, loggingLevel, maxFileSize, logFormat);
    }
}
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class FileLogger {
    private FileLoggerConfiguration config;
    private FileWriter fileWriter;
    private DateFormat dateFormat;

    public FileLogger(FileLoggerConfiguration config) throws IOException {
        this.config = config;
        this.fileWriter = new FileWriter(config.getFilePath(), true);
        this.dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm");
    }

    public void debug(String message) throws IOException, FileMaxSizeReachedException {
        if (config.getLoggingLevel() == LoggingLevel.DEBUG || config.getLoggingLevel() == LoggingLevel.INFO) {
            String logMessage = String.format("[%s][DEBUG] Повідомлення: %s", dateFormat.format(new Date()), message);
            writeLog(logMessage);
        }
    }

    public void info(String message) throws IOException, FileMaxSizeReachedException {
        if (config.getLoggingLevel() == LoggingLevel.INFO) {
            String logMessage = String.format("[%s][ INFO] Повідомлення: %s", dateFormat.format(new Date()), message);
            writeLog(logMessage);
        }
    }

    private void writeLog(String message) throws IOException, FileMaxSizeReachedException {
        long currentFileSize = new File(config.getFilePath()).length();
        if (currentFileSize >= config.getMaxFileSize()) {
            String fileName = String.format("Log_%s.txt", dateFormat.format(new Date()));
            this.fileWriter = new FileWriter(fileName, true);
        }
        if (new File(config.getFilePath()).length() >= config.getMaxFileSize()) {
            throw new FileMaxSizeReachedException(String.format("Maximum file size reached. Maximum size: %d bytes, Current size: %d bytes, Path: %s", config.getMaxFileSize(), currentFileSize, config.getFilePath()));
        }
        fileWriter.write(String.format("%s\n", message));
        fileWriter.flush();
    }
}
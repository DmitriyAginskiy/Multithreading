package by.aginskiy.multithreading.reader;

import by.aginskiy.multithreading.exception.FileReadingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CarReader {

    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_PATH = "src\\main\\resources\\data\\data.txt";

    public List<String> readFromFile(String path) throws FileReadingException {
        if(!Files.exists(Path.of(path))) {
            path = DEFAULT_PATH;
        }
        List<String> cars = null;
        try {
            cars = Files.readAllLines(Path.of(path));
        } catch(IOException e) {
            logger.error("Unable to read from file. Filepath: " + path);
            throw new FileReadingException("Unable to read from File");
        }
        return cars;
    }
}

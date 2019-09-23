package by.training.handling.reader;

import by.training.handling.exception.DataFileReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataFileReader {

    private static Logger logger = LogManager.getLogger();

    public static String getAllText(String fileName) throws DataFileReaderException, IOException {

        List<String> allLines = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).collect(Collectors.toList());
        return String.join("\n", allLines);
        //Paths.get(getClass().getResources(fileName).toURI());
        //return String.join("\n", DataFileReader.getLines(pathFile));
    }

    //  String filePath = "src\\main\\resources\\data\\data.txt";
    /*public static List<String> getLines(String filePath) throws DataFileReaderException {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new DataFileReaderException("Incorrect read file! " + e);
        }
    }*/


}

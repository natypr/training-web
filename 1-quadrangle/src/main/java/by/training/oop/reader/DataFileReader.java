package by.training.oop.reader;

import by.training.oop.exception.DataFileReaderException;
import by.training.oop.validation.FileValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataFileReader {

    private static Logger log = LogManager.getLogger();

    public List<String> readFile(String fileName) throws DataFileReaderException {

        List <String> stringList = new ArrayList<>();


        File file = new File(fileName);
        FileValidation fileValidation = new FileValidation();

        if (!fileValidation.validateFile(file)) {
            log.error("Incorrect file (exception) " + file);
            throw new DataFileReaderException("Incorrect file (ex): " + file);
        }


        Path path = Paths.get(fileName);

        try (Stream<String> lineStream = Files.lines(path)) {

            stringList = lineStream.collect(Collectors.toList());

        } catch (IOException e) {
            log.error("Incorrect read file! " + path);
            throw new DataFileReaderException(e);
        }
        return stringList;
    }
}

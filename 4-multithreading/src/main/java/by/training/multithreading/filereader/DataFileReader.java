package by.training.multithreading.filereader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataFileReader {

    private static final Logger LOG = LogManager.getLogger();

    public List<String> readFileOfData(String fileName) {
        List<String> lines = new ArrayList<>();
        String file = ClassLoader.getSystemResource(fileName).toString().substring(6);;

        try (Stream<String> lineStream = Files.lines(Paths.get(file))) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            LOG.error("Error reading file: " + e);
        }
        return lines;
    }
}

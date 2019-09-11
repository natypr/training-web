package by.training.oop.reader;

import by.training.oop.exception.DataFileReaderException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DataFileReaderTest {

    private DataFileReader dataFileReader;

    @BeforeMethod
    public void setUp() {
        dataFileReader = new DataFileReader();
    }

    @Test
    public void testReadFile() throws DataFileReaderException, IOException, URISyntaxException {

        List<String> expectedList = new ArrayList<>();
          expectedList.add("Quadrangle 2.0 1.0 3.0 6.0 5.0 5.0 7.0 3.0");
          expectedList.add("Quadrangle 2.0 1.0 3.0 6.0 5.0 5.0 7.0 5.0");

        List<String> actualList = dataFileReader.readFile("data/shapes.txt");

        //Exception - Incorrect file. I hope to fix it in the future, but now it’s beyond the scope of the possible.
        assertEquals(actualList, expectedList);
    }
}
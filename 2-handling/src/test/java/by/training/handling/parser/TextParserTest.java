package by.training.handling.parser;

import by.training.handling.composite.TextComposite;
import org.testng.annotations.Test;


public class TextParserTest {

    @Test
    public void testDataHandler() {
        String text = "    It has survived - not only (five) centuries, but also the leap into electronic\r\n" +
                "typesetting, remaining essentially unchanged. It was popularised in\r\n" +
                "the with the release of Letraset sheets\r\n" +
                "containing Lorem Ipsum passages, and more recently with desktop publishing software\r\n" +
                "like Aldus PageMaker including versions of Lorem Ipsum.\r\n" +
                "    It is a long established fact that a reader will be distracted by the readable\r\n" +
                "content of a page when looking at its layout. The point of using\r\n" +
                "Ipsum is that it has a more-or-less normal\r\n" +
                "distribution of letters, as opposed to using (Content here), content here', making it look\r\n" +
                "like readable English.\r\n" +
                "    It is a established fact that a reader will be of a\r\n" +
                "page when looking at its layout.\r\n" +
                "    Bye.";
        TextComposite textComposite = new TextComposite();
        TextParser textParser = new TextParser();
        textParser.dataHandler(text, textComposite);
        textComposite.sort();

    }
}
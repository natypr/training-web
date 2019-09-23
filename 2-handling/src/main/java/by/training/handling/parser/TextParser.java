package by.training.handling.parser;

import by.training.handling.composite.TextComponent;
import by.training.handling.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class TextParser implements HandlerAll {

    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_PARAGRAPH = "([ ]{4}|\\t)";

    private HandlerAll next;

    @Override
    public void setNext(HandlerAll handler) {
        next = handler;
    }

    @Override
    public void dataHandler(String text, TextComponent composite) {
        List<String> paragraphs = getValue(text);
        ParagraphParser paragraphParser = new ParagraphParser();
        for (String paragraph : paragraphs) {
            TextComposite paragraphComposite = new TextComposite();
            paragraphParser.dataHandler(paragraph, paragraphComposite);
            composite.addComponent(paragraphComposite);
        }
    }

    private List<String> getValue(String text){
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        String[] arrayParagraph = pattern.split(text.trim());
        return Arrays.asList(arrayParagraph);
    }
}

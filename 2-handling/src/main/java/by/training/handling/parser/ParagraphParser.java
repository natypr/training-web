package by.training.handling.parser;

import by.training.handling.composite.TextComponent;
import by.training.handling.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements HandlerAll {

    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_SENTENCE = "([^.!?]+[.!?])";

    private HandlerAll next;

    @Override
    public void setNext(HandlerAll handler) {
        next = handler;
    }

    @Override
    public void dataHandler(String paragraph, TextComponent composite) {
        List<String> sentences = getValue(paragraph);
        SentenceParser sentenceParser = new SentenceParser();
        for (String sentence: sentences) {
            TextComposite compositeSentences = new TextComposite();
            sentenceParser.dataHandler(sentence, compositeSentences);
            composite.addComponent(compositeSentences);
            logger.info("Added sentence.");
        }
    }

    private List<String> getValue(String text){
        Matcher matcher = Pattern.compile(REGEX_SENTENCE).matcher(text);
        List<String> tempList = new ArrayList<>();
        while (matcher.find()) {
            tempList.add(matcher.group(1));
        }
        return tempList;
    }
}

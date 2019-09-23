package by.training.handling.parser;

import by.training.handling.composite.TextComponent;
import by.training.handling.composite.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class SentenceParser implements HandlerAll {

    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_TOKEN = "[ \r\n]+";

    @Override
    public void setNext(HandlerAll handler) {

    }

    @Override
    public void dataHandler(String sentence, TextComponent composite) {
        List<String> tokens = getValue(sentence);
        TokenParser tokenParser = new TokenParser();
        for (String token: tokens){
            TextComposite tokenComposite = new TextComposite();
            tokenParser.dataHandler(token, tokenComposite);
            composite.addComponent(tokenComposite);
        }
    }

    private List<String> getValue(String text){
        String[] arrayTokens = text.split(REGEX_TOKEN);
        return Arrays.asList(arrayTokens);
    }
}

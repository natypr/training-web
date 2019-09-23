package by.training.handling.parser;

import by.training.handling.composite.TextComponent;
import by.training.handling.composite.TextLeaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class TokenParser implements HandlerAll {

    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_Token = "";

    private HandlerAll next;

    @Override
    public void setNext(HandlerAll handler) {
        next = handler;
    }

    @Override
    public void dataHandler(String token, TextComponent composite) {
        List<String> symbols = getValue(token);
        SymbolParser symbolParser = new SymbolParser();
        for (String symbol: symbols){
            TextLeaf leaf = new TextLeaf();
            symbolParser.dataHandler(symbol, leaf);
            composite.addComponent(leaf);
        }
    }

    private List<String> getValue(String text){
        String[] arrayTokens = text.split(REGEX_Token);
        return Arrays.asList(arrayTokens);
    }
}

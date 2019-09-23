package by.training.handling.parser;

import by.training.handling.composite.TextComponent;
import by.training.handling.composite.TextLeaf;
import by.training.handling.enm.LeafType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SymbolParser implements HandlerAll {

    private static Logger logger = LogManager.getLogger();
    private static final String PUNCTUATION = ".,";

    private HandlerAll next = null;

    @Override
    public void setNext(HandlerAll handler) {
        next = handler;
    }

    @Override
    public void dataHandler(String text, TextComponent composite) {
        if (text.length()==1) {
            TextLeaf leaf = (TextLeaf)composite;
            leaf.setValue(text);
            leaf.setLeafType(PUNCTUATION.contains(text) ? LeafType.PUNCTUATION_MARK : LeafType.LETTER);
        }
    }
}

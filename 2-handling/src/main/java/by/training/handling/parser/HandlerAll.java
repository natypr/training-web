package by.training.handling.parser;

import by.training.handling.composite.TextComponent;

public interface HandlerAll {

    void setNext(HandlerAll handler);
    void dataHandler(String text, TextComponent composite);

}

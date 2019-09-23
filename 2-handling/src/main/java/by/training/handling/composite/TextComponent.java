package by.training.handling.composite;


import java.util.Comparator;
import java.util.List;

public interface TextComponent {

    void addComponent(TextComponent part);
    void removeComponent(TextComponent part);
    void sort();
    void sort(Comparator<TextComponent> comparator);
    String collectToString();
    List<TextComponent> getList();

}

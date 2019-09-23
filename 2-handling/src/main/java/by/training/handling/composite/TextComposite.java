package by.training.handling.composite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextComposite implements TextComponent {

    private List<TextComponent> components = new ArrayList<>();

    @Override
    public void addComponent(TextComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(TextComponent component) {
        components.remove(component);
    }

    @Override
    public List<TextComponent> getList() {
        return components;
    }

    @Override
    public void sort() {
        Comparator<TextComponent> comparator = (a, b)->
        {
            if (a.getList().size() == b.getList().size()) {
                return 0;
            }
            else if (a.getList().size() < b.getList().size()) {
                return -1;
            }
            else {
                return 1;
            }
        };
        sort(comparator);
    }

    @Override
    public void sort(Comparator<TextComponent> comparator) {
        components.sort(comparator);
    }

    @Override
    public String collectToString() {
        StringBuilder result = new StringBuilder();
        for (TextComponent component : components) {
            result.append(component.collectToString());
        }
        return  result.append("   ").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        return components != null ? components.equals(that.components) : that.components == null;
    }

    @Override
    public int hashCode() {
        int result = 65;
        result = 31 *result + (components != null ? components.hashCode() : 0);
        return result;
    }
}

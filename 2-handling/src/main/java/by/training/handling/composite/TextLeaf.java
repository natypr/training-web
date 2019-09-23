package by.training.handling.composite;

import by.training.handling.enm.LeafType;

import java.util.Comparator;
import java.util.List;


public class TextLeaf implements TextComponent{

    private String value;
    private LeafType leafType;

    public TextLeaf() {
    }

    public LeafType getLeafType() {
        return leafType;
    }

    public void setLeafType(LeafType leafType) {
        this.leafType = leafType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void addComponent(TextComponent component) {

    }

    @Override
    public void removeComponent(TextComponent component) {

    }

    @Override
    public void sort() {

    }

    @Override
    public void sort(Comparator<TextComponent> comparator) {

    }

    @Override
    public String collectToString() {
        return  value;
    }

    @Override
    public List<TextComponent> getList() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextLeaf leaf = (TextLeaf) o;

        if (value != null ? !value.equals(leaf.value) : leaf.value != null) return false;
        return leafType == leaf.leafType;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (leafType != null ? leafType.hashCode() : 0);
        return result;
    }
}

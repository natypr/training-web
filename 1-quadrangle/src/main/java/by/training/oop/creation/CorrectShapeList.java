package by.training.oop.creation;


import java.util.ArrayList;
import java.util.List;

public class CorrectShapeList {

    private List<BaseShape> shapes = new ArrayList<>();

    public int getCount() {
        return shapes.size();
    }

    public void addShape(BaseShape shape) {
        shapes.add(shape);
    }

    public void info() {
        shapes.forEach(shape->System.out.println(shape.getId()));
    }


    private static CorrectShapeList instance = null;
    private CorrectShapeList(){ }

    public static CorrectShapeList getInstance(){
        if(instance == null){
            instance = new CorrectShapeList();
        }
        return instance;
    }
}

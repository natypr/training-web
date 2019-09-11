package by.training.oop.action;

import by.training.oop.entity.Point;
import by.training.oop.entity.Quadrangle;

import java.util.ArrayList;
import java.util.List;

public class Calculation {

    //d     = sqrt( (x2-x1)^2 + (y2-y1)^2 )
    //hypot = sqrt(       x^2 +       y^2 )
    public static double distanceBetweenTwoPoints(Point p1, Point p2){
        return Math.hypot(p2.getX()-p1.getX(), p2.getY()-p1.getY());
    }

    //k = (y2-y1) / (x2-x1)
    public static double lineCoefficient(Point p1, Point p2){
        if ((p1.getX() == p2.getX()) || (p2.getY() == p2.getY())){
            return 0.0;
        } else {
            return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        }
    }

    public static double angle(double k1, double k2){
        return Math.atan((k1-k2)/(1+k1*k2));
    }

    public static List<Double> listOfAngle(Quadrangle qdr){
        List<Double> angleList = new ArrayList<>();

        double k1 = lineCoefficient(qdr.getP1(), qdr.getP2());
        double k2 = lineCoefficient(qdr.getP2(), qdr.getP3());
        double k3 = lineCoefficient(qdr.getP3(), qdr.getP4());
        double k4 = lineCoefficient(qdr.getP4(), qdr.getP1());

        double angleBetweenK1K2 = angle(k1,k2);
        double angleBetweenK2K3 = angle(k2,k3);
        double angleBetweenK3K4 = angle(k3,k4);
        double angleBetweenK4K1 = angle(k4,k1);

        angleList.add(angleBetweenK1K2);
        angleList.add(angleBetweenK2K3);
        angleList.add(angleBetweenK3K4);
        angleList.add(angleBetweenK4K1);

        return angleList;
    }

    public static double perimeterShape(Quadrangle qdr){
        return distanceBetweenTwoPoints(qdr.getP1(), qdr.getP2()) +
                distanceBetweenTwoPoints(qdr.getP2(), qdr.getP3()) +
                distanceBetweenTwoPoints(qdr.getP3(), qdr.getP4()) +
                distanceBetweenTwoPoints(qdr.getP4(), qdr.getP1());
    }

    //S = ((p-a)(p-b)(p-c)(p-d)) ^ 1/2
    public static double areaShape(Quadrangle qdr){
        double halfPerimeter = perimeterShape(qdr) / 2.0;

        double lineFirst = distanceBetweenTwoPoints(qdr.getP1(),qdr.getP2());
        double lineSecond = distanceBetweenTwoPoints(qdr.getP2(),qdr.getP3());
        double lineThird = distanceBetweenTwoPoints(qdr.getP3(),qdr.getP4());
        double lineFourth = distanceBetweenTwoPoints(qdr.getP4(),qdr.getP1());

        return Math.sqrt((halfPerimeter-lineFirst) * (halfPerimeter-lineSecond) *
                (halfPerimeter-lineThird) * (halfPerimeter-lineFourth));
    }
}

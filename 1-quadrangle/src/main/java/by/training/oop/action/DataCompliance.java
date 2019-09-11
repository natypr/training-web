package by.training.oop.action;

import by.training.oop.entity.Point;
import by.training.oop.entity.Quadrangle;

import java.util.ArrayList;
import java.util.List;

import static by.training.oop.action.Calculation.distanceBetweenTwoPoints;

public class DataCompliance {

    private static final int VERTEXES_NUMBER = 4;
    private static final double EPS = 0.0001;

    public boolean isSquare(Quadrangle qdr){
        Point p1 = qdr.getP1();
        Point p2 = qdr.getP2();
        Point p3 = qdr.getP3();

        return isLineLengthEquals(qdr) && (p1.getX() == p2.getX()) && (p2.getY() == p3.getY());
    }

    public boolean isRhombus(Quadrangle qdr){
        List<Double> angleList = Calculation.listOfAngle(qdr);

        return isLineLengthEquals(qdr) &&
                (angleList.get(0).equals(angleList.get(2))) &&
                (angleList.get(1).equals(angleList.get(3)));
    }

    public boolean isTrapeze(Quadrangle qdr){
        Point p1 = qdr.getP1();
        Point p2 = qdr.getP2();
        Point p3 = qdr.getP3();
        Point p4 = qdr.getP4();

        boolean parallelX = (p1.getX() == p2.getX()) && (p3.getX() == p4.getX());
        boolean parallelY = (p1.getY() == p4.getY()) && (p2.getY() == p3.getY());

        return parallelX || parallelY;
    }

    public boolean isLineLengthEquals(Quadrangle qdr){
        return (distanceBetweenTwoPoints(qdr.getP1(), qdr.getP2()) ==
                        distanceBetweenTwoPoints(qdr.getP2(), qdr.getP3())) &&
                (distanceBetweenTwoPoints(qdr.getP2(), qdr.getP3()) ==
                        distanceBetweenTwoPoints(qdr.getP3(), qdr.getP4())) &&
                (distanceBetweenTwoPoints(qdr.getP3(), qdr.getP4()) ==
                        distanceBetweenTwoPoints(qdr.getP4(), qdr.getP1()));
    }

    public boolean isQuadrangle(Quadrangle qdr){
        return isThreePointsOnOneLine(qdr);
    }

    public boolean isThreePointsOnOneLine(Quadrangle qdr){
        Point p1 = qdr.getP1();
        Point p2 = qdr.getP2();
        Point p3 = qdr.getP3();
        Point p4 = qdr.getP4();

        //p1=p2=p3 or p1=p2=p4
        if ((p1.getX() == p2.getX()) &&  ((p2.getX() == p3.getX()) || (p2.getX() == p4.getX()))){
            return false;
        }
        //p1=p3=p4 or p2=p3=p4
        if ((p3.getX() == p4.getX()) &&  ((p3.getX() == p1.getX()) || (p3.getX() == p2.getX()))){
            return false;
        }

        if ((p1.getY() == p2.getY()) &&  ((p2.getY() == p3.getY()) || (p2.getY() == p4.getY()))){
            return false;
        }
        if ((p3.getY() == p4.getY()) &&  ((p3.getY() == p1.getY()) || (p3.getY() == p2.getY()))){
            return false;
        }

        return true;
    }

    public boolean isConvex(Quadrangle qdr){
        Point current = getVector(qdr, 3);
        Point next = getVector(qdr, 0);

        double vectorMul = current.getX() * next.getY() - current.getY() * next.getX();
        int sign = getSign(vectorMul);
        int p = 1;

        for (int i = 0; i < VERTEXES_NUMBER - 1; i++){
            current = getVector(qdr, i);
            next = getVector(qdr, i + 1);

            vectorMul = current.getX() * next.getY() - current.getY() * next.getX();

            p = p * sign * getSign(vectorMul);
            if (p < 0){
                return false;
            }
        }
        return true;
    }

    private static Point getVector(Quadrangle qdr, int numVec){
        double x, y;

        Point p1 = qdr.getP1();
        Point p2 = qdr.getP2();
        Point p3 = qdr.getP3();
        Point p4 = qdr.getP4();

        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        Point current = points.get(numVec);
        Point next = points.get((numVec + 1) % VERTEXES_NUMBER);

        x = current.getX() - next.getX();
        y = current.getY() - next.getY();

        return new Point(x, y);
    }

    private static int getSign(double r){
        if(Math.abs(r) < EPS){
            return 1;
        }else{
            return (int)Math.round(r / Math.abs(r));
        }
    }
}

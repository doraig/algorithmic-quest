package com.pigopoyo.algoquest.scans;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class GrahamScan {

    public Point2D getMin(Point2D[] points) {
        Point2D minPoint = points[0];
        int min = 0;
        for (int i = 1; i < points.length ; i++) {
           if (minPoint.y > points[i].y || (minPoint.y == points[i].y &&
                minPoint.x > points[i].x )) {
               minPoint = points[i];
               min = i;
           }
        }
        if (min > 0) {
            minPoint = points[0];
            points[0] = points[min];
            points[min] = minPoint;
        }
        return points[0];
    }

    public int skipSameAnglePoints(Point2D min, Point2D[] points){
        int m = 1;
        for (int i = 1; i < points.length; i++) {
            for (;i < points.length-1 && min.orientation(points[i],points[i+1]) == 0; i++);

            points[m] = points[i];
            m++;
        }
        return m;
    }

    public void scan(Point2D[] points) {

        Point2D min = this.getMin(points);

        Arrays.sort(points, new OrderComparator(min));

        int newArraySize = this.skipSameAnglePoints(min, points);

        if (newArraySize < 3){
            System.err.println("Cannot do scan!!!");
        }

        else {

            Stack<Point2D> stack = new Stack<>();
            stack.push(points[0]);
            stack.push(points[1]);
            stack.push(points[2]);

            for (int i = 3 ; i < newArraySize; i++) {
                Point2D nextToTop;
                while ((nextToTop = this.popNextToTop(stack))!= null && nextToTop.orientation(stack.peek(),points[i]) != 2) {
                    stack.pop();
                }
                stack.push(points[i]);
            }

            for (Point2D point2D : stack) {
                System.out.println("Points: "+ point2D.x + "," + point2D.y);
            }
        }
    }

    private Point2D popNextToTop(Stack<Point2D> points) {
        Point2D point = points.pop();
        Point2D nextPoint = points.peek();
        points.push(point);
        return nextPoint;
    }

}

class Point2D {

    int x;

    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public long distSq(Point2D point) {
        return (this.x - point.x)*(this.x-point.x) + (this.y - point.y)*(this.y - point.y);
    }

    public int orientation(Point2D pPoint, Point2D qPoint) {
        long val = (pPoint.x - this.x)*(qPoint.y - this.y) - (pPoint.y - this.y)*(qPoint.x - this.x);
        if (val == 0) {
            return  0;
        }
        return val > 0?1:2;
    }

    /**
     * Starting point for the JVM.
     */
    public static void main(String argument[]) {

        Point2D points[] =
                { new Point2D(0, 3), new Point2D(1, 1), new Point2D(2, 2), new Point2D(4, 4),
                        new Point2D(0, 0), new Point2D(1, 2), new Point2D(3, 1), new Point2D(3, 3)};
        new GrahamScan().scan(points);
    }
}

class OrderComparator implements Comparator<Point2D> {

    final Point2D basePoint;

    public OrderComparator(Point2D point) {
        this.basePoint = point;
    }


    @Override
    public int compare(Point2D o1, Point2D o2) {
        long val = basePoint.orientation(o1,o2);
        if (val == 0) {
            return (basePoint.distSq(o1) >= basePoint.distSq(o2))?1:-1;
        }
        return val == 2?-1:1;
    }
}

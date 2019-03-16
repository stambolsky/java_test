package ru.stqa.pft.sandbox;

public class Points {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(50, 90);

        System.out.println(p1.distance(p2));
        System.out.println(p1.distance(30,60));
        System.out.println(p1.distance(0.2, 3.5));

    }
}

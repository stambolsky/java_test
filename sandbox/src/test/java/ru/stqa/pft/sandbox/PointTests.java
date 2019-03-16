package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testPoint() {
        Point p1 = new Point(0.2, 1.75);
        Point p2 = new Point(50,90);
        Assert.assertEquals(p1.distance(p2), 101.33164609340953);
        Assert.assertEquals(p1.distance(30,45), 52.52239998324524);
        Assert.assertEquals(p1.distance(1000, 3043), 3201.3749549998042);
    }
}

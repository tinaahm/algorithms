package org.pg4200.ex01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TriangleClassificationTest {

    @Test
    public void testNotATriangle() {
        assertEquals(TriangleClassification.Classification.NOT_A_TRIANGLE, TriangleClassification.classify(0, 0, 0));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals(TriangleClassification.Classification.EQUILATERAL, TriangleClassification.classify(1, 1, 1));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals(TriangleClassification.Classification.ISOSCELES, TriangleClassification.classify(3, 2, 2));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals(TriangleClassification.Classification.SCALENE, TriangleClassification.classify(3, 2, 4));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals(TriangleClassification.Classification.NOT_A_TRIANGLE, TriangleClassification.classify(2, 2, 4));
    }

}

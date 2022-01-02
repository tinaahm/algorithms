package org.pg4200.ex04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.pg4200.ex04.TriangleClassification.*;
import static org.pg4200.ex04.TriangleClassification.Classification.*;

public class TriangleClassificationTest {

	@Test
	public void negativeATest() {
		Classification tst = TriangleClassification.classify(-1, 2, 3);

		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void negativeBTest() {
		Classification tst = TriangleClassification.classify(2, -1, 3);
		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void negativeCTest() {
		Classification tst = TriangleClassification.classify(2, 3, -1);
		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void zeroATest() {
		Classification tst = TriangleClassification.classify(0, 2, 3);
		assertEquals(NOT_A_TRIANGLE, tst);
	}

	@Test
	public void zeroBTest() {
		Classification tst = TriangleClassification.classify(2, 0, 3);
		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void zeroCTest() {
		Classification tst = TriangleClassification.classify(2, 3, 0);
		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void negativeParametersTest() {
		Classification tst = TriangleClassification.classify(-1, -1, -1);
		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void zeroParametersTest() {
		Classification tst = TriangleClassification.classify(0, 0, 0);
		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void equilateralTest() {
		Classification tst = TriangleClassification.classify(1, 1, 1);
		assertEquals(EQUILATERAL, tst);

	}

	@Test
	public void integerMAXTest() {
		int max = Integer.MAX_VALUE;

		Classification tst = TriangleClassification.classify(max, max, max);
		assertEquals(EQUILATERAL, tst);

	}

	@Test
	public void isoscelesTestOne() {
		Classification tst = TriangleClassification.classify(1, 2, 2);
		assertEquals(ISOSCELES, tst);

	}

	@Test
	public void isoscelesTestTwo() {
		Classification tst = TriangleClassification.classify(2, 1, 2);
		assertEquals(ISOSCELES, tst);

	}

	@Test
	public void isoscelesTestThree() {
		Classification tst = TriangleClassification.classify(2, 2, 1);
		assertEquals(ISOSCELES, tst);

	}

	@Test
	public void unequalTriangleOne() {
		Classification tst = TriangleClassification.classify(5, 2, 2);

		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void unequalTriangleTwo() {
		Classification tst = TriangleClassification.classify(2, 5, 2);

		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void unequalTriangleThree() {
		Classification tst = TriangleClassification.classify(2, 2, 5);

		assertEquals(NOT_A_TRIANGLE, tst);

	}

	@Test
	public void isoscelesMaxTestOne() {
		int max = Integer.MAX_VALUE;
		Classification tst = TriangleClassification.classify((max - 1), max,
				max);
		assertEquals(ISOSCELES, tst);

	}

	@Test
	public void isoscelesMaxTestTwo() {
		int max = Integer.MAX_VALUE;
		Classification tst = TriangleClassification.classify(max, (max - 1),
				max);
		assertEquals(ISOSCELES, tst);

	}

	@Test
	public void isoscelesMaxTestThree() {
		int max = Integer.MAX_VALUE;
		Classification tst = TriangleClassification.classify(max, max, (max - 1));

		assertEquals(ISOSCELES, tst);


	}

	@Test
	public void scaleneTest() {
		Classification tst = TriangleClassification.classify(2, 3, 4);

		assertEquals(SCALENE, tst);

	}

	@Test
	public void scaleneMaxTest() {
		int max = Integer.MAX_VALUE;

		Classification tst = TriangleClassification.classify(max, (max - 1),
				(max - 2));

		assertEquals(SCALENE, tst);

	}
}
package org.pg4200.ex04;

import static org.pg4200.ex04.TriangleClassification.Classification.*;

public class TriangleClassification {

	public enum Classification {NOT_A_TRIANGLE, ISOSCELES, SCALENE, EQUILATERAL}

	public static Classification classify(int a, int b, int c) {

		if (a <= 0 || b  <= 0 || c <= 0) return NOT_A_TRIANGLE;

		if (a == b && c == b) return EQUILATERAL;

		int longestSide = Math.max(a, Math.max(b, c));

		/* Finding the longest side by adding the two smaller ones and
		 checking if they're >= longestSide does not work as
		 Integer.MAX_VALUE + Integer.MAX_VALUE (aka big int values) will
		 yield a result where longestSide is always bigger. */
		if ((longestSide == a && (longestSide - b) - c >= 0) ||
				(longestSide == b && (longestSide - a) - c >= 0) ||
				(longestSide == c && (longestSide - a) - b >= 0)) return NOT_A_TRIANGLE;

		if (a == b || b == c || a == c) return ISOSCELES;

		// If all sides are of different sizes but still valid:
		return SCALENE;
	}
}
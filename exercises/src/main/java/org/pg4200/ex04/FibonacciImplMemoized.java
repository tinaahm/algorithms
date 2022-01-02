package org.pg4200.ex04;

public class FibonacciImplMemoized implements Fibonacci {

	int[] fibonacciSeries;
	boolean initializeArray = true;

	@Override
	public int compute(int n) throws IllegalArgumentException {
		if (n < 0) throw new IllegalArgumentException();

		if (initializeArray) {
			fibonacciSeries = new int[n + 1];
			fibonacciSeries[0] = 0;
			if (fibonacciSeries.length > 1) {
				fibonacciSeries[1] = 1;
			}
			initializeArray = false;
		}

		if (fibonacciSeries[n] != 0 || n == 0) return fibonacciSeries[n];

		fibonacciSeries[n] = compute(n - 1) + compute(n - 2);

		return fibonacciSeries[n];
	}
}
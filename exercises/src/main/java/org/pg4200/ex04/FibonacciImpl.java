package org.pg4200.ex04;

public class FibonacciImpl implements Fibonacci {

	@Override
	public int compute(int n) throws IllegalArgumentException {
		if (n < 0) throw new IllegalArgumentException();

		if (n == 1) return 1;
		if (n == 0) return 0;

		return compute(n - 1) + compute(n - 2);
	}
}
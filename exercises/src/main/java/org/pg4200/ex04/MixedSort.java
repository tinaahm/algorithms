package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {

	@Override
	public <T extends Comparable<T>> void sort(T[] array) {
		if (array == null) {
			return;
		}

		T[] buffer = (T[]) new Comparable[array.length];
		mixedSort(0, (array.length - 1), 4, array, buffer);
	}

	private <T extends Comparable<T>> void mixedSort(int low,
													 int high,
													 int bubbleLimit,
													 T[] array, T[] buffer) {

		if ((high - low) < bubbleLimit) {
			boolean switched = true;

			while (switched) {
				switched = false;

				for (int i = low; i < high; i++) {
					if (array[i].compareTo(array[i + 1]) > 0) {
						T tmp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = tmp;
						switched = true;
					}
				}
			}
			return;
		}

		int middle = low + (high - low) / 2;

		mixedSort(low, middle, bubbleLimit, array, buffer);

		mixedSort((middle + 1), high, bubbleLimit, array, buffer);

		merge(low, middle, high, array, buffer);
	}

	private <T extends Comparable<T>> void merge(int low, int middle,
												 int high, T[] array,
												 T[] buffer) {
		for (int i = low; i <= high; i++) {
			buffer[i] = array[i];
		}

		// Starting point of "first"-half of array
		int i = low;

		//Starting point of second half
		int j = (middle + 1);

		for (int k = low; k <= high; k++) {
			if (i > middle) {
				// Second part of array has been compared to first.
				array[k] = buffer[j++];
			} else if (j > high) {
				// Second part of array has been compared to first.
				array[k] = buffer[i++];
			} else if ((buffer[j].compareTo(buffer[i])) < 0) {
				array[k] = buffer[j++];
			} else {
				array[k] = buffer[i++];
			}
		}

	}
}
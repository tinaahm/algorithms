package org.pg4200.ex03;

import java.util.Comparator;

public class OptimizedBubbleSort {

	public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized) {

		int compareCounter = 0;
		boolean swapped = true;

		if (!optimized) {
			while (swapped) {
				swapped = false;

				for (int i = 0; i < (array.length - 1); i++) {
					int result = comparator.compare(array[i], array[i + 1]);
					compareCounter++;

					if (result > 0) { // first value is bigger than second value
						T copy = array[i];
						array[i] = array[i + 1];
						array[i + 1] = copy;
						swapped = true;
					}
				}
			}
		} else if (optimized) {
			int lastIndexSwapped = 0;

			while (swapped) {
				swapped = false;

				if (compareCounter == 0) {
					for (int i = 0; i < (array.length - 1); i++) {
						int result = comparator.compare(array[i], array[i + 1]);
						compareCounter++;

						if (result > 0) { // first value is bigger than second value
							T copy = array[i];
							array[i] = array[i + 1];
							array[i + 1] = copy;
							swapped = true;
							lastIndexSwapped = i;
						}
					}
				} else if (compareCounter > 0) {
					for (int i = 0; i < lastIndexSwapped; i++) {
						int result = comparator.compare(array[i], array[i + 1]);
						compareCounter++;

						if (result > 0) { // first value is bigger than second value
							T copy = array[i];
							array[i] = array[i + 1];
							array[i + 1] = copy;
							swapped = true;
							lastIndexSwapped = i;
						}
					}
				}
			}
		}

		return compareCounter;
	}

}
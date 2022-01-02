package org.pg4200.ex03;

public class SortCheckerImp implements SortChecker {
	@Override
	public <T extends Comparable<T>> boolean isSortedCopy(T[] original,
														  T[] sorted) {

		if (sorted == null && original == null) {
			return true;
		}

		if (sorted == null || original == null) {
			return false;
		}

		//Check if sorted is actually sorted
		for (int i = 0; i < (sorted.length - 1); i++) {
			if (sorted[i] == null || sorted[i + 1] == null) {
				return false;
			}

			int result = sorted[i].compareTo(sorted[i + 1]);

			if (result > 0) { // ob1 "bigger" than ob2
				return false;
			}
		}

		//Check length
		if (sorted.length != original.length) {
			return false;
		}


		for (int i = 0; i < original.length; i++) {
			if (original[i] == null) {
				return false;
			}
			for (int j = 0; j < sorted.length; j++) {
				if (original[i] == sorted[j]) { //Match found
					sorted[j] = null;
					break;
				} else if (j == (sorted.length - 1) && original[i] != sorted[j]) { // No match found
					return false;
				}
			}
		}

		return true;
	}
}
package org.pg4200.ex01;

public class ArrayUtilsImp implements org.pg4200.ex01.ArrayUtils{

    @Override
    public int min(int[] array) throws IllegalArgumentException {
        arrayCheck(array);

        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if ( min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {
        arrayCheck(array);

        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if ( max < array[i]) {
                max = array[i];
            }
        }

        return max;
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        arrayCheck(array);

        int total = 0;

        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        double mean = total/array.length;

        return mean;
    }

    public void arrayCheck(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
    }
}

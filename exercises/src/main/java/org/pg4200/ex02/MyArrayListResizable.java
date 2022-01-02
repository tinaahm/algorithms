package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizable<T> extends MyArrayList<T> {

    public MyArrayListResizable(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int index, T value) {
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }

        if (index >= data.length) {
            Object[] copy = new Object[data.length];
            for (int i = 0; i < data.length; i++) {
                copy[i] = data[i];
            }

            data = new Object[(data.length * 2)];
            for (int k = 0; k < copy.length; k++) {
                data[k] = copy[k];
            }
        }

        for(int j=size-1; j>=index; j--){
            data[j+1] = data[j];
        }

        data[index] = value;
        size++;
    }
}

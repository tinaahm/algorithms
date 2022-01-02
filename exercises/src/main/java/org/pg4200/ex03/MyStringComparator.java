package org.pg4200.ex03;

import java.util.Comparator;

public class MyStringComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		String obj1 = (String) o1;
		String obj2 = (String) o2;

		return obj1.compareTo(obj2);
	}

}

/*
public class MyStringComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		o1.equals()
		return 0;
	}

}*/
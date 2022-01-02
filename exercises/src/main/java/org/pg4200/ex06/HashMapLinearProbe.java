package org.pg4200.ex06;

import org.pg4200.les06.hash.MyHashMap;

import java.lang.reflect.Array;

public class HashMapLinearProbe<K, V> implements MyHashMap<K, V> {

	private int size;
	private final int M = 997;

	private class Entry {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);

	@Override
	public void put(K key, V value) {
		int arrayIndex = key.hashCode() % M;

		if (data[arrayIndex] == null) {
			data[arrayIndex] = new Entry(key, value);
			size++;
			return;
		}

		// Equal keys implies equal values. No increase in size
		if (data[arrayIndex].key == key) {
			data[arrayIndex].value = value;
			return;
		}

		//Key is not the same. Traverse the list until an empty space if found

		for (int i = (arrayIndex + 1); i < M; i++) {
			if (data[i] == null) {
				data[i] = new Entry(key, value);
				size++;
				return;
			}
		}


		for (int i = 0; i < arrayIndex; i++) {
			if (data[i] == null) {
				data[i] = new Entry(key, value);
				size++;
				return;
			}
		}

	}

	@Override
	public void delete(K key) {
		int arrayIndex = key.hashCode() % M;

		if (data[arrayIndex] == null) return;

		if (data[arrayIndex].key == key) {
			data[arrayIndex].key = null;
			size--;
			return;
		}

		for (int i = (arrayIndex + 1); i < M; i++) {
			if (data[i].key == key) {
				data[arrayIndex].key = null;
				size--;
				return;
			}
		}

		for (int i = 0; i < arrayIndex; i++) {
			if (data[i].key == key) {
				data[i].key = null;
				size--;
				return;
			}
		}

	}

	@Override
	public V get(K key) {
		int arrayIndex = key.hashCode() % M;

		if (data[arrayIndex] == null) return null;

		if (data[arrayIndex].key == null) return null;

		return data[arrayIndex].value;
	}

	@Override
	public int size() {
		return size;
	}

}
//package org.pg4200.ex09;
/*
import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class AllPathsGraph<V> extends UndirectedGraph<V> {

	public List<List<V>> findAllPaths(V start, V end) {

		if (!graph.containsKey(start) || !graph.containsKey(end)) return null;

		if (start.equals(end))
			throw new IllegalArgumentException();

		Collection<V> adjacents = getAdjacents(start);
		List<List<V>> pathsList;

		for (V adj : adjacents) {

			List<V> list = new ArrayList<>();

		}

		return pathsList;
	}

	private List<V> findPath(List<V> path, V current, V end) {

		path.add(current);

		if (path.get(path.size() - 1) == end)
			return path;

		for (V connected : getAdjacents(current)) {

			ArrayList

			if (connected == null) continue;

			findPath(path, connected, end);

		}

		return path;
	}

}*/
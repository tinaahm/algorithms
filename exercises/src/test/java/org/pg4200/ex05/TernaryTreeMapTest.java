package org.pg4200.ex05;

import org.pg4200.les05.MyMap;
import org.pg4200.les05.MyMapTestTemplate;
import org.pg4200.les05.MyMapTreeBased;

public class TernaryTreeMapTest extends MyMapTestTemplate {

	protected <K extends Comparable<K>, V> MyMapTreeBased<K, V> getTreeInstance() {
		return new TernaryTreeMap<>();
	}

	@Override
	protected <K extends Comparable<K>, V> MyMap<K, V> getInstance() {
		return getTreeInstance();
	}
}
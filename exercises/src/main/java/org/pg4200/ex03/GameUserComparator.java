package org.pg4200.ex03;

import java.util.Comparator;

public class GameUserComparator implements Comparator<GameUser> {
	@Override
	public int compare(GameUser o1, GameUser o2) {
		int o1Points = o1.getPoints();
		int o2Points = o2.getPoints();

		if (o1Points < o2Points) {
			return   o1Points - o2Points;
		} else if (o1Points > o2Points) {
			return o1Points - o2Points;
		} else if (o1Points == o2Points) {
			return o1.getUserId().compareTo(o2.getUserId());
		}

		return 0;
	}
}
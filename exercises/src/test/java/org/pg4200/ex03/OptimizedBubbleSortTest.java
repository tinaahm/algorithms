package org.pg4200.ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptimizedBubbleSortTest {

	@Test
	public void sortTest() {
		String[] letterArray = {"c", "b", "a", "d", "e", "f"};
		String[] optimizedLetterArray = {"c", "b", "a", "d", "e", "f"};

		OptimizedBubbleSort sortClass = new OptimizedBubbleSort();

		MyStringComparator<String> comparator = new MyStringComparator<>();
		int regularSortResult = sortClass.sort(letterArray, comparator, false);

		int optimizedSortResult = sortClass.sort(optimizedLetterArray, comparator, true);

		assertEquals(15, regularSortResult);

		assertTrue(optimizedSortResult < (regularSortResult/2));
	}

	@Test
	public void gameUserTest() {
		OptimizedBubbleSort sortClass = new OptimizedBubbleSort();

		GameUser user1 = new GameUser("Avery", 250);
		GameUser user2 = new GameUser("Ice", 500);
		GameUser user3 = new GameUser("Ace", 100);
		GameUser user4 = new GameUser("Fitz", 237);
		GameUser user5 = new GameUser("Ty", 194);

		GameUser[] array = {user1, user2, user3, user4, user5};
		GameUser[] optimizedArray = {user1, user2, user3, user4, user5};

		GameUserComparator gameUserComparator = new GameUserComparator();

		int regularSort = sortClass.sort(array, gameUserComparator, false);
		int optimizedSort = sortClass.sort(optimizedArray, gameUserComparator, true);

		assertTrue(optimizedSort < (regularSort/2));
		assertEquals(500, array[4].getPoints());
		assertEquals(500, optimizedArray[4].getPoints());

	}
}
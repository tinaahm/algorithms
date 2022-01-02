package org.pg4200.ex06;

import java.util.List;

public class ImmutableBookAndAuthorTest extends ImmutableBookAndAuthorTestTemplate {

	@Override
	protected ImmutableBook getNewEmptyInstanceOfBook() {
		List<ImmutableAuthor> author = List.of(getNewEmptyInstanceOfAuthor());
		return new ImmutableBookImp("", 0, author);
	}

	@Override
	protected ImmutableAuthor getNewEmptyInstanceOfAuthor() {
		return new ImmutableAuthorImp("", "");
	}
}
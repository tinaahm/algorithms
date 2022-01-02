package org.pg4200.ex06;

import java.util.Arrays;
import java.util.List;

public class ImmutableBookImp implements ImmutableBook {

	private final String title;
	private final int year;
	private final List<ImmutableAuthor> authors;

	public ImmutableBookImp(String title, int year,
							List<ImmutableAuthor> authors) {
		this.title = title;
		this.year = year;
		this.authors = authors;
	}

	@Override
	public ImmutableBook withTitle(String title) {
		return new ImmutableBookImp(title, year, authors);
	}

	@Override
	public ImmutableBook withYear(int year) {
		return new ImmutableBookImp(title, year, authors);
	}

	@Override
	public ImmutableBook withAuthors(List<ImmutableAuthor> authors) {
		return new ImmutableBookImp(title, year, authors);
	}

	@Override
	public ImmutableBook withAuthors(ImmutableAuthor... authors) {
		List<ImmutableAuthor> list = Arrays.asList(authors);
		return new ImmutableBookImp(title, year, list);

	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getYear() {
		return year;
	}

	@Override
	public List<ImmutableAuthor> getAuthors() {
		return authors;
	}
}
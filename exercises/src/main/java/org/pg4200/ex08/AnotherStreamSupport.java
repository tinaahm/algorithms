/*
package org.pg4200.ex08;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AnotherStreamSupport {

	public static <T, C extends Iterable<T>> AnotherStream<T> createStream(C collection) {
		return new Pipeline<T, T, T>(collection.iterator());
	}

	protected static class Pipeline<IN, OUT, T> implements AnotherStream<OUT> {

		protected final Iterator<T> iterator;
		protected final Pipeline<?, IN, T> previousStage;
		protected final int depth;

		protected Pipeline(Iterator<T> iterator) {
			this.iterator = iterator;
			this.previousStage = null;
			this.depth = 0;
		}

		protected Pipeline(Pipeline<?, IN, T> previousStage) {
			this.iterator = previousStage.iterator;
			this.previousStage = previousStage;
			this.depth = previousStage.depth + 1;
		}

		protected Consumer<T> chainAllConsumersInThePipeLine(Consumer<OUT> consumer) {
			Objects.requireNonNull(consumer);

			Pipeline pipeLine = this;

			while (pipeLine.depth > 0) {
				consumer = pipeLine.chainConsumerToCurrentPipe(consumer);
				pipeLine = pipeLine.previousStage;
			}

			return (Consumer<T>) consumer;
		}

		protected ChainedReference<IN, OUT> chainConsumerToCurrentPipe(Consumer<OUT> consumer) {
			throw new IllegalStateException();
		}

		@Override
		public int count() {

			int numberOfElements = 0;

			while (iterator.hasNext()) {
				numberOfElements++;
				iterator.next();
			}

			return numberOfElements;
		}

		@Override
		public String joinToString(String separator) {

			int numberOfElements = count();
			int i = 0;

			String finalString = "";

			while (iterator.hasNext()) {
				T element = iterator.next();

				if (element.toString() == null) {
					finalString = finalString.concat("");
				} else {
					finalString = finalString.concat(element.toString());
				}

				if (i < numberOfElements) {
					finalString = finalString.concat(separator);
				}
				i++;
			}

			return finalString;
		}

		@Override
		public boolean any(Predicate<OUT> predicate) {

			while (iterator.hasNext()) {
				T element = iterator.next();

				if (predicate.test((OUT) element)) {
					return true;
				}
			}

			return false;
		}

		@Override
		public Optional<OUT> reduce(BinaryOperator<OUT> accumulator) {

			Optional result = null;
			int numberOfElements = count();

			while (iterator.hasNext()) {
				OUT firstElement = (OUT) iterator.next();
				OUT secondElement = (OUT) iterator.next();

				result += accumulator.apply(iterator.next(), iterator.next());

			}

			return Optional.empty();
		}

		@Override
		public AnotherStream<OUT> distinct() {
			return null;
		}

		@Override
		public AnotherStream<OUT> skip(int n) {
			return null;
		}

		@Override
		public AnotherStream<OUT> sorted() {
			return null;
		}
	}

	protected static abstract class ChainedReference<IN, OUT> implements Consumer<IN> {

		protected final Consumer<OUT> downstream;

		public ChainedReference(Consumer<OUT> downstream) {
			this.downstream = Objects.requireNonNull(downstream);
		}

	}

}*/
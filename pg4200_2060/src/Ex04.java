import java.util.*;
import java.util.function.Consumer;

public class Ex04<T> {

	public class Student {
		public int student_id;
		public String name;
		// a map that takes a course id as a key and stores the grade as a
		// value, for each course this student has taken.
		Map<String, Double> examPoints;
	}

	public static <T, C extends Iterable<T>> Ex04<T> createStream(C collection) {
		return new Pipeline<T, T, T>(collection.iterator());
	}

	static class Pipeline<IN, OUT, T> extends Ex04<T> {

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

		protected Consumer<T> chainAllConsumersInThePipeLine(Consumer<T> consumer) {
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

		public double taskA(String courseName) {

			List<Student> studentList = new ArrayList<>();

			Consumer<Student> collectingConsumer = new Consumer<Student>() {
				@Override
				public void accept(Student out) {
					if (out.examPoints.containsKey(courseName)) {
						studentList.add(out);
					}
				}
			};

			Consumer<T> chain =
					chainAllConsumersInThePipeLine((Consumer<T>) collectingConsumer);

			while (iterator.hasNext()) {
				T element = iterator.next();
				chain.accept(element);
			}

			double result = 0;

			for (Student s : studentList) {
				result += s.examPoints.get(courseName);
			}

			return  (result) / (studentList.size());
		}

		public List<String> taskB() {

			List<Course> courses = new ArrayList<>();

			Consumer<Course> collectingConsumer = new Consumer<Course>() {
				@Override
				public void accept(Course out) {
					if (out.evaluation.matches("project|exam") && out.topics.contains("programming")) {
						courses.add(out);
					}
				}
			};

			Consumer<T> chain = chainAllConsumersInThePipeLine((Consumer<T>) collectingConsumer);

			while (iterator.hasNext()) {
				T element = iterator.next();
				chain.accept(element);
			}

			Map<Integer, Student> allPoints = new HashMap<>();

			// Add all values in all points-Maps in all courses to allPoints
			for (Course c : courses) {
				Set<Student> keys = c.points.keySet();
				keys.forEach(k -> allPoints.put(c.points.get(k), k));
			}

			// Sort the values in allPoints and add the "matching" student to
			// students ArrayList.
			List<Integer> keys = new ArrayList<>(allPoints.keySet());
			ArrayList<Student> students = new ArrayList<>();
			boolean switched = true;

			while (switched) {
				switched = false;

				for (int i = 0; i < keys.size() - 1; i++) {
					int comparison = keys.get(i).compareTo(keys.get(i+1));
					if (comparison < 0) {
						int tmp = keys.get(i);
						keys.set(i, keys.get(i+1));
						keys.set(i+1, tmp);
						switched = true;
					}
				}
			}

			for (Integer key : keys) {
				students.add(allPoints.get(key));
			}

			List<String> names = new ArrayList<>();

			students.forEach(s -> names.add(s.name));

			for (String name : names) {
				int counter = 0;
				Integer[] indices = new Integer[names.size()];

				for (int i = 0; i < names.size(); i++) {
					if (name.equals(names.get(i))) {
						indices[counter] = i;
						counter++;
					}
				}

				if (counter > 1) {
					for (int i = 1; i < counter; i++) {
						names.remove(names.get(indices[i]));
					}
				}

			}

			return names;
		}

	}

	public class Course {
		String course_code;
		String topics;
		String evaluation;
		Map<Student, Integer> points;
	}

	abstract class ChainedReference<IN, OUT> implements Consumer<IN> {

		protected final Consumer<OUT> downstream;

		public ChainedReference(Consumer<OUT> downstream) {
			this.downstream = Objects.requireNonNull(downstream);
		}

	}
}
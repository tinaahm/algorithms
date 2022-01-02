import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex02Test {

	private Ex02<Integer, Student> map;

	@BeforeEach
	public void initializeTest() {
		map = new Ex02<>();
	}

	@Test
	public void testAddStudentsToMap() {
		Student student1 = new Student(21, "Mary", "Lamb");
		Student student2 = new Student(23, "Gary", "Lamb");
		Student student3 = new Student(01, "Katie", "Chance");

		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);
		map.put(student3.getId(), student3);

		assertEquals(3, map.size());
	}

	@Test
	public void testRetrieveAddedStudent() {
		Student student1 = new Student(21, "Mary", "Lamb");
		Student student2 = new Student(23, "Gary", "Lamb");
		Student student3 = new Student(01, "Katie", "Chance");

		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);
		map.put(student3.getId(), student3);

		int result = map.get(01).getId();

		assertEquals(01, result);
	}

	@Test
	public void testDeleteStudent() {
		Student student1 = new Student(21, "Mary", "Lamb");
		Student student2 = new Student(23, "Gary", "Lamb");
		Student student3 = new Student(01, "Katie", "Chance");

		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);
		map.put(student3.getId(), student3);

		assertEquals(3, map.size());

		map.delete(23);

		assertEquals(2, map.size());
	}

	@Test
	public void testGetExistingStudentByName() {
		Student student1 = new Student(21, "Mary", "Lamb");
		Student student2 = new Student(23, "Gary", "Lamb");
		Student student3 = new Student(01, "Katie", "Chance");

		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);
		map.put(student3.getId(), student3);

		Student result = map.getByName("Lamb");

		assertEquals(21, result.getId());
	}

	@Test
	public void testGetNonExistentStudentByName() {
		Student student1 = new Student(21, "Mary", "Lamb");
		Student student2 = new Student(23, "Gary", "Lamb");
		Student student3 = new Student(01, "Katie", "Chance");

		map.put(student1.getId(), student1);
		map.put(student2.getId(), student2);
		map.put(student3.getId(), student3);

		Student result = map.getByName("Mark");

		assertNull(result);
	}


}
import org.pg4200.les05.MyMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

// This is the StudentMap Class
// Here K wil be the studentID and V Student class.
public class Ex02<K extends Comparable<K>, V> implements MyMap<K, V> {

	private class TreeNode {

		public K studentID;
		public V student;

		public TreeNode left;
		public TreeNode right;

	}

	private ArrayList<TreeNode> studentList =
			new ArrayList<>(Arrays.asList( null,null,null,null,null,null
					,null,null,null,null));
	private int size;

	@Override
	public void put(K studentID, V student) {
		Objects.requireNonNull(studentID);

		int id =
				Integer.parseInt(String.valueOf(studentID.toString().charAt(0)));
		studentList.set(id, put(studentList.get(id), studentID, student));
	}

	private TreeNode put(TreeNode root, K studentID, V student) {
		// Add a new node if it is not present.
		if (root == null) {
			TreeNode node = new TreeNode();
			node.studentID = studentID;
			node.student = student;
			size++;
			return node;
		}

		int keyComparison = studentID.compareTo(root.studentID);

		// Student id is bigger than current node
		if (keyComparison > 0) {
			root.right = put(root.right, studentID, student);
			return root;
		}

		if (keyComparison < 0) {
			root.left = put(root.left, studentID, student);
			return root;
		}

		// Replace student at current node
		// as id == root.studentID
		root.student = student;

		return root;
	}

	@Override
	public void delete(K studentID) {
		Objects.requireNonNull(studentID);

		int id = Integer.parseInt(String.valueOf(studentID.toString().charAt(0)));
		studentList.set(id, delete(studentList.get(id), studentID));
	}

	private TreeNode delete(TreeNode root, K studentID) {

		if (root == null) return null;

		int keyComparison = studentID.compareTo(root.studentID);

		if (keyComparison > 0) {
			root.right = delete(root.right, studentID);
			return root;
		}

		if (keyComparison < 0) {
			root.left = delete(root.left, studentID);
			return root;
		}

		// studentID is equal to current node
		size--;

		if (root.right == null) return root.left;
		if (root.left == null) return root.right;

		// The node has both children.
		// Find the biggest value on the left node
		// and change the nodes accordingly
		TreeNode tmp = root;
		root = max(tmp.left);
		root.left = deleteMax(tmp.left);
		root.right = tmp.right;

		return root;
	}

	private TreeNode max(TreeNode root) {
		if (root.right == null) return root;
		return max(root.right);
	}

	private TreeNode deleteMax(TreeNode root) {
		if (root.right == null) return root.left;

		root.right = deleteMax(root.right);
		return root;
	}

	@Override
	public V get(K studentID) {
		Objects.requireNonNull(studentID);
		int id = Integer.parseInt(String.valueOf(studentID.toString().charAt(0)));
		return get(studentList.get(id), studentID);
	}

	private V get(TreeNode root, K studentID) {

		if (root == null) return null;

		int keyComparison = studentID.compareTo(root.studentID);

		if (keyComparison > 0) return get(root.right, studentID);

		if (keyComparison < 0) return get(root.left, studentID);

		// StudentID (key) equals current root key
		// i.e. keyComparison == 0
		return root.student;
	}

	@Override
	public int size() {
		return size;
	}

	public Student getByName(String searchName) {

		for (int i = 0; i < 10; i++) {
			Student student = getByName(studentList.get(i), searchName);
			// If null is returned by the getByName function keep searching.
			if ( student == null) continue;
			return student;
		}
		// For loop did not return a Student so the searchName does not apply
		// to any of the students in the map.
		return null;
	}

	private Student getByName(TreeNode root, String searchName) {
		if (root == null) return null;

		Student student = (Student) root.student;

		// Return current student if the first/last name matches searchName.
		if (student.getFirstName().equals(searchName) || student.getLastName().equals(searchName)) return student;

		// Search connecting nodes if they exist and return the result.
		if (root.right != null) return getByName(root.right, searchName);
		if (root.left != null) return getByName(root.left, searchName);

		return null;
	}

	public static class Student {

		private int id;
		private String firstName;
		private String lastName;

		public Student(int id, String firstName, String lastName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	}
}
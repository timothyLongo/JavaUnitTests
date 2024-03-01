package TASK_TEST_PACKAGE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import TASK_PACKAGE.Task;

class TaskTest {

	@Test
	void testTask() {
		
		// CREATE DUMMY TASK OBJ FOR TEST
		Task task = new Task("0123456789",
				"blackbook",
				"recover stolen equipment");
		
		// NOW WE MAKE CERTAIN
		// OBJ ATTRIBUTES ARE, IN FACT, ASSIGNED
		assertTrue(task.getID().equals("0123456789"));
		assertTrue(task.getName().equals("blackbook"));
		assertTrue(task.getDesc().equals("recover stolen equipment"));

	}
	
	// ID TESTS
	@Test
	void testTaskIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Task("01234567891111111111111111",
							"blackbook",
							"recover stolen equipment");
				});
	}
	@Test
	void testTaskIDNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Task(null,
							"blackbook",
							"recover stolen equipment");
				});
	}
	
	// NAME TESTS
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Task("0123456789",
							"THIS IS OVER 20 CHAR"
							+ "THIS IS OVER 20 CHAR"
							+ "THIS IS OVER 20 CHAR"
							+ "THIS IS OVER 20 CHAR",
							"recover stolen equipment");
				});
	}
	@Test
	void testTaskNameNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Task("0123456789",
							null, 
							"recover stolen equipment");
				});
	}
	
	// DESC TESTS
	@Test
	void testTaskDescTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Task("0123456789",
							"blackbook",
							"THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR"
							+ "THIS IS OVER 50 CHAR");
				});
	}
	@Test
	void testTaskDescNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Task("0123456789",
							"blackbook", 
							null);
				});
	}
}

package TASK_TEST_PACKAGE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import TASK_PACKAGE.Task;
import TASK_PACKAGE.TaskService;

class TaskServiceTest {

	// ASSERTIONS THAT OUR TASK SERVICE FUNCTIONS
	// AS IT SHOULD
		
	// WE WILL TEST EACH FUNCTION TO MAKE CERTAIN
	// THAT WE YEILD THE RESULT WE'RE LOOKING FOR
		
	// FIRST TEST
	// ADDING/ DELETING TASK SHOULD RESULT IN
	// ARRAYLIST HOLDING/ NOT HOLDING THAT TASK
	
	@Test
	void TestTaskServiceAddAndDeleteTask() {
		TaskService.tasks.clear();
		// TEST FOR ADDING CONTACT
		TaskService.addTask("operationA", "climb the "
				+ "barracks and take the base");
		Task current = TaskService.tasks.get(0);
		assertTrue(current.getName().equals("operationA"));
		
		// TEST FOR DELETING CONTACT
		String id = current.getID();
		TaskService.deleteTask(id);
		assertTrue(TaskService.tasks.size() == 0);
	}
	
	// NOW FOR THE UPDATE METHOD TESTS
	@Test
	void TestContactServiceUpdates() {

		TaskService.addTask("Alpha", "find charlie brown");
		Task current = TaskService.tasks.get(0);

		String id = current.getID();
			
		// UPDATE NAME TEST
		TaskService.updateName(id,
					"Omega");
		assertTrue(current.getName().equals("Omega"));
			
		// UPDATE DESC TEST
		TaskService.updateDesc(id,
							"find William Schnider");
		assertTrue(current.getDesc().equals("find"
					+ " William Schnider"));
	}
	
	// NOW FOR THE INCREDIBLY INCREDIBLY
	// (TWICE FOR EMPHASIS) RARE
	// OFF CHANCE THAT 2 IDS ARE ALIKE
	@Test
	void TestTaskServiceDuplicateIDs() {
			
		TaskService.addTaskForTest("0123456789",
					"Alpha",
					"find Bravo");
			
		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> {
					TaskService.addTaskForTest(
							"0123456789",
							"Bravo",
							"find Alpha");
				});
			
	}
	// that's all she wrote
}

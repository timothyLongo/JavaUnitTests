// TIMOTHY LONGO

// CS-320

// ASSIGNMENT 4-1

// 1 / 26 / 2024



package TASK_PACKAGE;


// we are using in-memory data structures for this so we
import java.util.ArrayList; // import the ArrayList class


public class TaskService {

	// WE need to establish our arraylist
	// which is our way to save this tasks
	// to some sort of in-memory data
	public static ArrayList<Task> tasks =
			new ArrayList<Task>();
	// this translate to
	// create ArrayList of type 'Task objects'
	// call the ArrayList 'tasks'
	// 'new ArrayList<Task>();' means
	// yes, go ahead and create it
	// and leave it empty please
	
	
	// now for our methods / functions
	// first we'll need a way to generate a random
	// ID for each task inputted
	// that is NO LONGER THAN 1O CHAR
	// which is ALSO A STRING
	public static String generateID() {
		// generate random sequence of 10 char number
		long number = (long) Math.floor(Math.random()
				* 9_000_000_000L) + 1_000_000_000L;
		
		// convert number to string as per requirement
		String uniqueID = Long.toString(number);
		return uniqueID;
	}
	
	// next of course
	// we need a method to add a task
	public static void addTask(String name, String desc) {
		// PULL FROM OUR 'generateID' function
		// for the new task's ID
		String ID = generateID();
				
		// CREATE NEW TASK
		Task task = new Task(ID, name, desc);
				
		// ACCOUNTING FOR THE INCREDIBLY RARE CASE
		// OF DUPLICATE IDS
		// WE TEST AND CATCH IT BEFORE WE ADD IT
		// AND BEFORE WE GO ANY FURTHER
		for (int i = 0; i < tasks.size(); ++i) {
			Task current = tasks.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A DUPLICATE
				// AND WE CAUGHT IT BEFORE
				// ADDING TO OUR ARRAYLIST
				throw new IllegalArgumentException(
						"ID DUPLICATE - TRY AGAIN");
			}
		}
				
		// ADD TASK TO OUR TASK OBJ ARRAYLIST 'tasks'
		tasks.add(task);
	}
	
	// now we need a way to delete the task
	// by the ID
	public static void deleteTask(String ID) {
		// FIND THE TASK
		// WITHIN OUR ARRAYLIST
		// WITH THE ID
				
		// FIRST FIND INDEX OF OUR TASK
		// WITH THE SPECIFIED ID
				
		for (int i = 0; i < tasks.size(); ++i) {
			Task current = tasks.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// DELETE CONTACT
				tasks.remove(current);
				break; // mission accomplished
				// exit the for loop
			}
		}
	}
	
	// NOW
	// we must be able to update certain attributes
	// name
	// desc
	public static void updateName(String ID, String newName) {
		
		// go through
		// one-by-one
		// our tasks arraylist of task objs
		// and find our id we are looking for
		for (int i = 0; i < tasks.size(); ++i) {
			Task current = tasks.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// UPDATE THE NAME
				current.setName(newName);
				break; // mission accomplished
				// exit the for loop
			}
		}
		
	}
	
	// now for updating desc of task
	public static void updateDesc(String ID, String newDesc) {
		
		// go through
		// one-by-one
		// our tasks arraylist of task objs
		// and find our id we are looking for
		for (int i = 0; i < tasks.size(); ++i) {
			Task current = tasks.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// UPDATE THE NAME
				current.setDesc(newDesc);
				break; // mission accomplished
				// exit the for loop
			}
		}
		
	}
	
	// NOW AS FOR TESTING, WHAT IS THE ONLY other
	// THING THAT should THROW AN EXCEPTION?
	// ON THE OFF CHANCE THAT TWO IDS ARE ALIKE
	// THIS should THROW AN EXCEPTION
		
	// SO WE WILL CREATE A FUNCTION
	// WITH THE PURPOSE OF ADDING A TASK
	// TWICE WITH THE SAME ID
	public static void addTaskForTest(String ID,
				String name, String desc) {
		
		// CREATE NEW TASK
		Task task = new Task(ID, name, desc);
			
		for (int i = 0; i < tasks.size(); ++i) {
			Task current = tasks.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A DUPLICATE
				// AND WE CAUGHT IT BEFORE
				// ADDING TO OUR ARRAYLIST
				throw new IllegalArgumentException(
						"ID DUPLICATE - TRY AGAIN");
			}
		}
			
		// ADD TASK TO OUR TASK ARRAYLIST 'tasks'
		tasks.add(task);
			
	}
}

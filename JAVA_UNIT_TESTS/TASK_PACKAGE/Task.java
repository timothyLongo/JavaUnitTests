// TIMOTHY LONGO

// CS-320

// ASSIGNMENT 4-1

// 1 / 26 / 2024



package TASK_PACKAGE;

public class Task {

	private
		// SHAN'T BE LONGER THAN 10 CHAR
		// SHAN'T BE NULL
		// SHAN'T BE UPDATED EVER
		String taskID;
		// SHAN'T BE LONGER THAN 20 CHAR
		// SHAN'T BE NULL
		String name;
		// SHAN'T BE LONGER THAN 50 CHAR
		// SHAN'T BE NULL
		String desc;
	
	// default constructor
	public Task(String taskID, String name, String desc) {
		
		// now for our check points
		// we call the authorities if any
		// attempt to pass with illegal contraband
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("invalid ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("invalid name");
		}
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("invalid desc");
		}
		
		// if subject passed our checkpoints
		// and our frisk
		// he may then proceed
		this.taskID = taskID;
		this.name = name;
		this.desc = desc;
	}
	
	
	// NOW we do our setters 'n' getters
	
	// SETTERS *** EXCEPT ID, THAT IS NOT TO BE UPDATED
	public void setName(String name) {
		if (taskID == null || name.length() > 20) {
			throw new IllegalArgumentException("invalid name");
		}
		this.name = name;
	}
	public void setDesc(String desc) {
		if (taskID == null || desc.length() > 50) {
			throw new IllegalArgumentException("invalid desc");
		}
		this.desc = desc;
	}
	
	// NOW OUR GETTERS
	public String getID() {
		return taskID;
	}
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	
	// it's a-vedy niiece
}

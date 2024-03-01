package APPT_PACKAGE;

import java.util.Date;

public class Appointment {

	
	private
		// SHAN'T BE LONGER THAN 10 CHAR
		// SHAN'T BE NULL
		// SHAN'T BE UPDATABLE
		String ID;
		// SHAN'T BE IN PAST
		// SHAN'T BE NULL
		Date date;
		// SHAN'T BE LONGER THAN 50 CHAR
		// SHAN'T BE NULL
		String desc;
		
		
		
	// DEFAULT CONSTRUCTOR

	public Appointment(String ID, Date date, String desc) {
		
		if (ID == null || ID.length()>10) {
			throw new IllegalArgumentException("invalid ID");
		}
		Date today = new Date(); 
		if (date == null || date.before(today)) {
			throw new IllegalArgumentException("invalid Date");
		}
		if (desc == null || desc.length()>50) {
			throw new IllegalArgumentException("invalid Desc");
		}
		
		// IF THOU IS WORTHY. . .
		
		this.ID = ID;
		this.date = date;
		this.desc = desc;
			
		// WE GRANT LIFE
	}
	
	// NOW OUR SETTERS 'N' GETTERS
	
	// SETTERS WITHOUT ID
	// AS IS SHAN'T BE UPDATABLE
	public void setDate(Date date) {
		Date today = new Date(); 
		if (date == null || date.before(today)) {
			throw new IllegalArgumentException("invalid Date");
		}
		// OTHERWISE
		this.date = date;
	}
	public void setDesc(String desc) {
		if (desc == null || desc.length()>50) {
			throw new IllegalArgumentException("invalid Desc");
		}
		// OTHERWISE
		this.desc = desc;
	}
	
	// NOW GETTERS
	public String getID() {
		return ID;
	}
	public Date getDate() {
		return date;
	}
	public String getDesc() {
		return desc;
	}

}


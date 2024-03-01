package APPT_PACKAGE;

import java.util.ArrayList; // import the ArrayList class
import java.util.Date;


public class AppointmentService {

	// REQUIREMENTS
	
	//   [ 1 ]  -----> SHALL BE ABLE TO ADD APPTS WITH UNIQUE ID
	//   [ 2 ]  -----> SHALL BE ABLE TO DELETE APPTS PER ID
	
	// SO WE NEED AN ARRAYLIST TO HOLD THESE
	// OBJS FIRST
	// DONE
	
	// NOW WE WE INITIALIZE THIS
	public static ArrayList<Appointment> apts =
			new ArrayList<Appointment>();
			
	
	// NOW WE NEED WAY TO GENERATE THE ID
	public static String generateID() {
		// generate random sequence of 10 char number
		long number = (long) Math.floor(Math.random()
				* 9_000_000_000L) + 1_000_000_000L;
		
		// convert number to string as per requirement
		String uniqueID = Long.toString(number);
		return uniqueID;
	}
	// GOT IT
	
	// NOW FOR REQUIREMENT 1
	public static void addAppointment(Date date,
			String desc) {
		
		// PULL FROM OUR 'generateID' function
		// for the new contact's ID
		String ID = generateID();
		
		// CREATE NEW APPOINTMENT
		Appointment appointment = new Appointment(ID,
				date, desc);
		
		// ACCOUNTING FOR THE INCREDIBLY RARE CASE
		// OF DUPLICATE IDS
		// WE TEST AND CATCH IT BEFORE WE ADD IT
		// AND BEFORE WE GO ANY FURTHER
		for (int i = 0; i < apts.size(); ++i) {
			Appointment current = apts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A DUPLICATE
				// AND WE CAUGHT IT BEFORE
				// ADDING TO OUR ARRAYLIST
				throw new IllegalArgumentException("ID DUPLICATE - TRY AGAIN");
			}
		}
		
		// ADD APPOINTMENT TO OUR
		// APPOINTMENT ARRAYLIST 'apts'
		apts.add(appointment);
	}
	
	
	// NOW FOR REQUIREMENT 2
	public static void deleteAppointment(String ID) {
		
		// FIND THE APPOINTMENT
		// WITHIN OUR ARRAYLIST
		// WITH THE ID
		
		// FIRST FIND INDEX OF OUR APPOINTMENT
		// WITH THE SPECIFIED ID
		
		for (int i = 0; i < apts.size(); ++i) {
			Appointment current = apts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// DELETE CONTACT
				apts.remove(current);
				break; // mission accomplished
				// exit the for loop
			}
		}
	}
	
	public static void addAppointmentForTest(String ID,
			Date date,
			String desc) {
	
		// CREATE NEW APPOINTMENT
		Appointment appointment = new Appointment(ID,
				date,
				desc);
		
		for (int i = 0; i < apts.size(); ++i) {
			Appointment current = apts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A DUPLICATE
				// AND WE CAUGHT IT BEFORE
				// ADDING TO OUR ARRAYLIST
				throw new IllegalArgumentException("ID DUPLICATE - TRY AGAIN");
			}
		}
		
		// ADD CONTACT TO OUR CONTACT ARRAYLIST 'contacts'
		apts.add(appointment);
		
	}
	
}

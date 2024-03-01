// TIMOTHY LONGO

// CS-320

// ASSIGNMENT 3-2

// 1 / 19 / 2024



package CONTACT_SERVICE_PACKAGE;

// okay we aren't using a database here
// and we need to hold the data for our
// contacts
// we will use ArrayList or Vector for this
// we must import the use of this

import java.util.ArrayList; // import the ArrayList class


public class ContactService {
	// arrayList of type 'Contact' objects
	// we declare the name of the arrayList as 'contacts'
	// and we create/ initialize the arrayList as empty
	// with 'new ArrayList of type 'Contact' objects () '
	public static ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	// REQUIREMENT -> THE CONTACT SERVICE SHALL BE ABLE
	// TO ADD CONTACTS WITH A UNIQUE ID
	// now we must be able to generate unique ID
	// for the contact when it's added
	
	
	public static String generateID() {
		// generate random sequence of 10 char number
		long number = (long) Math.floor(Math.random()
				* 9_000_000_000L) + 1_000_000_000L;
		
		// convert number to string as per requirement
		String uniqueID = Long.toString(number);
		return uniqueID;
	}
	
	public static void addContact(String firstName,
			String lastName, String phone, String address) {
		
		// PULL FROM OUR 'generateID' function
		// for the new contact's ID
		String ID = generateID();
		
		// CREATE NEW CONTACT
		Contact contact = new Contact(ID, firstName,
				lastName, phone, address);
		
		// ACCOUNTING FOR THE INCREDIBLY RARE CASE
		// OF DUPLICATE IDS
		// WE TEST AND CATCH IT BEFORE WE ADD IT
		// AND BEFORE WE GO ANY FURTHER
		for (int i = 0; i < contacts.size(); ++i) {
			Contact current = contacts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A DUPLICATE
				// AND WE CAUGHT IT BEFORE
				// ADDING TO OUR ARRAYLIST
				throw new IllegalArgumentException("ID DUPLICATE - TRY AGAIN");
			}
		}
		
		// ADD CONTACT TO OUR CONTACT ARRAYLIST 'contacts'
		contacts.add(contact);
	}
	
	
	// REQUIREMENT -> 'THE CONTACT SERVICE SHALL BE ABLE
	// TO DELETE CONTACTS **PER CONTACT ID**
	
	public static void deleteContact(String ID) {
		
		// FIND THE CONTACT
		// WITHIN OUR ARRAYLIST
		// WITH THE ID
		
		// FIRST FIND INDEX OF OUR CONTACT
		// WITH THE SPECIFIED ID
		
		for (int i = 0; i < contacts.size(); ++i) {
			Contact current = contacts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// DELETE CONTACT
				contacts.remove(current);
				break; // mission accomplished
				// exit the for loop
			}
		}
		
	}
	
	// REQUIREMENT --> THE CONTACT SERVICE SHALL
	// BE ABLE TO *UPDATE* CONTACT FIELDS
	// **PER CONTACT ID**
	// **** EVERY ATTRIBUTE EXCEPT ID
	
	public static void updateFirstName(String ID,
			String newFirstName) {
		
		for (int i = 0; i < contacts.size(); ++i) {
			Contact current = contacts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// UPDATE THE FIRST NAME
				current.setFirstName(newFirstName);
				break; // mission accomplished
				// exit the for loop
			}
		}
		
	}
	
	public static void updateLastName(String ID,
			String newLastName) {
		
		for (int i = 0; i < contacts.size(); ++i) {
			Contact current = contacts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// UPDATE THE LAST NAME
				current.setLastName(newLastName);
				break; // mission accomplished
				// exit the for loop
			}
		}
	}
	
	public static void updatePhone(String ID,
			String newPhone) {
		
		for (int i = 0; i < contacts.size(); ++i) {
			Contact current = contacts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// UPDATE THE LAST NAME
				current.setPhone(newPhone);
				break; // mission accomplished
				// exit the for loop
			}
		}
	}
	
	public static void updateAddress(String ID,
			String newAddress) {
		
		for (int i = 0; i < contacts.size(); ++i) {
			Contact current = contacts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A MATCH
				// UPDATE THE LAST NAME
				current.setAddress(newAddress);
				break; // mission accomplished
				// exit the for loop
			}
		}
	}
	
	
	// NOW AS FOR TESTING, WHAT IS THE ONLY
	// THING THAT should THROW AN EXCEPTION?
	// ON THE OFF CHANCE THAT TWO IDS ARE ALIKE
	// THIS should THROW AN EXCEPTION
	
	// SO WE WILL CREATE A FUNCTION
	// WITH THE PURPOSE OF ADDING A CONTACT
	// TWICE WITH THE SAME ID
	public static void addContactForTest(String ID,
			String firstName,
			String lastName, String phone,
			String address) {
	
		// CREATE NEW CONTACT
		Contact contact = new Contact(ID, firstName,
				lastName, phone, address);
		
		for (int i = 0; i < contacts.size(); ++i) {
			Contact current = contacts.get(i);
			String id = current.getID();
			if (id == ID) {
				// NOW WE FOUND A DUPLICATE
				// AND WE CAUGHT IT BEFORE
				// ADDING TO OUR ARRAYLIST
				throw new IllegalArgumentException("ID DUPLICATE - TRY AGAIN");
			}
		}
		
		// ADD CONTACT TO OUR CONTACT ARRAYLIST 'contacts'
		contacts.add(contact);
		
	}

}

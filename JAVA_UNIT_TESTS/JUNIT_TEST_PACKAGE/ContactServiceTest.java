// TIMOTHY LONGO

// CS-320

// ASSIGNMENT 3-2

// 1 / 19 / 2024



package JUNIT_TEST_PACKAGE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CONTACT_SERVICE_PACKAGE.Contact;
import CONTACT_SERVICE_PACKAGE.ContactService;

class ContactServiceTest {

	// ASSERTIONS THAT OUR CONTACT SERVICE FUNCTIONS
	// AS IT SHOULD
	
	// WE WILL TEST EACH FUNCTION TO MAKE CERTAIN
	// THAT WE YEILD THE RESULT WE'RE LOOKING FOR
	
	// FIRST TEST
	// ADDING CONTACT SHOULD RESULT IN
	// ARRAYLIST HOLDING THAT CONTACT
	@Test
	void TestContactServiceAddAndDeleteContact() {
		// TEST FOR ADDING CONTACT
		ContactService.addContact("John", "Doe", "6312428242",
						"1 Sycamore Lane FairyLand");
		Contact current = ContactService.contacts.get(0);
		assertTrue(current.getFirstName().equals("John"));
		
		// TEST FOR DELETING CONTACT
		String id = current.getID();
		ContactService.deleteContact(id);
		assertTrue(ContactService.contacts.size() == 0);
	}
	
	// NOW FOR THE UPDATE METHOD TESTS
	@Test
	void TestContactServiceUpdates() {

		ContactService.addContact("John", "Doe", "6312428242",
						"1 Sycamore Lane FairyLand");
		Contact current = ContactService.contacts.get(0);

		String id = current.getID();
		
		// UPDATE FIRST NAME TEST
		ContactService.updateFirstName(id,
				"Jaine");
		assertTrue(current.getFirstName().equals("Jaine"));
		
		// UPDATE LAST NAME TEST
		ContactService.updateLastName(id,
						"Fowler");
		assertTrue(current.getLastName().equals("Fowler"));
		
		// UPDATE PHONE TEST
		ContactService.updatePhone(id,
								"9102546855");
		assertTrue(current.getPhone().equals("9102546855"));
		
		// UPDATE ADDRESS TEST
		ContactService.updateAddress(id,
								"33 Rosey Lane");
		assertTrue(current.getAddress().equals("33 Rosey Lane"));
	}
	
	
	// NOW FOR THE INCREDIBLY INCREDIBLY (TWICE FOR EMPHASIS) RARE
	// OFF CHANCE THAT 2 IDS ARE ALIKE
	@Test
	void TestContactServiceDuplicateIDs() {
		
		ContactService.addContactForTest("0123456789",
				"John",
				"Doe",
				"6312428242",
				"1 Sycamore Lane FairyLand");
		
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					ContactService.addContactForTest("0123456789",
							"John",
							"Doe",
							"6312428242",
							"1 Sycamore Lane FairyLand");
				});
		
	}

}

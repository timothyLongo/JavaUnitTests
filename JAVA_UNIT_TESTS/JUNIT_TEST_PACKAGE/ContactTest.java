// TIMOTHY LONGO

// CS-320

// ASSIGNMENT 3-2

// 1 / 19 / 2024



package JUNIT_TEST_PACKAGE;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CONTACT_SERVICE_PACKAGE.Contact;

class ContactTest {

	@Test
	void testContact() {
		
		// CREATE DUMMY CONTACT OBJ FOR TEST
		Contact contact = new Contact("0123456789",
				"John", "Doe", "6312428242",
				"1 Sycamore Lane FairyLand");
		
		// NOW WE MAKE CERTAIN
		// OBJ ATTRIBUTES ARE, IN FACT, ASSIGNED
		assertTrue(contact.getID().equals("0123456789"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getPhone().equals("6312428242"));
		assertTrue(contact.getAddress().equals(
				"1 Sycamore Lane FairyLand"));
	}
	
	// ID TESTS
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("01234567891111111111111111",
							"John", "Doe", "6312428242",
							"1 Sycamore Lane FairyLand");
				});
	}
	@Test
	void testContactIDNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact(null,
							"John", "Doe", "6312428242",
							"1 Sycamore Lane FairyLand");
				});
	}
	
	// FIRST NAME TESTS
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							"JohnJohnJohnJohnJohnJohnJohnJohn",
							"Doe", "6312428242",
							"1 Sycamore Lane FairyLand");
				});
	}
	@Test
	void testContactFirstNameNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							null, "Doe", "6312428242",
							"1 Sycamore Lane FairyLand");
				});
	}
	
	// LAST NAME TESTS
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							"John", "DoeDoeDoeDoeDoeDoeDoeDoe",
							"6312428242",
							"1 Sycamore Lane FairyLand");
				});
	}
	@Test
	void testContactLastNameNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							"John", null,
							"6312428242",
							"1 Sycamore Lane FairyLand");
				});
	}
	
	// PHONE TESTS
	@Test
	void testContactPhoneNot10char() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							"John", "Doe",
							"631242824",
							"1 Sycamore Lane FairyLand");
				});
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							"John", "Doe",
							"63124282423",
							"1 Sycamore Lane FairyLand");
				});
	}
	@Test
	void testContactPhoneNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							"John", "Doe",
							null,
							"1 Sycamore Lane FairyLand");
				});
	}
	
	// ADDRESS TESTS
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							"John", "Doe",
							"6312428242",
							"1 Sycamore Lane FairyLand AND" +
							"THIS WILL MAKE IT MUCH TOO LONG");
				});
	}
	@Test
	void testContactAddressNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Contact("0123456789",
							"John", "Doe",
							"6312428242",
							null);
				});
	}

}

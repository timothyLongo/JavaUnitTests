// TIMOTHY LONGO

// CS-320

// ASSIGNMENT 3-2

// 1 / 19 / 2024



package CONTACT_SERVICE_PACKAGE;

public class Contact {
	
	private
		// ID no longer than 10 char
		// cannot be NULL
		// shan't! be updated ever
		String ID;
	    // firstName no longer than 10 char
		// shan't be NULL
		String firstName;
		// lastName no longer than 10 char
		// shan't be NULL
		String lastName;
		// phone must be EXACTLY 10 DIGITS
		// shan't be NULL
		String phone;
		// address shan't be longer than 30 char
		// shan't be NULL
		String address;
	
		
	// default constructor
	public Contact(String ID, String firstName, String lastName
			, String phone, String address) {
		
		if (ID == null || ID.length()>10) {
			throw new IllegalArgumentException("invalid ID");
		}
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("invalid first name");
		}
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("invalid last name");
		}
		if (phone == null || phone.length()!=10) {
			throw new IllegalArgumentException("invalid phone number");
		}
		if (phone != null && phone.length() == 10) {
			// if it passed the null and length parameters
			// now we test for if it contains digits
			// simply with testing if each character is a digit
			// with java's built-in isDigit() function
			for (int i = 0; i < phone.length(); ++i) {
				if (!Character.isDigit(phone.charAt(i))) {
					throw new IllegalArgumentException("invalid phone number");
				}
			}
		}
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("invalid address");
		}
		// NOW --
		// IF IT PASSED ALL THE TESTS
		// AND CAME UP WITH THE CORRECT
		// ANSWERS TO ALL OUR RIDDLES
		// THOU. . . well. . . thou shall pass
		
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// NOW let's add some setters 'n' getters if
	// memory serves on how these JAVA classes ought to be
	
	public String getID() {
		return ID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// NOW OUR SETTERS
	// EXCEPT
	// FOR ID -- WHICH SHAN'T BE UPDATABLE
	
	public void setFirstName(String firstName) {
		// add our requirements as well for the setter methods
		// as well as the default constructor
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("invalid first name");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("invalid last name");
		}
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		if (phone == null || phone.length()!=10) {
			throw new IllegalArgumentException("invalid phone number");
		}
		if (phone != null && phone.length() == 10) {
			// if it passed the null and length parameters
			// now we test for if it contains digits
			// simply with testing if each character is a digit
			// with java's built-in isDigit() function
			for (int i = 0; i < phone.length(); ++i) {
				if (!Character.isDigit(phone.charAt(i))) {
					throw new IllegalArgumentException("invalid phone number");
				}
			}
		}
		this.phone = phone;
	}
	public void setAddress(String address) {
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("invalid address");
		}
		this.address = address;
	}
	

	// FINITO
	
}

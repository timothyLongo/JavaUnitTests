package TEST_APPT_PACKAGE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import APPT_PACKAGE.Appointment;


import java.util.Date;

class AppointmentTest {

	@Test
	void testAppointment() {
		
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() +
				(1000*60*60*24));
		// CREATE DUMMY APPOINTMENT OBJ FOR TEST
		Appointment appointment = new Appointment("0123456789",
				tomorrow, "desc here");
		
		// NOW WE MAKE CERTAIN
		// OBJ ATTRIBUTES ARE, IN FACT, ASSIGNED
		assertTrue(appointment.getID().equals("0123456789"));
		assertTrue(appointment.getDate() == tomorrow);
		assertTrue(appointment.getDesc().equals("desc here"));

	}
	
	// ID TESTS
	@Test
	void testAppointmentIDTooLong() {
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() +
				(1000*60*60*24));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Appointment("01234567891111111111111111",
								tomorrow, "desc here");
				});
	}
	@Test
	void testAppointmentIDNULL() {
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() +
				(1000*60*60*24));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Appointment(null,
								tomorrow, "desc here");
				});
	}
	
	
	// DATE TESTS
	@Test
	void testAppointmentDateInPast() {
		Date today = new Date();
		Date yesterday = new Date(today.getTime() -
				(1000*60*60*24));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Appointment("0123456789",
								yesterday,
								"desc here");
				});
	}
	@Test
	void testAppointmentDateNULL() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Appointment("0123456789",
								null,
								"desc here");
				});
	}
	
	
	// DESC TESTS
	@Test
	void testAppointmentDescTooLong() {
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() +
				(1000*60*60*24));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Appointment("0123456789",
								tomorrow,
								"desc here desc here desc here"
								+ "desc here desc here desc here"
								+ "desc here desc here desc here"
								+ "desc here desc here desc here"
								+ "desc here desc here desc here");
				});
	}
	@Test
	void testAppointmentDescNULL() {
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() +
				(1000*60*60*24));
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					new Appointment("0123456789",
								tomorrow,
								null);
				});
	}

}

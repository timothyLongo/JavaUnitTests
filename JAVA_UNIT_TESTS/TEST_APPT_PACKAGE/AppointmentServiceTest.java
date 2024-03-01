package TEST_APPT_PACKAGE;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import APPT_PACKAGE.Appointment;
import APPT_PACKAGE.AppointmentService;



class AppointmentServiceTest {

	@Test
	void TestAppointmentServiceAddAndDeleteAppointment() {
		AppointmentService.apts.clear();
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() +
				(1000*60*60*24));
		// TEST FOR ADDING APPOINTMENT
		AppointmentService.addAppointment(
				tomorrow, "desc here");
		Appointment current = AppointmentService.apts.get(0);
		// NOW WE TEST THAT IT IS
		// 1 -> IN FACT, AN OBJ IN OUR ARRAYLIST 
		// 2 -> ATTRIBUTES ARE WHAT WE SET THEM TO BE
		assertTrue(current.getDate() == tomorrow);
		assertTrue(current.getDesc().equals("desc here"));
		
		
		// TEST FOR DELETING APPOINTMENT
		String id = current.getID();
		AppointmentService.deleteAppointment(id);
		assertTrue(AppointmentService.apts.size() == 0);
	}
	
	// NOW FOR THE INCREDIBLY INCREDIBLY (TWICE FOR EMPHASIS) RARE
	// OFF CHANCE THAT 2 IDS ARE ALIKE
	@Test
	void TestAppointmentServiceDuplicateIDs() {
		
		AppointmentService.apts.clear();
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() +
				(1000*60*60*24));
		AppointmentService.addAppointmentForTest("0123456789",
					tomorrow,
					"desc here");
			
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					AppointmentService.addAppointmentForTest(
							"0123456789",
							tomorrow,
							"desc here");
				});
	}

}

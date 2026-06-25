package cattopia;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ShelterTest {

    private Shelter shelter;

    @Before
    public void setUp() {
        shelter = new Shelter();
    }

    @Test
    public void testSetGetShelterName() {
        shelter.setShelterName("Shelter Name");
        assertEquals("Shelter Name", shelter.getShelterName());
    }

    @Test
    public void testSetGetVerification() {
        shelter.setVerification(true);
        assertTrue(shelter.isVerification());
    }

    @Test
    public void testSetGetRecievedDonation() {
        ArrayList<String> donations = new ArrayList<>();
        donations.add("Food");
        donations.add("Money");
        shelter.setRecievedDonation(donations);
        assertEquals(2, shelter.getRecievedDonation().size());
        assertTrue(shelter.getRecievedDonation().contains("Food"));
    }

    @Test
    public void testSetGetReservedAppointment() {
        ArrayList<Appointment> appointments = new ArrayList<>();
       Appointment app1 = new Appointment("2025-05-01", "shahd", "shelter01", "Morning");
       Appointment app2 = new Appointment("2025-05-02", "doaa", "shelter02", "Morning");
       
        appointments.add(app1);
        appointments.add(app2);

        shelter.setReservedAppointment(appointments);
        assertEquals(2, shelter.getReservedAppointment().size());
        assertEquals("shahd", shelter.getReservedAppointment().get(0).getNewOwnerID());
    }

    @Test
    public void testSearchAppointmentExists() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        Appointment appt = new Appointment("2025-05-01", "shahd", "shelter01", "Morning");
        appointments.add(appt);
        shelter.setReservedAppointment(appointments);
        Appointment result = shelter.searchAppointment("2025-05-01");
        assertNotNull(result);
        assertEquals("shahd", result.getNewOwnerID());
    }

    @Test
    public void testSearchAppointmentNotExists() {
       ArrayList<Appointment> appointments = new ArrayList<>();
        Appointment appt = new Appointment("2025-05-01", "shahd", "shelter01", "Morning");
        appointments.add(appt);
        shelter.setReservedAppointment(appointments);
        Appointment result = shelter.searchAppointment("2025-02-22");
        assertNull(result);
    }
}

package cattopia;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    ArrayList<String> ownedCats;
    ArrayList<String> donateTo;

    @BeforeEach
    void setUp() {
        ownedCats = new ArrayList<>(List.of("cat1", "cat2"));
        donateTo = new ArrayList<>(List.of("shelter1"));
        user = new User("u1", "Alice", "New York", "alice@example.com", ownedCats, donateTo);
    }

    @Test
    void testCreateUserWithValidData() {
        ArrayList<String> ownedCats = new ArrayList<>();
        ownedCats.add("Cat001");
        ArrayList<String> donateTo = new ArrayList<>();
        donateTo.add("Shelter001");

        User user = new User("U001", "Alice", "NYC", "alice@email.com", ownedCats, donateTo);

        assertEquals("U001", user.getUserID());
        assertEquals("Alice", user.getName());
        assertEquals("NYC", user.getLocation());
        assertEquals("alice@email.com", user.getContactInfo());
        assertEquals(ownedCats, user.getOwenedCats());
        assertEquals(donateTo, user.getDonateTo());
    }

    @Test
    void testInvalidUserData() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new User(null, "", "", "", null, null);
        });
        assertEquals("Invalid user data: User ID, name, location, contact info, owned cats, and donate to list cannot be null or empty", exception.getMessage());
    }

    @Test
    void testContactInfoToEmpty() {
        User user = new User();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setContactInfo("   ");
        });
        assertEquals("Contact info cannot be null or empty", exception.getMessage());
    }

    @Test
    void testUserIDToNull() {
        User user = new User();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setUserID(null);
        });
        assertEquals("User ID cannot be null or empty", exception.getMessage());
    }

    @Test
    void testOwenedCatsToNull() {
        User user = new User();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setOwenedCats(null);
        });
        assertEquals("Owned cats list cannot be null", exception.getMessage());
    }

    @Test
    void testOfferCat() {
        ArrayList<Cat> cats = new ArrayList<>();
        User user = new User();
        Cat newCat = new Cat(1, "u1", "Whiskers", "Male", 3, "Siamese", null, "Friendly", false, "None", true, true, "Available", "Moving", null, 100);
    
        user.OfferCat(cats, newCat);
    
        assertEquals(1, cats.size());
        assertEquals("Whiskers", cats.get(0).getCatName());
        assertEquals("Available", cats.get(0).getAdoptionState());
    }
    
    @Test
    void testAdoptionApprove() {
        Cat cat = new Cat(1, "u1", "Whiskers", "Male", 3, "Siamese", null, "Friendly", false, "None", true, true, "Pending", "Moving", null, 100);
    
        User.adoptionApprove(cat);
    
        assertEquals("Adopted", cat.getAdoptionState());
    }

    @Test
    void testAdoptionCancel() {
        Cat cat = new Cat(1, "u1", "Whiskers", "Male", 3, "Siamese", null, "Friendly", false, "None", true, true, "Pending", "Moving", null, 100);
    
        User.adoptionCancel(cat);
    
        assertEquals("Available", cat.getAdoptionState());
    }


}

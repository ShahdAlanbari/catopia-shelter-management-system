package cattopia;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CatTest {

    private Cat testCat;
    private ArrayList<Cat> catDatabase;

    @BeforeEach
    void setUp() {
        testCat = new Cat(1, "owner1", "Whiskers", "Male", 3, "Siamese", null,
                "Friendly", false, "None", true, true,
                "Available", "Moving", new ArrayList<>(), 100);

        catDatabase = new ArrayList<>();
        catDatabase.add(testCat);
        catDatabase.add(new Cat(2, "owner2", "Mittens", "Female", 5, "Persian", null,
                "Shy", true, "Allergy", false, true,
                "Adopted", "Allergic owner", new ArrayList<>(), 120));
    }

    @Test
    void testGettersAndSetters() {
        testCat.setCatName("Snowball");
        assertEquals("Snowball", testCat.getCatName());
        
        testCat.setAge(4);
        assertEquals(4, testCat.getAge());
        
        testCat.setDisabled(true);
        assertTrue(testCat.isDisabled());
    }

    @Test
    void testFilterByBreedPositive() {
        List<Cat> filtered = Cat.FilterByBreed("Siamese", catDatabase);
        assertEquals(1, filtered.size());
        assertEquals("Whiskers", filtered.get(0).getCatName());
    }

    @Test
    void testFilterByBreedNegative() {
        assertTrue(Cat.FilterByBreed("Unknown", catDatabase).isEmpty());
    }

    @Test
    void testFilterByAgePositive() {
        List<Cat> filtered = Cat.FilterByAge(3, catDatabase);
        assertEquals(1, filtered.size());
        assertEquals(3, filtered.get(0).getAge());
    }
    
    @Test
    void testFilterByAgeNegative() {
        assertTrue(Cat.FilterByAge(100, catDatabase).isEmpty());
    }

    @Test
    void testFilterByGenderPositive() {
        List<Cat> filtered = Cat.FilterByGender("Female", catDatabase);
        assertEquals(1, filtered.size());
        assertEquals("Mittens", filtered.get(0).getCatName());
    }
    
    @Test
    void testFilterByGenderNegative() {
        assertTrue(Cat.FilterByGender("UnknownGender", catDatabase).isEmpty());
    }

    @Test
    void testCatConstructorWithNegativeAgeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cat(1, "owner1", "Fluffy", "Female", -1, "Persian",
                    null, "Playful", false, "Healthy",
                    true, true, "Available", "Too many cats", new ArrayList<>(), 100);
        });

        assertEquals("Age cannot be negative", exception.getMessage());
    }

    @Test
    void testCatConstructorWithNullNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cat(2, "owner2", null, "Male", 2, "Siamese",
                    null, "Calm", false, "None",
                    true, true, "Available", "Moving abroad", new ArrayList<>(), 50);
        });

        assertEquals("Cat name cannot be null", exception.getMessage());
    }

    @Test
    void testFilterCatsIntegration() {
        // Setup: Create a list of cats
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, "u1", "Mittens", "Female", 3, "Persian", null, "Friendly", false, "None", true, true, "Available", "Moving", new ArrayList<>(), 150));
        cats.add(new Cat(2, "u2", "Snowball", "Male", 2, "Siamese", null, "Playful", false, "None", true, true, "Available", "Moving abroad", new ArrayList<>(), 200));

        // Action: Filter cats by breed
        ArrayList<Cat> filteredCats = Cat.FilterByBreed("Persian", cats);

        // Assertions
        assertEquals(1, filteredCats.size(), "The filtered list should contain one cat.");
        assertEquals("Mittens", filteredCats.get(0).getCatName(), "The filtered cat's name should be 'Mittens'.");
    }

    @Test
    void testOfferCatIntegration() {
        // Setup: Create a user and a list of cats
        ArrayList<Cat> cats = new ArrayList<>();
        User user = new User("u1", "Alice", "New York", "alice@example.com", new ArrayList<>(), new ArrayList<>());
    
        // Action: User offers a new cat for adoption
        Cat newCat = new Cat(2, "u1", "Snowball", "Male", 2, "Siamese", null, "Playful", false, "None", true, true, "Available", "Moving abroad", new ArrayList<>(), 200);
        user.OfferCat(cats, newCat);
    
        // Assertions
        assertEquals(1, cats.size(), "The cat list should contain one cat.");
        assertEquals("Snowball", cats.get(0).getCatName(), "The cat's name should be 'Snowball'.");
        assertEquals("Available", cats.get(0).getAdoptionState(), "The cat's adoption state should be 'Available'.");
    }

}

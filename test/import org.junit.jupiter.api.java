import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

// filepath: c:\Users\Saudi Gamerz\Desktop\Catopia-master\Catopia-master\src\cattopia\UserTest.java
package cattopia;


public class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setUserID("123");
        user.setName("John Doe");
        user.setLocation("New York");
        user.setContactInfo("123456789");
        ArrayList<String> ownedCats = new ArrayList<>();
        ownedCats.add("Cat1");
        user.setOwenedCats(ownedCats);
        ArrayList<String> donateTo = new ArrayList<>();
        donateTo.add("Shelter1");
        user.setDonateTo(donateTo);

        assertEquals("123", user.getUserID());
        assertEquals("John Doe", user.getName());
        assertEquals("New York", user.getLocation());
        assertEquals("123456789", user.getContactInfo());
        assertEquals(ownedCats, user.getOwenedCats());
        assertEquals(donateTo, user.getDonateTo());
    }

    @Test
    public void testAdoptionReqConditionsMet() {
        Cat cat = new Cat();
        cat.setLikesCats(true);
        cat.setLikesChildrens(false);

        Individual user = new Individual(true, false, "123", "John", "NY", "123456789", new ArrayList<>(), new ArrayList<>());
        User owner = new Individual(false, false, "456", "Jane", "LA", "987654321", new ArrayList<>(), new ArrayList<>());

        User.adoptionReq(cat, user, owner);
        assertEquals("Pending", cat.getAdoptionState());
    }

    @Test
    public void testAdoptionReqConditionsNotMet() {
        Cat cat = new Cat();
        cat.setLikesCats(false);
        cat.setLikesChildrens(true);

        Individual user = new Individual(true, false, "123", "John", "NY", "123456789", new ArrayList<>(), new ArrayList<>());
        User owner = new Individual(false, false, "456", "Jane", "LA", "987654321", new ArrayList<>(), new ArrayList<>());

        User.adoptionReq(cat, user, owner);
        assertNotEquals("Pending", cat.getAdoptionState());
    }

    @Test
    public void testAdoptionApprove() {
        Cat cat = new Cat();
        User.adoptionApprove(cat);
        assertEquals("Adopted", cat.getAdoptionState());
    }

    @Test
    public void testAdoptionCancel() {
        Cat cat = new Cat();
        User.adoptionCancel(cat);
        assertEquals("Available", cat.getAdoptionState());
    }

    @Test
    public void testOfferCat() {
        ArrayList<Cat> cats = new ArrayList<>();
        User user = new User();
        user.OfferCat(cats);

        assertFalse(cats.isEmpty());
        assertNotNull(cats.get(0));
    }

    @Test
    public void testFilterCatsByBreed() {
        ArrayList<Cat> cats = new ArrayList<>();
        Cat cat1 = new Cat();
        cat1.setBreed("Persian");
        cats.add(cat1);

        Cat cat2 = new Cat();
        cat2.setBreed("Siamese");
        cats.add(cat2);

        ArrayList<Cat> filtered = Cat.FilterByBreed("Persian", cats);
        assertEquals(1, filtered.size());
        assertEquals("Persian", filtered.get(0).getBreed());
    }

    @Test
    public void testFilterCatsByAge() {
        ArrayList<Cat> cats = new ArrayList<>();
        Cat cat1 = new Cat();
        cat1.setAge(2);
        cats.add(cat1);

        Cat cat2 = new Cat();
        cat2.setAge(5);
        cats.add(cat2);

        ArrayList<Cat> filtered = Cat.FilterByAge(2, cats);
        assertEquals(1, filtered.size());
        assertEquals(2, filtered.get(0).getAge());
    }

    @Test
    public void testDonate() {
        // Simulate donation process
        // This test can be expanded to mock user input and validate outputs
        assertDoesNotThrow(() -> User.donate());
    }
}
package cattopia;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 96656
 */
public class MoneyDonationTest {

    private MoneyDonation moneyDonation;

    public MoneyDonationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       
        moneyDonation = new MoneyDonation(100, null, LocalDate.now(), "SHAHD", "shelter455");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPrice method, of class MoneyDonation.
     */
    @Test
    public void testSetGetPriceValid() {
        moneyDonation.setPrice(200);
        assertEquals(200, moneyDonation.getPrice());
    }

    /**
     * Test setting an invalid price (e.g., 0).
     * (نحتاج نعدل الكود لاحقا ليقبل IllegalArgumentException عند القيم الغلط)
     */
  @Test(expected = IllegalArgumentException.class)
public void testSetPriceInvalidZero() {
    moneyDonation.setPrice(-6);
}

    @Test
    public void testSetPriceBoundary() {
        moneyDonation.setPrice(1); 
        assertEquals(1, moneyDonation.getPrice());
    }
   

}
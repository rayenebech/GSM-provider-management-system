
package proje;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Rayene Bech
 */
public class SubscriptionTest {
    Date startDate;
    SubscriptionPlan plan1, plan2;
    GSMProvider gsmProvider;
    Subscription subscription;
    public SubscriptionTest() throws ParseException {
        startDate = new SimpleDateFormat("MM/dd/yyyy").parse("06/15/2021");
        gsmProvider= new GSMProvider("TURKCELL");
        plan1 = new SubscriptionPlan("4GB", gsmProvider);
        plan2 = new SubscriptionPlan("5GB", gsmProvider);
        subscription = new Subscription(startDate,plan1);
    }
    
    /**
     * Test of getSubscriptionStartDate method, of class Subscription.
     */
    @Test
    public void testGetSubscriptionStartDate() throws ParseException {
        System.out.println("getSubscriptionStartDate Test");
        assertEquals(new SimpleDateFormat("MM/dd/yyyy").parse("06/15/2021"), subscription.getSubscriptionStartDate());
    }

    /**
     * Test of getSubscriptionPlan method, of class Subscription.
     */
    @Test
    public void testGetSubscriptionPlan() {
        System.out.println("getSubscriptionPlan Test");
        assertEquals(plan1, subscription.getSubscriptionPlan());
    }

    /**
     * Test of setSubscriptionStartDate method, of class Subscription.
     */
    @Test
    public void testSetSubscriptionStartDate() throws ParseException {
        System.out.println("setSubscriptionStartDate Test");
        startDate = new SimpleDateFormat("MM/dd/yyyy").parse("08/15/2021");
        subscription.setSubscriptionStartDate(startDate);
        assertEquals(startDate, subscription.getSubscriptionStartDate());
        
    }

    /**
     * Test of setSubscriptionPlan method, of class Subscription.
     */
    @Test
    public void testSetSubscriptionPlan() {
        System.out.println("setSubscriptionPlan Test");
        subscription.setSubscriptionPlan(plan2);
        assertEquals(plan2, subscription.getSubscriptionPlan());
        
        
    }
    
}

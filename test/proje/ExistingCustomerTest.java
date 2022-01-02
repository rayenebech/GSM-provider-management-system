
package proje;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @Rayene Bech
 */
public class ExistingCustomerTest {
    Date startDate;
    SubscriptionPlan plan1,plan2;
    GSMProvider gsmProvider;
    Subscription subscription,subscription2;
    ExistingCustomer customer;
    public ExistingCustomerTest() throws ParseException {
        startDate = new SimpleDateFormat("MM/dd/yyyy").parse("06/15/2021");
        gsmProvider= new GSMProvider("TURKCELL");
        plan1 = new SubscriptionPlan("4GB", gsmProvider);   
        plan2 = new SubscriptionPlan("5GB", gsmProvider);  
        subscription = new Subscription(startDate,plan1);
        subscription2 = new Subscription(startDate,plan2);
        customer =  new ExistingCustomer( subscription, "99988666");
        
        
    }


    /**
     * Test of getSubscription method, of class ExistingCustomer.
     */
    @Test
    public void testGetSubscription() {
        System.out.println("getSubscription Test");
        assertEquals(subscription, customer.getSubscription());

    }

    /**
     * Test of setSubscription method, of class ExistingCustomer.
     */
    @Test
    public void testSetSubscription() {
        System.out.println("setSubscription Test");
        customer.setSubscription(subscription2);
        assertEquals(subscription2, customer.getSubscription());
    }
    
}

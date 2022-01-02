
package proje;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rayene Bech
 */
public class GSMProviderTest {
    GSMProvider gsmProvider;
    SubscriptionPlan subscriptionPlan1, subscriptionPlan2;
    public GSMProviderTest() {
        gsmProvider= new GSMProvider("TURKCELL");
        subscriptionPlan1 = new SubscriptionPlan("4GB",gsmProvider);
        subscriptionPlan2 = new SubscriptionPlan("5GB",gsmProvider);
    }
    

    /**
     * Test of addSubscriptionPlan method, of class GSMProvider.
     */
    @Test
    public void testAddSubscriptionPlan() {

        System.out.println("addSubscriptionPlan Test");
        SubscriptionPlan subscriptionPlan = subscriptionPlan1;
        gsmProvider.addSubscriptionPlan(subscriptionPlan);
        String expected = gsmProvider.findSubscriptionPlan("4GB").getName();
        assertEquals(expected,"4GB");
    }

    
        /**
     * Test of findSubscriptionPlan method, of class GSMProvider.
     */
    @Test
    public void testFindSubscriptionPlan() {
        System.out.println("findSubscriptionPlan Test");
        gsmProvider.addSubscriptionPlan(subscriptionPlan1);
        SubscriptionPlan expResult = subscriptionPlan1;
        SubscriptionPlan result = gsmProvider.findSubscriptionPlan("4GB");
        assertEquals(expResult, result);
    }

         /**
     * Test of findSubscriptionPlan method in case it does not exist, of class GSMProvider.
     */
      @Test
    public void testNotExistFindSubscriptionPlan() {
        System.out.println("findSubscriptionPlan");
        gsmProvider.addSubscriptionPlan(subscriptionPlan1);
        
        SubscriptionPlan expResult = null;
        SubscriptionPlan result = gsmProvider.findSubscriptionPlan("5GB");
        assertEquals(expResult, result);
        
    }
    /**
     * Test of getName method, of class GSMProvider.
     */
    @Test
    public void testGetName() {
        System.out.println("getName Test");
        assertEquals(gsmProvider.getName(), "TURKCELL");

    }


  
}

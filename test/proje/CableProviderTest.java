
package proje;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rayene Bech
 */
public class CableProviderTest {
    CableProvider cableProvider;
    SubscriptionPlan subscriptionPlan1, subscriptionPlan2;
    public CableProviderTest() {
        cableProvider= new CableProvider("Local");
        subscriptionPlan1 = new SubscriptionPlan("4GB",cableProvider);
        subscriptionPlan2 = new SubscriptionPlan("5GB",cableProvider);
    }
    

    /**
     * Test of addSubscriptionPlan method, of class CableProvider.
     */
    @Test
    public void testAddSubscriptionPlan() {

        System.out.println("addSubscriptionPlan Test");
        SubscriptionPlan subscriptionPlan = subscriptionPlan1;
        cableProvider.addSubscriptionPlan(subscriptionPlan);
        String expected = cableProvider.findSubscriptionPlan("4GB").getName();
        assertEquals(expected,"4GB");
    }

    
        /**
     * Test of findSubscriptionPlan method, of class CableProvider.
     */
    @Test
    public void testFindSubscriptionPlan() {
        System.out.println("findSubscriptionPlan Test");
        cableProvider.addSubscriptionPlan(subscriptionPlan1);
        SubscriptionPlan expResult = subscriptionPlan1;
        SubscriptionPlan result = cableProvider.findSubscriptionPlan("4GB");
        assertEquals(expResult, result);
    }

         /**
     * Test of findSubscriptionPlan method in case it does not exist, of class CableProvider.
     */
      @Test
    public void testNotExistFindSubscriptionPlan() {
        System.out.println("findSubscriptionPlan");
        cableProvider.addSubscriptionPlan(subscriptionPlan1);
        
        SubscriptionPlan expResult = null;
        SubscriptionPlan result = cableProvider.findSubscriptionPlan("5GB");
        assertEquals(expResult, result);
        
    }
    /**
     * Test of getName method, of class CableProvider.
     */
    @Test
    public void testGetName() {
        System.out.println("getName Test");
        assertEquals(cableProvider.getName(), "Local");

    }


  
}

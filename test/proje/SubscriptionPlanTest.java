
package proje;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Rayene Bech
 */
public class SubscriptionPlanTest {
    String plan;
    GSMProvider gsmProvider;
    CableProvider cableProvider;
    SubscriptionPlan subscriptionPlan;
    public SubscriptionPlanTest() {
        plan= "4GB";

        gsmProvider = new GSMProvider(plan); 
        cableProvider = new CableProvider(plan);
        subscriptionPlan = new SubscriptionPlan(plan,gsmProvider );
        
    }

    /**
     * Test of getName method, of class SubscriptionPlan.
     */
    @Test
    public void testGetName() {
        System.out.println("getName Test");
        assertEquals(plan,subscriptionPlan.getName() );
    }

    /**
     * Test of setName method, of class SubscriptionPlan.
     */
    @Test
    public void testSetName() {
        System.out.println("setName Test");
        subscriptionPlan.setName("new Name");
        assertEquals("new Name",subscriptionPlan.getName() );
    }

    /**
     * Test of getServiceProvider method, of class SubscriptionPlan.
     */
    @Test
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider Test");
        assertEquals(gsmProvider,subscriptionPlan.getServiceProvider());
    }

    /**
     * Test of setServiceProvider method, of class SubscriptionPlan.
     */
    @Test
    public void testSetServiceProvider() {
        System.out.println("SetServiceProvider Test");
        subscriptionPlan.setServiceProvider(cableProvider);
        assertEquals(cableProvider,subscriptionPlan.getServiceProvider() );
    }
    
}

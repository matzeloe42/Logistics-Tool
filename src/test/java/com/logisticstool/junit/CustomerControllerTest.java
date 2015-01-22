package com.logisticstool.junit;

import com.logisticstool.logisticstool.Customer;
import com.logisticstool.logisticstool.CustomerController;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthias
 */
public class CustomerControllerTest
{
    private static CustomerController _customerController;
    
    public CustomerControllerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        _customerController = new CustomerController();
    }
    
    @After
    public void tearDown()
    {
    }

    /* Konstruktoren -------------------------------------------------------- */
    @Test
    public void testConstructor()
    {
        CustomerController customerController = new CustomerController();
        Assert.assertTrue("correct Constructor", customerController != null);
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSelected()
    {
        Customer selected = new Customer(42, "Max", "Mustermann");
        _customerController.setSelected(selected);
        Assert.assertTrue
        (
            "correct setSelected",
            _customerController.getSelected().getCustomerID() == selected.getCustomerID()
        );
    }
    
    @Test
    public void testGetItems()
    {
        List<Customer> items = _customerController.getItems();
        Assert.assertTrue("correct getItems", items.isEmpty() == false);
    }
    
    @Test
    public void testGetCustomer()
    {
        Customer customer = _customerController.getCustomer(1);
        Assert.assertTrue("correct getCustomer", customer.getCustomerID() == 1);
    }

    @Test
    public void testGetItemsAvailableSelectMany()
    {
        List<Customer> itemsAvailableSelectMany = _customerController.getItemsAvailableSelectMany();
        Assert.assertTrue("correct getItemsAvailableSelectMany", itemsAvailableSelectMany.isEmpty() == false);
    }
    
    @Test
    public void testGetItemsAvailableSelectOne()
    {
        List<Customer> itemsAvailableSelectOne = _customerController.getItemsAvailableSelectOne();
        Assert.assertTrue("correct getItemsAvailableSelectOne", itemsAvailableSelectOne.isEmpty() == false);
    }
    
    /* Test void methods----------------------------------------------------- */
    @Test
    public void testPrepareCreate()
    {
        Customer selected = _customerController.prepareCreate();
        Assert.assertTrue("correct prepareCreate", selected != null);
    }
}

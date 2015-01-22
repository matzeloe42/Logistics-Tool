package com.logisticstool.junit;

import com.logisticstool.logisticstool.Address;
import com.logisticstool.logisticstool.Customer;
import com.logisticstool.logisticstool.CustomerWithAddressController;
import com.logisticstool.logisticstool.Place;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Matthias
 */
public class CustomerWithAddressControllerTest
{
    private static CustomerWithAddressController _customerWithAddressController;
    
    public CustomerWithAddressControllerTest()
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
        _customerWithAddressController = new CustomerWithAddressController();
    }
    
    @After
    public void tearDown()
    {
    }

    /* Konstruktoren -------------------------------------------------------- */
    @Test
    public void testConstructor()
    {
        CustomerWithAddressController customerWithAddressController = new CustomerWithAddressController();
        Assert.assertTrue("correct Constructor", customerWithAddressController != null);
    }
    
    /* get und set ---------------------------------------------------------- */
    
    // Address tests
    @Test
    public void testGetAddress()
    {
        Address address = _customerWithAddressController.getAddress(1);
        Assert.assertTrue("correct getAddress", address.getAddressID() == 1);
    }
    
    @Test
    public void testSetAddress()
    {
        Address address = new Address(42, "Musterstraße", "13a");
        _customerWithAddressController.setAddress(address);
        Assert.assertTrue
        (
            "correct setAddress",
            _customerWithAddressController.getAddress().getAddressID() == address.getAddressID()
        );
    }
    
    @Test
    public void testGetAddressItems()
    {
        List<Address> addressItems = _customerWithAddressController.getAddressItems();
        Assert.assertTrue("correct getAddressItems", addressItems.isEmpty() == false);
    }
    
    @Test
    public void testGetAddressItemsAvailableSelectOne()
    {
        List<Address> addressItemsAvailableSelectOne = _customerWithAddressController.getAddressItemsAvailableSelectOne();
        Assert.assertTrue("correct getAddressItemsAvailableSelectOne", addressItemsAvailableSelectOne.isEmpty() == false);
    }
    
    @Test
    public void testGetAddressItemsAvailableSelectMany()
    {
        List<Address> addressItemsAvailableSelectMany = _customerWithAddressController.getAddressItemsAvailableSelectMany();
        Assert.assertTrue("correct getAddressItemsAvailableSelectMany", addressItemsAvailableSelectMany.isEmpty() == false);
    }

    // Customer tests
    @Test
    public void testGetCustomer()
    {
        Customer customer = _customerWithAddressController.getCustomer(1);
        Assert.assertTrue("correct getAddress", customer.getCustomerID() == 1);
    }

    @Test
    public void testSetCustomer()
    {
        Customer customer = new Customer(42, "Max", "Mustermann");
        _customerWithAddressController.setCustomer(customer);
        Assert.assertTrue
        (
            "correct setCustomer",
            _customerWithAddressController.getCustomer().getCustomerID() == customer.getCustomerID()
        );
    }

    @Test
    public void testGetCustomerItems()
    {
        List<Customer> customerItems = _customerWithAddressController.getCustomerItems();
        Assert.assertTrue("correct getCustomerItems", customerItems.isEmpty() == false);
    }
    
    @Test
    public void testGetCustomerItemsAvailableSelectOne()
    {
        List<Customer> customerItemsAvailableSelectOne = _customerWithAddressController.getCustomerItemsAvailableSelectOne();
        Assert.assertTrue("correct getCustomerItemsAvailableSelectOne", customerItemsAvailableSelectOne.isEmpty() == false);
    }
    
    @Test
    public void testGetCustomerItemsAvailableSelectMany()
    {
        List<Customer> customerItemsAvailableSelectMany = _customerWithAddressController.getCustomerItemsAvailableSelectMany();
        Assert.assertTrue("correct getCustomerItemsAvailableSelectMany", customerItemsAvailableSelectMany.isEmpty() == false);
    }

    // Place tests
    @Test
    public void testGetPlace()
    {
        Place place = _customerWithAddressController.getPlace(12345);
        Assert.assertTrue("correct getAddress", place.getZip() == 12345);
    }
    
    @Test
    public void testSetPlace()
    {
        Place place = new Place(12345, "Musterstadt");
        _customerWithAddressController.setPlace(place);
        Assert.assertTrue
        (
            "correct setPlace",
            _customerWithAddressController.getPlace().getZip() == place.getZip()
        );
    }
    
    @Test
    public void testGetPlaceItems()
    {
        List<Place> placeItems = _customerWithAddressController.getPlaceItems();
        Assert.assertTrue("correct getPlaceItems", placeItems.isEmpty() == false);
    }
    
    @Test
    public void testGetPlaceItemsAvailableSelectOne()
    {
        List<Place> placeItemsAvailableSelectOne = _customerWithAddressController.getPlaceItemsAvailableSelectOne();
        Assert.assertTrue("correct getCustomerItemsAvailableSelectOne", placeItemsAvailableSelectOne.isEmpty() == false);
    }
    
    @Test
    public void testGetPlaceItemsAvailableSelectMany()
    {
        List<Place> placeItemsAvailableSelectMany = _customerWithAddressController.getPlaceItemsAvailableSelectMany();
        Assert.assertTrue("correct getCustomerItemsAvailableSelectMany", placeItemsAvailableSelectMany.isEmpty() == false);
    }
}

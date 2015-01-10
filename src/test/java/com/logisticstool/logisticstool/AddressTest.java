package com.logisticstool.logisticstool;

import java.util.HashSet;
import java.util.Set;
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
public class AddressTest
{
    private static Address _address;
    
    public AddressTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _address = new Address();
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /* Konstruktoren -------------------------------------------------------- */
    @Test
    public void testConstructor1()
    {
        Address address = new Address();
        Assert.assertTrue("correct Constructor", address != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Address address = new Address(42);
        Assert.assertTrue("correct AddressID", address.getAddressID() == 42);
    }
    
    public void testConstructor3()
    {
        Address address = new Address(42, "Musterstraße", "42a");
        Assert.assertTrue("correct AddressID", address.getAddressID() == 42 );
        Assert.assertTrue("correct Street", address.getStreet().equals("Musterstraße"));
        Assert.assertTrue("correct Housenumber", address.getHousenumber().equals("42a"));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetAddressID()
    {
        _address.setAddressID(42);
        Assert.assertTrue("correct AddressID", _address.getAddressID() == 42);
    }

    @Test
    public void testSetStreet()
    {
        _address.setStreet("Musterstraße");
        Assert.assertTrue("correct Street", _address.getStreet().equals("Musterstraße"));
    }
    
    @Test
    public void testSetHousenumber()
    {
        _address.setHousenumber("42a");
        Assert.assertTrue("correct Housenumber", _address.getHousenumber().equals("42a"));
    }
    
    @Test
    public void testSetPlaceZIP()
    {
        Place place = new Place();
        place.setZip(12345);
        _address.setPlaceZIP(place);
        Assert.assertTrue("correct PlaceZIP", _address.getPlaceZIP().getZip() == 12345);
    }

    @Test
    public void testSetCustomerCollection()
    {
        Set<Customer> customerSet = new HashSet<Customer>();
        _address.setCustomers(customerSet);
        Assert.assertTrue("correct CustomerCollection", _address.getCustomers().containsAll(customerSet) );
    }

}

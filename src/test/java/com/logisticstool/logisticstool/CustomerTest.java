package com.logisticstool.logisticstool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
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
public class CustomerTest
{
    private static Customer _customer;
    
    public CustomerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _customer = new Customer();
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

    /* Constructors --------------------------------------------------------- */
    @Test
    public void testConstructor1()
    {
        Customer customer = new Customer();
        Assert.assertTrue("correct Constructor", customer != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Customer customer = new Customer(42);
        Assert.assertTrue("correct CustomerID", customer.getCustomerID() == 42);
    }
    
    public void testConstructor3()
    {
        Customer customer = new Customer(42, "Max", "Mustermann");
        Assert.assertTrue("correct CustomerID", customer.getCustomerID() == 42);
        Assert.assertTrue("correct FirstName", customer.getFirstName().equals("Max"));
        Assert.assertTrue("correct LastName", customer.getLastName().equals("Mustermann"));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetCustomerID()
    {
        _customer.setCustomerID(42);
        Assert.assertTrue("correct CustomerID", _customer.getCustomerID() == 42);
    }

    @Test
    public void testSetFirstName()
    {
        _customer.setFirstName("Max");
        Assert.assertTrue("correct FirstName", _customer.getFirstName().equals("Max"));
    }
    
    @Test
    public void testLastName()
    {
        _customer.setLastName("Mustermann");
        Assert.assertTrue("correct LastName", _customer.getLastName().equals("Mustermann"));
    }

    @Test
    public void testSetHabitation()
    {
        Set<Address> customerAddress = new HashSet<Address>();
        _customer.setHabitation(customerAddress);
        Assert.assertTrue("correct Habitation", _customer.getHabitation().containsAll(customerAddress));
    }
    
    @Test
    public void testSetCreditAdviceCollection()
    {
        Collection<Creditadvice> creditadviceCollection = new ArrayList();
        _customer.setCreditadviceCollection(creditadviceCollection);
        Assert.assertTrue("correct CreditAdviceCollection", _customer.getCreditadviceCollection().containsAll(creditadviceCollection));
    }
    
    @Test
    public void testSetOfferCollection()
    {
        Collection<Offer> offerCollection = new ArrayList();
        _customer.setOfferCollection(offerCollection);
        Assert.assertTrue("correct OfferCollection", _customer.getOfferCollection().containsAll(offerCollection));
    }
    
    /* Test void methods----------------------------------------------------- */
    
    @Test
    public void testHabitate()
    {
        Address address = new Address(42, "Musterstraße", "42a");
        _customer.habitate(address);
        assertEquals(1, _customer.getHabitation().size());
    }
}
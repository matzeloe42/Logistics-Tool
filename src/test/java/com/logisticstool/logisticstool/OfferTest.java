package com.logisticstool.logisticstool;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
public class OfferTest
{
    private static Offer _offer;
    
    public OfferTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _offer = new Offer();
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
        Offer offer = new Offer();
        Assert.assertTrue("correct Constructor", offer != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Offer offer = new Offer(42);
        Assert.assertTrue("correct OfferID", offer.getOfferID() == 42);
    }
    
    public void testConstructor3()
    {
        BigDecimal salestax = new BigDecimal("42.00");
        Date date = new Date();
        Offer offer = new Offer(42, date, salestax);
        Assert.assertTrue("correct OfferID", offer.getOfferID() == 42 );
        Assert.assertTrue("corrects Date", offer.getCreationDate().equals(date));
        Assert.assertTrue("correctr Salestax", offer.getSalestax().equals(new BigDecimal("42.0")));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetOfferID()
    {
        _offer.setOfferID(42);
        Assert.assertTrue("correct OfferID", _offer.getOfferID() == 42);
    }

    @Test
    public void testSetCreationDate()
    {
        Date date = new Date();
        _offer.setCreationDate(date);
        Assert.assertTrue("correct Date", _offer.getCreationDate().equals(date));
    }
    
    @Test
    public void testSetSalestax()
    {
        _offer.setSalestax(new BigDecimal("42.0"));
        Assert.assertTrue("correct Salestax", _offer.getSalestax().equals(new BigDecimal("42.0")));
    }

    @Test
    public void testSetCustomerCustomerID()
    {
        Customer customer = new Customer();
        _offer.setCustomerCustomerID(customer);
        Assert.assertTrue("correct CustomerCustomerID", _offer.getCustomerCustomerID().equals(customer));
    }
    
    @Test
    public void testSetMoveMoveID()
    {
        Move move = new Move();
        _offer.setMoveMoveID(move);
        Assert.assertTrue("correct MoveMoveID", _offer.getMoveMoveID().equals(move));
    }
    
    @Test
    public void testSetStorageStorageID()
    {
        Storage storage = new Storage();
        _offer.setStorageStorageID(storage);
        Assert.assertTrue("correct StorageStorageID", _offer.getStorageStorageID().equals(storage));
    }
    
    @Test
    public void testSetTransportTransportID()
    {
        Transport transport = new Transport();
        _offer.setTransportTransportID(transport);
        Assert.assertTrue("correct TransportTransportID", _offer.getTransportTransportID().equals(transport));
    }
    
    @Test
    public void testSetJobCollection()
    {
        Collection<Job> jobCollection = new ArrayList<Job>();
        _offer.setJobCollection(jobCollection);
        Assert.assertTrue("correct JobCollection", _offer.getJobCollection().containsAll(jobCollection));
    }
}

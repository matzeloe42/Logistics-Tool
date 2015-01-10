package com.logisticstool.logisticstool;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
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
public class StorageTest
{
    private static Storage _storage;
    
    public StorageTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _storage = new Storage();
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
        Storage storage = new Storage();
        Assert.assertTrue("correct Constructor", storage != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Storage storage = new Storage(42);
        Assert.assertTrue("correct StorageID", storage.getStorageID() == 42);
    }
    
    public void testConstructor3()
    {
        BigDecimal amount = new BigDecimal("42.00");
        BigDecimal price = new BigDecimal("42.00");
        Storage storage = new Storage(42, amount, price);
        Assert.assertTrue("correct StorageID", storage.getStorageID() == 42 );
        Assert.assertTrue("correct Amount", storage.getAmount().equals(amount));
        Assert.assertTrue("correctr Price", storage.getPrize().equals(price));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetStorageID()
    {
        _storage.setStorageID(42);
        Assert.assertTrue("correct StorageID", _storage.getStorageID() == 42);
    }
    
    @Test
    public void testSetAmount()
    {
        _storage.setAmount(new BigDecimal("42.0"));
        Assert.assertTrue("correct Amount", _storage.getAmount().equals(new BigDecimal("42.0")));
    }
    
    @Test
    public void testSetPrize()
    {
        _storage.setPrize(new BigDecimal("42.0"));
        Assert.assertTrue("correctr Price", _storage.getPrize().equals(new BigDecimal("42.0")));
    }
    
    @Test
    public void testSetOfferCollection()
    {
        Collection<Offer> offerCollection = new ArrayList();
        _storage.setOfferCollection(offerCollection);
        Assert.assertTrue("correct OfferCollection", _storage.getOfferCollection().containsAll(offerCollection));
    }
}

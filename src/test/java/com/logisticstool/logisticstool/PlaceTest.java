package com.logisticstool.logisticstool;

import java.util.ArrayList;
import java.util.Collection;
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
public class PlaceTest
{
    private static Place _place;
    
    public PlaceTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _place = new Place();
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
        Place place = new Place();
        Assert.assertTrue("correct Constructor", place != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Place place = new Place(12345);
        Assert.assertTrue("correct ZIP", place.getZip() == 12345);
    }
    
    public void testConstructor3()
    {
        Place place = new Place(12345, "Musterstadt");
        Assert.assertTrue("correct ZIP", place.getZip() == 12345);
        Assert.assertTrue("correct Place", place.getPlace().equals("Musterstadt"));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetPlace()
    {
        _place.setPlace("Musterstadt");
        Assert.assertEquals(_place.getPlace(), "Musterstadt");
    }

    @Test
    public void testSetAddressCollection()
    {
        Collection<Address> addressCollection = new ArrayList();
        _place.setAddressCollection(addressCollection);
        Assert.assertEquals(true, _place.getAddressCollection().containsAll(addressCollection));
    }
    
    @Test
    public void testSetStartaddressCollection()
    {
        Collection<Startaddress> startaddressCollection = new ArrayList();
        _place.setStartaddressCollection(startaddressCollection);
        Assert.assertEquals(true, _place.getStartaddressCollection().containsAll(startaddressCollection));
    }
    
    @Test
    public void testSetDestinationaddressCollection()
    {
        Collection<Destinationaddress> destinationaddressCollection = new ArrayList();
        _place.setDestinationaddressCollection(destinationaddressCollection);
        Assert.assertEquals(true, _place.getDestinationaddressCollection().containsAll(destinationaddressCollection));
    }
}

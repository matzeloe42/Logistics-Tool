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
public class DestinationaddressTest
{
    private static Destinationaddress _destinationaddress;
    
    public DestinationaddressTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _destinationaddress = new Destinationaddress();
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
        Destinationaddress destinationaddress = new Destinationaddress();
        Assert.assertTrue("correct Constructor", destinationaddress != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Destinationaddress destinationaddress = new Destinationaddress(42);
        Assert.assertTrue("correct DestinationAddressID", destinationaddress.getDestinationAddressID() == 42);
    }
    
    public void testConstructor3()
    {
        Destinationaddress destinationaddress = new Destinationaddress(42, "Musterstraße", "42a");
        Assert.assertTrue("correct DestinationAddressID", destinationaddress.getDestinationAddressID() == 42 );
        Assert.assertTrue("correct Street", destinationaddress.getStreet().equals("Musterstraße"));
        Assert.assertTrue("correct Housenumber", destinationaddress.getHousenumber().equals("42a"));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetDestinationAddressID()
    {
        _destinationaddress.setDestinationAddressID(42);
        Assert.assertTrue("correct DestinationAddressID", _destinationaddress.getDestinationAddressID() == 42);
    }

    @Test
    public void testSetStreet()
    {
        _destinationaddress.setStreet("Musterstraße");
        Assert.assertTrue("correct Street", _destinationaddress.getStreet().equals("Musterstraße"));
    }
    
    @Test
    public void testSetHousenumber()
    {
        _destinationaddress.setHousenumber("42a");
        Assert.assertTrue("correct Housenumber", _destinationaddress.getHousenumber().equals("42a"));
    }
    
    @Test
    public void testSetPlaceZIP()
    {
        Place place = new Place();
        place.setZip(12345);
        _destinationaddress.setPlaceZIP(place);
        Assert.assertTrue("correct PlaceZIP", _destinationaddress.getPlaceZIP().getZip() == 12345);
    }

    @Test
    public void testSetTransportCollection()
    {
        Collection<Transport> transportCollection = new ArrayList();
        _destinationaddress.setTransportCollection(transportCollection);
        Assert.assertTrue("correct TransportCollection", _destinationaddress.getTransportCollection().containsAll(transportCollection));
    }
}

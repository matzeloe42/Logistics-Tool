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
public class StartaddressTest
{
    private static Startaddress _startaddress;
    
    public StartaddressTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _startaddress = new Startaddress();
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
        Startaddress startaddress = new Startaddress();
        Assert.assertTrue("correct Constructor", startaddress != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Startaddress startaddress = new Startaddress(42);
        Assert.assertTrue("correct StartaddressID", startaddress.getStartAddressID() == 42);
    }
    
    public void testConstructor3()
    {
        Startaddress startaddress = new Startaddress(42, "Musterstraße", "42a");
        Assert.assertTrue("correct StartaddressID", startaddress.getStartAddressID()== 42 );
        Assert.assertTrue("correct Street", startaddress.getStreet().equals("Musterstraße"));
        Assert.assertTrue("correct Housenumber", startaddress.getHousenumber().equals("42a"));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetStartaddressID()
    {
        _startaddress.setStartAddressID(42);
        Assert.assertTrue("correct StartaddressID", _startaddress.getStartAddressID() == 42);
    }

    @Test
    public void testSetStreet()
    {
        _startaddress.setStreet("Musterstraße");
        Assert.assertTrue("correct Street", _startaddress.getStreet().equals("Musterstraße"));
    }
    
    @Test
    public void testSetHousenumber()
    {
        _startaddress.setHousenumber("42a");
        Assert.assertTrue("correct Housenumber", _startaddress.getHousenumber().equals("42a"));
    }
    
    @Test
    public void testSetPlaceZIP()
    {
        Place place = new Place();
        place.setZip(12345);
        _startaddress.setPlaceZIP(place);
        Assert.assertTrue("correct PlaceZIP", _startaddress.getPlaceZIP().getZip() == 12345);
    }

    @Test
    public void testSetTransportCollection()
    {
        Collection<Transport> transportCollection = new ArrayList();
        _startaddress.setTransportCollection(transportCollection);
        Assert.assertTrue("correct TransportCollection", _startaddress.getTransportCollection().containsAll(transportCollection));
    }
}

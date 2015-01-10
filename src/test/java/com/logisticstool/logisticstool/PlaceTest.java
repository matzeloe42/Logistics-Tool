/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

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
 * @author Matze
 */
public class PlaceTest
{
    private static Place place;
    
    public PlaceTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        place = new Place();
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
        Assert.assertTrue("korrekter Konstruktor", place != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Place place = new Place(12345);
        Assert.assertTrue("korrekte PLZ", place.getZip() == 12345);
    }
    
    public void testConstructor3()
    {
        Place place = new Place(12345, "Musterstadt");
        Assert.assertTrue("korrekte PLZ", place.getZip() == 12345);
        Assert.assertTrue("korrekte Stadt", place.getPlace().equals("Musterstadt"));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetPlace()
    {
        place.setPlace("Musterstadt");
        Assert.assertEquals(place.getPlace(), "Musterstadt");
    }

    @Test
    public void testSetAddressCollection()
    {
        Collection<Address> addressCollection = new ArrayList();
        place.setAddressCollection(addressCollection);
        Assert.assertEquals(true, place.getAddressCollection().containsAll(addressCollection));
    }
    
    @Test
    public void testSetStartaddressCollection()
    {
        Collection<Startaddress> startaddressCollection = new ArrayList();
        place.setStartaddressCollection(startaddressCollection);
        Assert.assertEquals(true, place.getStartaddressCollection().containsAll(startaddressCollection));
    }
    
    @Test
    public void testSetDestinationaddressCollection()
    {
        Collection<Destinationaddress> destinationaddressCollection = new ArrayList();
        place.setDestinationaddressCollection(destinationaddressCollection);
        Assert.assertEquals(true, place.getDestinationaddressCollection().containsAll(destinationaddressCollection));
    }
}

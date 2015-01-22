package com.logisticstool.junit;

import com.logisticstool.logisticstool.Destinationaddress;
import com.logisticstool.logisticstool.Move;
import com.logisticstool.logisticstool.Offer;
import com.logisticstool.logisticstool.Product;
import com.logisticstool.logisticstool.Startaddress;
import com.logisticstool.logisticstool.Transport;
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
public class TransportTest
{
    private static Transport _transport;
    
    public TransportTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _transport = new Transport();
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
        Transport transport = new Transport();
        Assert.assertTrue("correct Constructor", transport != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Transport transport = new Transport(42);
        Assert.assertTrue("correct TransportID", transport.getTransportID() == 42);
    }
    
    /* get und set ---------------------------------------------------------- */ 
    @Test
    public void testSetTransportID()
    {
        _transport.setTransportID(42);
        Assert.assertTrue("correct TransportID", _transport.getTransportID() == 42);
    }
    
    @Test
    public void testSetProductCollection()
    {
        Collection<Product> productCollection = new ArrayList();
        _transport.setProductCollection(productCollection);
        Assert.assertTrue("correct ProductCollection", _transport.getProductCollection().containsAll(productCollection));
    }
    
   @Test
    public void testSetMoveCollection()
    {
        Collection<Move> movceCollection = new ArrayList();
        _transport.setMoveCollection(movceCollection);
        Assert.assertTrue("correct MoveCollection", _transport.getMoveCollection().containsAll(movceCollection));
    }
    
    @Test
    public void testSetDestinationAddressDestinationAddressID()
    {
        Destinationaddress destinationaddress = new Destinationaddress();
        _transport.setDestinationAddressDestinationAddressID(destinationaddress);
        Assert.assertTrue("correct DestinationAddressDestinationAddressID", _transport.getDestinationAddressDestinationAddressID().equals(destinationaddress));
    }
    
    @Test
    public void testSetStartAddressStartAddressID()
    {
        Startaddress startaddress = new Startaddress();
        _transport.setStartAddressStartAddressID(startaddress);
        Assert.assertTrue("correct StartAddressStartAddressID", _transport.getStartAddressStartAddressID().equals(startaddress));
    }
    
    @Test
    public void testSetOfferCollection()
    {
        Collection<Offer> offerCollection = new ArrayList();
        _transport.setOfferCollection(offerCollection);
        Assert.assertTrue("correct OfferCollection", _transport.getOfferCollection().equals(offerCollection));
    }
}

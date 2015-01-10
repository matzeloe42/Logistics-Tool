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
public class MoveTest
{
    private static Move _move;
    
    public MoveTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _move = new Move();
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
        Move move = new Move();
        Assert.assertTrue("correct Constructor", move != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Move move = new Move(42);
        Assert.assertTrue("correct MoveID", move.getMoveID() == 42);
    }
    
    /* get und set ---------------------------------------------------------- */ 
    @Test
    public void testSetServiceCollection()
    {
        Collection<Service> serviceCollection = new ArrayList();
        _move.setServiceCollection(serviceCollection);
        Assert.assertTrue("correct ServiceCollection", _move.getServiceCollection().equals(serviceCollection));
    }
    
    @Test
    public void testSetTransportCollection()
    {
        Transport transport = new Transport();
        _move.setTransportTransportID(transport);
        Assert.assertTrue("correct TransportCollection", _move.getTransportTransportID().equals(transport));
    }
    
    @Test
    public void testSetOfferCollection()
    {
        Collection<Offer> offerCollection = new ArrayList();
        _move.setOfferCollection(offerCollection);
        Assert.assertTrue("correct OfferCollection", _move.getOfferCollection().equals(offerCollection));
    }
}

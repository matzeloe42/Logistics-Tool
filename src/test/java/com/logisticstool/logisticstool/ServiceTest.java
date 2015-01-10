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

/**
 *
 * @author Matthias
 */
public class ServiceTest
{
    private static Service _service;
    
    public ServiceTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _service = new Service();
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
        Service service = new Service();
        Assert.assertTrue("correct Constructor", service != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Service service = new Service(42);
        Assert.assertTrue("correct ServiceID", service.getServiceID() == 42);
    }
    
    public void testConstructor3()
    {
        BigDecimal price = new BigDecimal("42.00");
        Service service = new Service(42, "Example Denotation", price);
        Assert.assertTrue("correct ServiceID", service.getServiceID() == 42 );
        Assert.assertTrue("correct Denotation", service.getDenotation().equals("Example Denotation"));
        Assert.assertTrue("correct Price", service.getPrize().equals(new BigDecimal("42.0")));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetServiceID()
    {
        _service.setServiceID(42);
        Assert.assertTrue("correct ServiceID", _service.getServiceID() == 42);
    }

    @Test
    public void testSetDenotation()
    {
        _service.setDenotation("Example Denotation");
        Assert.assertTrue("correct Denotation", _service.getDenotation().equals("Example Denotation"));
    }
    
    @Test
    public void testSetPrize()
    {
        _service.setPrize(new BigDecimal("42.0"));
        Assert.assertTrue("correct Price", _service.getPrize().equals(new BigDecimal("42.0")));
    }
    
    @Test
    public void testSetMoveCollection()
    {
        Collection<Move> moveCollection = new ArrayList();
        _service.setMoveCollection(moveCollection);
        Assert.assertTrue("correct MoveCollection", _service.getMoveCollection().containsAll(moveCollection));
    }
}

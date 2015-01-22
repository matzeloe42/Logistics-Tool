package com.logisticstool.junit;

import com.logisticstool.logisticstool.Job;
import com.logisticstool.logisticstool.Offer;
import com.logisticstool.logisticstool.Sales;
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
public class JobTest
{
    private static Job _job;
    
    public JobTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _job = new Job();
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
        Job job = new Job();
        Assert.assertTrue("correct Constructor", job != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Job job = new Job(42);
        Assert.assertTrue("correct JobID", job.getJobID() == 42);
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetCreationDate()
    {
        Date date = new Date();
        _job.setCreationDate(date);
        Assert.assertTrue("correct Date", _job.getCreationDate().equals(date));
    }

    @Test
    public void testSetSalestax()
    {
        BigDecimal salestax = new BigDecimal("42.00");
        _job.setSalestax(salestax);
        Assert.assertTrue("correct Salestax", _job.getSalestax().equals(salestax));
    }
    
    @Test
    public void testSetTotalSum()
    {
        BigDecimal totalsum = new BigDecimal("42.00");
        _job.setTotalSum(totalsum);
        Assert.assertTrue("correct TotalSum", _job.getTotalSum().equals(totalsum));
    }
    
    @Test
    public void testSetSalesCollection()
    {
        Collection<Sales> salesCollection = new ArrayList();
        _job.setSalesCollection(salesCollection);
        Assert.assertTrue("correct SalesCollection", _job.getSalesCollection().containsAll(salesCollection));
    }
    
    @Test
    public void testSetOfferOfferID()
    {
        Offer offer = new Offer();
        _job.setOfferOfferID(offer);
        Assert.assertTrue("correct OfferOfferID", _job.getOfferOfferID().equals(offer));
    }
}

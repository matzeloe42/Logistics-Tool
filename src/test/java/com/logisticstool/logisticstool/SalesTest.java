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
public class SalesTest
{
    private static Sales _sales;
    
    public SalesTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _sales = new Sales();
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
        Sales sales = new Sales();
        Assert.assertTrue("correct Constructor", sales != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Sales sales = new Sales(42);
        Assert.assertTrue("correct SalesID", sales.getSalesID() == 42);
    }
    
    /* get und set ---------------------------------------------------------- */ 
    
    @Test
    public void testSetSalesID()
    {
        _sales.setSalesID(42);
        Assert.assertTrue("correct SalesID", _sales.getSalesID() == 42);
    }
    
    @Test
    public void testSetJobCollection()
    {
        Collection<Job> jobCollection = new ArrayList();
        _sales.setJobCollection(jobCollection);
        Assert.assertTrue("correct JobCollection", _sales.getJobCollection().containsAll(jobCollection));
    }
    
    @Test
    public void testSetCreditadviceCollection()
    {
        Collection<Creditadvice> creditadviceCollection = new ArrayList();
        _sales.setCreditadviceCollection(creditadviceCollection);
        Assert.assertTrue("correct CreditadviceCollection", _sales.getCreditadviceCollection().containsAll(creditadviceCollection));
    }
}

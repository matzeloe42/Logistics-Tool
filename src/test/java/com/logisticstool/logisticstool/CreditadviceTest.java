package com.logisticstool.logisticstool;

import java.math.BigDecimal;
import java.util.Date;
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
public class CreditadviceTest
{
    private static Creditadvice _creditadvice;
    
    public CreditadviceTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _creditadvice = new Creditadvice();
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
        Creditadvice creditadvice = new Creditadvice();
        Assert.assertTrue("correct Constructor", creditadvice != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Creditadvice creditadvice = new Creditadvice(42);
        Assert.assertTrue("correct CreditadviceID", creditadvice.getCreditadviceID() == 42);
    }
    
    public void testConstructor3()
    {
        BigDecimal amount = new BigDecimal("42.00");
        Date date = new Date();
        Creditadvice creditadvice = new Creditadvice(42, date, amount);
        Assert.assertTrue("correct CreditadviceID", creditadvice.getCreditadviceID() == 42 );
        Assert.assertTrue("correct Date", creditadvice.getCreditadviceDate().equals(date));
        Assert.assertTrue("correct Amount", creditadvice.getAmount().equals(new BigDecimal("42.0")));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetCreditadviceID()
    {
        _creditadvice.setCreditadviceID(42);
        Assert.assertTrue("correct CreditadviceID", _creditadvice.getCreditadviceID() == 42);
    }

    @Test
    public void testSetCreditadviceDate()
    {
        Date date = new Date();
        _creditadvice.setCreditadviceDate(date);
        Assert.assertTrue("correct Date", _creditadvice.getCreditadviceDate().equals(date));
    }
    
    @Test
    public void testSetAmount()
    {
        _creditadvice.setAmount(new BigDecimal("42.0"));
        Assert.assertTrue("correct Amount", _creditadvice.getAmount().equals(new BigDecimal("42.0")));
    }

    @Test
    public void testSetCustomerCollection()
    {
        Collection<Customer> customerCollection = new ArrayList<Customer>();
        _creditadvice.setCustomerCollection(customerCollection);
        Assert.assertTrue("correct CustomerCollection", _creditadvice.getCustomerCollection().containsAll(customerCollection) );
    }
    
    @Test
    public void testSetSalesCollection()
    {
        Collection<Sales> salesCollection = new ArrayList<Sales>();
        _creditadvice.setSalesCollection(salesCollection);
        Assert.assertTrue("correct SalesCollection", _creditadvice.getSalesCollection().containsAll(salesCollection) );
    }
}
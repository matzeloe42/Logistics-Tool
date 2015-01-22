package com.logisticstool.junit;

import com.logisticstool.logisticstool.Product;
import com.logisticstool.logisticstool.Transport;
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
public class ProductTest
{
    private static Product _product;
    
    public ProductTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _product = new Product();
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
        Product product = new Product();
        Assert.assertTrue("correct Constructor", product != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Product product = new Product(42);
        Assert.assertTrue("correct ProductID", product.getProductID() == 42);
    }
    
    public void testConstructor3()
    {
        BigDecimal price = new BigDecimal("42.00");
        Product product = new Product(42, "Example Denotation", price);
        Assert.assertTrue("correct ProductID", product.getProductID() == 42 );
        Assert.assertTrue("correct Denotation", product.getDenotation().equals("Example Denotation"));
        Assert.assertTrue("correct Price", product.getPrize().equals(new BigDecimal("42.0")));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetProductID()
    {
        _product.setProductID(42);
        Assert.assertTrue("correct ProductID", _product.getProductID() == 42);
    }

    @Test
    public void testSetDenotation()
    {
        _product.setDenotation("Example Denotation");
        Assert.assertTrue("correct Denotation", _product.getDenotation().equals("Example Denotation"));
    }
    
    @Test
    public void testSetPrize()
    {
        _product.setPrize(new BigDecimal("42.0"));
        Assert.assertTrue("correct Price", _product.getPrize().equals(new BigDecimal("42.0")));
    }
    
    @Test
    public void testSetTransportCollection()
    {
        Collection<Transport> transportCollection = new ArrayList<Transport>();
        _product.setTransportCollection(transportCollection);
        Assert.assertTrue("correct TransportCollection", _product.getTransportCollection().containsAll(transportCollection));
    }
}

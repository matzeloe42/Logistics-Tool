package com.logisticstool.junit;

import com.logisticstool.logisticstool.Userdata;
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
public class UserdataTest
{
    private static Userdata _userdata;
    
    public UserdataTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _userdata = new Userdata();
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
        Userdata userdata = new Userdata();
        Assert.assertTrue("correct Constructor", userdata != null);
    }
    
    @Test
    public void testConstructor2()
    {
        Userdata userdata = new Userdata(42);
        Assert.assertTrue("correct UserdataID", userdata.getUserDataID() == 42);
    }
    
    public void testConstructor3()
    {
        Userdata userdata = new Userdata(42, "Musterbenutzer", "Musterpasswort");
        Assert.assertTrue("correct UserdataID", userdata.getUserDataID() == 42);
        Assert.assertTrue("correct Username", userdata.getUsername().equals("Musterbenutzer"));
        Assert.assertTrue("correct Password", userdata.getPassword().equals("Musterpasswort"));
    }
    
    /* get und set ---------------------------------------------------------- */
    @Test
    public void testSetUserdataID()
    {
        _userdata.setUserDataID(42);
        Assert.assertTrue("correct UserdataID", _userdata.getUserDataID() == 42);
    }

    @Test
    public void testSetUsername()
    {
        _userdata.setUsername("Musterbenutzer");
        Assert.assertTrue("correct Username", _userdata.getUsername().equals("Musterbenutzer"));
    }
    
    @Test
    public void testPassword()
    {
        _userdata.setPassword("Musterpasswort");
        Assert.assertTrue("correct Password", _userdata.getPassword().equals("Musterpasswort"));
    }
}

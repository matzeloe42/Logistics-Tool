package com.logisticstool.junit;

import com.logisticstool.logisticstool.*;
import java.io.File;
import java.util.List;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Matthias
 */
@RunWith(Arquillian.class)
//@RunAsClient
public class AddressControllerTest
{
    /*@Deployment
    public static WebArchive createDeployment()
    {
        File[] files = Maven.resolver().loadPomFromFile("pom.xml")
                .importRuntimeDependencies().resolve().withTransitivity().asFile();
    
        WebArchive result = ShrinkWrap.create(WebArchive.class, "LogisticsTool-1.0-SNAPSHOT.war")
                            .addAsLibraries(files)
                            .addPackages(true, "com.logisticstool.logisticstool")
                            .addAsResource(new File("src/main/resources/META-INF/persistence.xml"),
                                    "META-INF/persistence.xml")
                            .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
        
        return result;
    }*/
    
    /*@Deployment //@OverProtocol("Servlet 3.0")
    public static WebArchive createDeployment()
    {    
        File[] lib = Maven.resolver()
                .resolve("org.jboss.weld.servlet:weld-servlet:1.1.9.Final")
                .withTransitivity().as(File.class);
         
        WebArchive jar =  ShrinkWrap.create(WebArchive.class)
            .addClass(Address.class)
            .addClass(Customer.class)
            .addClass(Creditadvice.class)
            .addClass(Offer.class)
            .addClass(Place.class)
            .addAsManifestResource("arquillian.xml")
            .addAsLibraries(lib)
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .setWebXML("web.xml")
            ;
         
        System.out.println(jar.toString(true));
         
        return jar;
    }*/
    
    // Arquillian properties
    /*@Inject
    private Address _address;*/
            
    // Instance properties        
    private static AddressController _addressController;
    
    public AddressControllerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        _addressController = new AddressController();
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
    public void testConstructor()
    {
        AddressController addressController = new AddressController();
        Assert.assertTrue("correct Constructor", addressController != null);
    }
    
    /* Arquillian ----------------------------------------------------------- */
    /*@Test
    public void testAddress() throws Exception
    {
        Assert.assertNotNull(_address);
        final Address address = _address;
    }*/
    
    /* get und set ---------------------------------------------------------- */
    /*@Test
    public void testSelected()
    {
        Address selected = new Address(42, "Musterstrasse", "13a");
        _addressController.setSelected(selected);
        Assert.assertTrue
        (
            "correct setSelected",
            _addressController.getSelected().getAddressID() == selected.getAddressID()
        );
    }*/
    
    /*@Test
    public void testGetItems()
    {
        List<Address> items = _addressController.getItems();
        Assert.assertTrue("correct getItems", items.isEmpty() == false);
    }*/
    
    /*@Test
    public void testGetAddress()
    {
        Address address = _addressController.getAddress(1);
        Assert.assertTrue("correct getAddress", address.getAddressID() == 1);
    }*/

    /*@Test
    public void testGetItemsAvailableSelectMany()
    {
        List<Address> itemsAvailableSelectMany = _addressController.getItemsAvailableSelectMany();
        Assert.assertTrue("correct getItemsAvailableSelectMany", itemsAvailableSelectMany.isEmpty() == false);
    }*/
    
    /*@Test
    public void testGetItemsAvailableSelectOne()
    {
        List<Address> itemsAvailableSelectOne = _addressController.getItemsAvailableSelectOne();
        Assert.assertTrue("correct getItemsAvailableSelectOne", itemsAvailableSelectOne.isEmpty() == false);
    }*/
    
    /* Test void methods----------------------------------------------------- */
    @Test
    public void testPrepareCreate()
    {
        Address selected = _addressController.prepareCreate();
        Assert.assertTrue("correct prepareCreate", selected != null);
    }
}

package com.logisticstool.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateCustomerDialog
{

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception
    {

        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void testCreateUserDialog() throws Exception
    {
        driver.get(baseUrl + "/Logistics-Tool/");
        driver.findElement(By.xpath("//div[@id='formBody:j_idt12']/ul/li[6]/a/span[2]")).click();
        driver.findElement(By.linkText("Kundenverwaltung")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).sendKeys("Raphael");
        driver.findElement(By.id("CustomerWithAddressCreateForm:lastName")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:lastName")).sendKeys("Teuber");
        driver.findElement(By.id("CustomerWithAddressCreateForm:street")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:street")).sendKeys("Hindenburgstraße");
        driver.findElement(By.id("CustomerWithAddressCreateForm:housenumber")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:housenumber")).sendKeys("54");
        driver.findElement(By.id("CustomerWithAddressCreateForm:zip")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:zip")).sendKeys("78549");
        driver.findElement(By.id("CustomerWithAddressCreateForm:place")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:place")).sendKeys("Spaichingen");
        driver.findElement(By.id("CustomerWithAddressCreateForm:j_idt10")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:firstName")).sendKeys("Heinz");
        driver.findElement(By.id("CustomerWithAddressCreateForm:lastName")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:lastName")).sendKeys("Gustav");
        driver.findElement(By.id("CustomerWithAddressCreateForm:street")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:street")).sendKeys("Teststraße");
        driver.findElement(By.id("CustomerWithAddressCreateForm:housenumber")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:housenumber")).sendKeys("12");
        driver.findElement(By.id("CustomerWithAddressCreateForm:zip")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:zip")).sendKeys("12345");
        driver.findElement(By.id("CustomerWithAddressCreateForm:place")).clear();
        driver.findElement(By.id("CustomerWithAddressCreateForm:place")).sendKeys("Teststadt");
        driver.findElement(By.id("CustomerWithAddressCreateForm:j_idt10")).click();
        driver.findElement(By.id("CustomerWithAddressCreateForm:j_idt11")).click();
        driver.findElement(By.linkText("Startseite")).click();
    }

    @After
    public void tearDown() throws Exception
    {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by)
    {
        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    private boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e)
        {
            return false;
        }
    }

    private String closeAlertAndGetItsText()
    {
        try
        {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert)
            {
                alert.accept();
            } else
            {
                alert.dismiss();
            }
            return alertText;
        } finally
        {
            acceptNextAlert = true;
        }
    }
}

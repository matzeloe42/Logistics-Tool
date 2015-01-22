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

public class CreateAndLoginUserDialog
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
        driver.findElement(By.linkText("Show All Userdata Items")).click();
        driver.findElement(By.id("UserdataListForm:datalist:createButton")).click();
        driver.findElement(By.id("UserdataCreateForm:userDataID")).clear();
        driver.findElement(By.id("UserdataCreateForm:userDataID")).sendKeys("2");
        driver.findElement(By.id("UserdataCreateForm:username")).clear();
        driver.findElement(By.id("UserdataCreateForm:username")).sendKeys("test");
        driver.findElement(By.id("UserdataCreateForm:password")).clear();
        driver.findElement(By.id("UserdataCreateForm:password")).sendKeys("1234");
        driver.findElement(By.id("UserdataCreateForm:j_idt45")).click();
        driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
        driver.findElement(By.id("formBody:j_idt21")).click();
        driver.findElement(By.id("formBody:loginUsername")).clear();
        driver.findElement(By.id("formBody:loginUsername")).sendKeys("test");
        driver.findElement(By.id("formBody:loginPassword")).clear();
        driver.findElement(By.id("formBody:loginPassword")).sendKeys("1234");
        driver.findElement(By.id("formBody:j_idt26")).click();
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

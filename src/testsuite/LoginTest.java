package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
    @Test
    public void userSholdLoginSuccessfullyWithValid(){
        //finding username element
        WebElement username=driver.findElement(By.name("user-name"));
        //sending username to username field
        username.sendKeys("standard_user");
        //finding password element
        WebElement password=driver.findElement(By.id("password"));
        //sending password to password field
        password.sendKeys("secret_sauce");
        //finding log in button element
        WebElement loginButton=driver.findElement(By.id("login-button"));
        //sending click to login button
        loginButton.click();
        //finding element of Product tab
        WebElement productTab=driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
       String productTab1=productTab.getText();
       //expected message
       String expectedMessage="PRODUCTS";
       // Validate actual and expected message
        Assert.assertEquals("Product page",productTab1,expectedMessage);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        WebElement username=driver.findElement(By.name("user-name"));
        username.sendKeys("standard_user");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();
        //finding the element of a product
       List<WebElement> product=driver.findElements(By.className("inventory_item"));
       //finding the size of product
        int size =product.size();
        System.out.println(size);//it will print the size in console
        int expectedMessage=6;
        // Validate actual and expected message
        Assert.assertEquals("Product is not in display",expectedMessage,size);

    }


}

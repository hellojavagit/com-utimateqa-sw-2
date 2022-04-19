package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        String expectedMessage = "Welcome Back!";
        //clicking the sign in link
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
         signIn.click();
         //comparing the expected and actual results
         WebElement actualMessageDisplay = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageDisplay.getText();
        Assert.assertEquals("Does not match",expectedMessage,actualMessage);
    }
    //verifying the error message by sending wrong emailid
    @Test
    public void verifyTheErrorMessage(){
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();
        //sending the wrong email id and checking
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("Prime@gmail.com");
        //sending password fields
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("abcd");
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        loginButton.submit();
    }
    // closing the browser
    @After
    public void tearDown(){
        closeBrowser();
    }

}

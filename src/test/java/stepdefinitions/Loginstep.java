package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Loginstep {

    WebDriver driver;

    @Before
     public void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user is on login page")
    public void login() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    @When("user enters username and password in sauce demo")
    public void user_enters_username_and_password() {
       driver.findElement(By.id("user-name")).sendKeys("standard_user");
       driver.findElement(By.name("password")).sendKeys("secret_sauce");
       driver.findElement(By.id("login-button")).click();
    }

    @Then("user should login successfully in sauce demo")
    public void user_should_login_successfully() {

        String url = driver.getCurrentUrl();

        Assert.assertTrue(url.contains("html"));
        System.out.println("You Loged in successful");
    }

    @After
    public void close(){
        driver.quit();
    }
}
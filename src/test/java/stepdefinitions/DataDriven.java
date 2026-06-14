package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DataDriven {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user is on login page for data driven test")
    public void login() {
        driver.get("https://www.saucedemo.com/");
    }
    @When("user enters username {string}")
    public void username(String un) {
        driver.findElement(By.id("user-name")).sendKeys(un);
    }
    @When("user enters password {string}")
    public void password(String ps) {
        driver.findElement(By.id("password")).sendKeys(ps);
    }

    @And("click on login button")
    public void click() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Dashboard page should open")
    public void dashboard() {
        String url = driver.getCurrentUrl();

        // Better validation
        Assert.assertTrue(url.contains("inventory"));
        System.out.println("You Logged in successfully");
    }
    @After
    public void close() {
        driver.quit();
    }
}
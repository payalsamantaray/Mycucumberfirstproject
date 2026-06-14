package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginpage3withmultipledata {

    WebDriver driver;

    @Before
    public void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("open login page")
    public void login() {
        driver.get("https://the-internet.herokuapp.com/login");
    }
    //With Valid Data
    @When("passowrd and username")
    public void enetr() {
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }

    @Then("loogedin")
    public void partvalidation() {

        String message = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
        System.out.println("Login successful");
    }

    //With Invalid Data

    @Given("open")
    public void log() {
        driver.get("https://the-internet.herokuapp.com/login");
    }


    @When("clcik on the user name and enter username also passowrd")
    public void unpass() {
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }

    @Then("you should lohin succefully after enter passowrd and usrename")
    public void part() {

        String message = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
        System.out.println("Login successful");
    }


    @After
    public void close(){
        driver.quit();
    }
}

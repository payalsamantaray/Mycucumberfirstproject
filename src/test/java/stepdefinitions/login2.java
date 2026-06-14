package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class login2 {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("user is on orangeHRM login page")
    public void link() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user enters credentials in orangeHRM")
    public void enter() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
    }

    @Then("user should login successfully in orangeHRM")
    public void validation() throws InterruptedException {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("dashboard")); // better check
        System.out.println("Login successful");
        Thread.sleep(2000);
    }


    @After
    public void close() {
        driver.quit();
    }
}

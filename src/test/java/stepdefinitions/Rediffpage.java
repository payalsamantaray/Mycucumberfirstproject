package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Rediffpage {

    WebDriver driver;

    // ✅ Setup browser
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // ✅ Open URL
    @Given("user is on registration page")
    public void login() {
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
    }

    // ✅ Enter data + Scroll + Click
    @When("Enter the following data")
    public void eneterdats(DataTable dataTable) throws InterruptedException {

        List<List<String>> data = dataTable.asLists();

        // Name
        driver.findElement(By.cssSelector("input[placeholder='Enter your full name']"))
                .sendKeys(data.get(0).get(0));

        Thread.sleep(1000);

        // Email
        driver.findElement(By.xpath("//input[@placeholder='Enter Rediffmail ID']"))
                .sendKeys(data.get(0).get(1));

        // Password
        driver.findElement(By.cssSelector("input[placeholder='Enter password']"))
                .sendKeys(data.get(0).get(2));

        // Confirm Password
        driver.findElement(By.id("newpasswd1"))
                .sendKeys(data.get(0).get(2));

        // DOB
        new Select(driver.findElement(By.cssSelector("select.day")))
                .selectByVisibleText(data.get(0).get(3));

        new Select(driver.findElement(By.cssSelector("select.middle.month")))
                .selectByVisibleText(data.get(0).get(4));

        new Select(driver.findElement(By.cssSelector("select.year")))
                .selectByVisibleText(data.get(0).get(5));

        // ✅ Scroll to Register button
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.id("Register")));

        Thread.sleep(2000); // optional (just to see scroll)

        // Click Register
        driver.findElement(By.id("Register")).click();
    }

    // ✅ Validation
    @Then("Registartion successfully.")
    public void registartion() {

        String error = driver.findElement(By.cssSelector("span#errmsgInfo")).getText();

        System.out.println("Message: " + error);

        Assert.assertTrue(error.contains("Please re-enter your ID"));

        System.out.println("Test pass ✅");
    }

    // ✅ Close browser
    @After
    public void tearDown() {
        driver.quit();
    }
}

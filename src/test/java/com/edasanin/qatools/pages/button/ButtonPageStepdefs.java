package com.edasanin.qatools.pages.button;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class ButtonPageStepdefs {

    final WebDriver driver;
    Actions actions;

    ButtonPageStepdefs() {
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    @Given("Open the demoqa websites")
    public void openTheDemoqaWebsites() throws InterruptedException {
        driver.get("https://demoqa.com");

        synchronized (driver) {
            driver.wait(1000);
        }
    }

    @And("Click to elements button")
    public void clickToElementsButton() {
        try {
            driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]")).click();
        } catch (NoSuchElementException exception) {
            driver.close();
        }
    }

    @And("Click to buttons")
    public void clickToButtons() {
        driver.findElement(By.xpath("(//li[@id='item-4'])")).click();
    }

    @When("Click to double click me")
    public void clickToDoubleClickMe() throws InterruptedException {
        var doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(doubleClickButton).perform();

        synchronized (driver) {
            driver.wait(1000);
        }

        var message = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));

        assertEquals("You have done a double click", message.getText());
    }

    @And("Click to right click me")
    public void clickToRightClickMe() throws InterruptedException {
        var rightClickButton = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        actions.contextClick(rightClickButton).perform();

        synchronized (driver) {
            driver.wait(1000);
        }

        var message = driver.findElement(By.xpath("//p[@id='rightClickMessage']"));

        assertEquals("You have done a right click", message.getText());
    }

    @Then("Click to click me")
    public void clickToClickMe() {
        driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])")).click();

        var message = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));

        assertEquals("You have done a dynamic click", message.getText());
    }

    @After()
    public void closeBrowser()
    {
        driver.quit();
    }

}

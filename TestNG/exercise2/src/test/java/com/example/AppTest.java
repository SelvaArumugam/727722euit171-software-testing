package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    @BeforeTest
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com");
        Thread.sleep(10000);
    }
    @Test(priority = 0)
    public void serach() {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"search_str\"]"));
        search.sendKeys("Reliance Industries");
        driver.findElement(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a")).click();
    }
     @Test(priority = 1)
     public void clickSipReturns() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Mutual Funds")));
        driver.findElement(By.linkText("SIP Return")).click();
     }
     @Test(priority = 2)
     public void select() {
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"ff_id\"]")));
        dropdown.selectByVisibleText("Axis Mutual Fund");
        Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"im_id\"]")));
        dropdown1.selectByValue("MAA587");
        driver.findElement(By.xpath("//*[@id=\"invamt\"]")).sendKeys("100000");
        driver.findElement(By.xpath("//*[@id=\"stdt\"]")).sendKeys("2021-08-02");
        driver.findElement(By.xpath("//*[@id=\"endt\"]")).sendKeys("2023-08-17");
        driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input")).click();
     }
     @Test(priority = 3)
     public void printTable() {
        WebElement row1 = driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[5]/table/tbody/tr[1]"));
        List<WebElement> row1c = row1.findElements(By.xpath(".//td"));
        WebElement row2 = driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[5]/table/tbody/tr[3]"));
        List<WebElement> row2c = row2.findElements(By.xpath(".//td"));
        for(WebElement cell: row1c) {
            System.out.println(cell.getText());
        }
        for(WebElement cell: row2c) {
            System.out.println(cell.getText());
        }
     }
    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}

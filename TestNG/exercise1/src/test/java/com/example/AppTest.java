package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://economictimes.indiatimes.com/et-now/results");
    }
    @Test(priority = 0)
    public void clickMutualFunds() {
        driver.findElement(By.linkText("Mutual Funds")).click();
    }
    @Test(priority = 1)
    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
    @Test(priority = 2)
    public void chooseAmc() {
        Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id='amcSelection']")));
        dropdown1.selectByVisibleText("Canara Robeco");
        Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id='schemenm']")));
        dropdown2.selectByIndex(5);
        driver.findElement(By.id("getDetails")).click();
    }
    @Test(priority = 3)
    public void switchTab() {
        String s = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(s)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }
    @Test(priority = 4)
    public void chooseGivenDetails() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li/span")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li/ul/li[3]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li/span")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li/ul/li[4]/span")).click();
    }
    @Test(priority = 5)
    public void printTable() {
        WebElement row = driver.findElement(By.xpath("//*[@id=\"mfReturns\"]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        List<WebElement> web = row.findElements(By.xpath(".//td"));
        for(WebElement cell : web)
        {
            System.out.println(cell.getText());
        }
    }
    @AfterTest
    public void driverQuit() {
        driver.quit();
    }
}

package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/news/technology/government-mandates-encryption-for-cctv-cameras-over-security-concerns-12646971.html");
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//*[@id=\"search_str\"]"));
        search.sendKeys("Reliance Industries");
        //search.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        //Actions action = new Actions(driver);
        driver.findElement(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Mutual Funds")).click();
        Thread.sleep(1000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1200)");
        Thread.sleep(1000);
        driver.findElement(By.linkText("SIP")).click();
        //driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/p/a")).click();
        //WebElement reliance = driver.findElement(By.xpath("//*[@id=\"autosugg_mc1\"]"));
        //reliance.findElement(By.xpath("//*[@id=\"autosuggestlist\"]/ul/li[1]/a")).click();
        //driver.findElement(By.xpath("/html/body/header/div/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}

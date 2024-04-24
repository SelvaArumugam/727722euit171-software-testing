package com.example;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     * 
     * @throws InterruptedException
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://economictimes.indiatimes.com/et-now/results");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Mutual Funds")).click();
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id='amcSelection']")));
        dropdown1.selectByVisibleText("Canara Robeco");
        Thread.sleep(1000);
        Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id='schemenm']")));
        dropdown2.selectByIndex(5);
        Thread.sleep(1000);
        driver.findElement(By.id("getDetails")).click();
        Thread.sleep(1000);
        String s = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(s)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,200)");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li/span")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_amt\"]/li/ul/li[3]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li/span")).click();
        driver.findElement(By.xpath("//*[@id=\"installment_period\"]/li/ul/li[4]/span")).click();
        Thread.sleep(1000);
        WebElement row = driver.findElement(By.xpath("//*[@id=\"mfReturns\"]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        List<WebElement> web = row.findElements(By.xpath(".//td"));
        for(WebElement cell : web)
        {
            System.out.println(cell.getText());
        }
        Thread.sleep(3000);
        driver.quit();
    }
}

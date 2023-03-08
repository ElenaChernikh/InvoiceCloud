package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class InvoiceCloudTask {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com");

        WebElement addRemoveLink = driver.findElement(By.linkText("Add/Remove Elements"));
        addRemoveLink.click();

        int n = 5;
        for (int i = 0; i < n; i++) {
            WebElement addButton = driver.findElement(By.xpath("//*[@id='content']/div/button"));
            addButton.click();
        }

        WebElement parentElement = driver.findElement(By.xpath("//div[@id='elements']"));

        List<WebElement> childElements = parentElement.findElements(By.xpath("./*"));
        Assert.assertEquals(n, childElements.size());

        /* or
        int actualNumberOfElements = driver.findElements(By.xp("//div[@id='elements'] > button")).size();
        Assert.assertEquals(n, actualNumberOfElements);
         */

        driver.quit();
    }
}
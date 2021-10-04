package Assignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClassService {
	ChromeDriver driver;
  @BeforeMethod
  public void preCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://dev96375.service-now.com/navpage.do");
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Abinjenny@96");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("filter")).sendKeys("incident");

  }

  @AfterMethod()
  public void postCondition() {
  driver.close();
  }

}

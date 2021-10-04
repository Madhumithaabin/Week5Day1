package Assignments;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowDelete extends BaseClassService {

	@Test
	public void servicedelete() {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Open")).click();
		WebElement frame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);

		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();

		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Open")).click();

		WebElement frame4 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame4);

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);
		String deleteConfirm = driver.findElement(By.xpath("//tr[@class='list2_no_records']/td")).getText();
		if (deleteConfirm.equals("No records to display"))
			System.out.println("incident is Deleted successful");
		else
			System.out.println("incident is not deleted");
	}

}

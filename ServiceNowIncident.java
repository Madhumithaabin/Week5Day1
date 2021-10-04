package Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowIncident extends BaseClassService {

	@Test
	public void serviceincident() {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Open")).click();
		WebElement frame2 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);

		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		driver.switchTo().defaultContent();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(newwindow.get(1));
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("s", Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(newwindow.get(0));
		WebElement frame3 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Tesleaf");
		driver.findElement(By.name("not_important")).click();
		driver.switchTo().defaultContent();

		WebElement frame4 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame4);

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);
		String assigned = driver.findElement(By.xpath("(//a[@class='linked'])[2]")).getText();
		if (assigned.equals("Software"))
			System.out.println("incident is assigned to software group");
		else
			System.out.println("incident is assigned not to software group");
driver.switchTo().defaultContent();
	}

}

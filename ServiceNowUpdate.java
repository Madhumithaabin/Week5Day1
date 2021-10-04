package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ServiceNowUpdate extends BaseClassService {

	@Test
	public void serviceUpdate() {
		// TODO Auto-generated method stub
		driver.findElement(By.linkText("Open")).click();
		WebElement frame4 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNum);

		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select select = new Select(urgency);
		select.selectByValue("1");
		WebElement stateElement = driver.findElement(By.id("incident.state"));
		Select state = new Select(stateElement);
		state.selectByValue("2");
		driver.findElement(By.name("not_important")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

		WebElement frame2 = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frame2);
WebElement typeReq = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
Select type=new Select(typeReq);
type.selectByValue("number");
driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNum, Keys.ENTER);
		String urgencyname = driver.findElement(By.xpath("(//td[@class='vt'])[5]")).getText();
		String statename = driver.findElement(By.xpath("(//td[@class='vt'])[6]")).getText();
		System.out.println(urgencyname);

		System.out.println(statename);
		if (urgencyname.contains("High") && statename.contains("In Progress"))
			System.out.println("Urgency and State of the incident is Updated");
		else
			System.out.println("Urgency and State of the incident not Updated");
		driver.switchTo().defaultContent();
	}

}

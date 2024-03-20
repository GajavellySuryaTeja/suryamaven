package hookspractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;

public class Stepdefination {
	public WebDriver driver=null;
	@Before
	public void setup() {
		driver=new ChromeDriver();
		System.out.println("before method executed");
	}
	@Before(order = 2)
	public void nextlevel() {
		System.out.println("go to the next level");
	}
	@Before(order = 1)
	public void setup2() {
		System.out.println("chrome browser successfully opened");
	}
	@After
	public void closed() {
		System.out.println("browser closed successfully");
	}
	@After(order = 1)
	public void applicationclosed() {
		System.out.println("browser application successfully closed");
	}
	@Given("open url browser")
	public void open_url_browser() throws InterruptedException {
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  Thread.sleep(3000);
	  System.out.println("this url method");
	}
	
	@BeforeStep
	public void step() {
		System.out.println("before step for every scenario");
	}
	
	@AfterStep
	public void steps() {
		System.out.println("after the step for every scenario");
	}
	

	@And("give login credentials and click")
	public void give_login_credentials_and_click() throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	Thread.sleep(3000);
	System.out.println("valid username and password");
	}

	@Then("select dropdown picture and logout")
	public void select_dropdown_picture_and_logout() throws InterruptedException {
	 driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[text()='Logout']")).click();
	 Thread.sleep(3000);
	 System.out.println("logout succesfulley doine");
	}

	@When("close")
	public void close() {
	driver.close(); 
	System.out.println("close the current browser");
	}

}

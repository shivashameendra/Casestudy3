package Casestudy3.Casestudy3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Onlineshopping {
WebDriver driver;
ExtentReports extent;
ExtentHtmlReporter htmlReporter;
ExtentTest test;
  @AfterTest
  public void endReportAfterTest() {
 extent.flush();
 
  }
  @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException {
 if(result.getStatus() == ITestResult.FAILURE) {
test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
TakesScreenshot snapshot = (TakesScreenshot)driver;
File src = snapshot.getScreenshotAs(OutputType.FILE);
String path = System.getProperty("user.dir") +"/test-output/screens/"+result.getName()+".png";
FileUtils.copyFile(src,new File(path));
test.addScreenCaptureFromPath(path, result.getName());
test.fail(result.getThrowable());
}
else if(result.getStatus() == ITestResult.SUCCESS) {
test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED ",ExtentColor.GREEN));
}
else {
test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED ",ExtentColor.ORANGE));
}
 
  }
  @BeforeTest
  public void startReportBeforeTest() {
 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
 extent = new ExtentReports();
 extent.attachReporter(htmlReporter);
//	 extent.setSystemInfo("OS" , OS);
//	 extent.setSystemInfo("Browser",browser);
//	 htmlReporter.config().setChartVisibilityOnOpen(true);
 htmlReporter.config().setDocumentTitle("Extent Report Demo");
 htmlReporter.config().setReportName("Test Report");
//	 htmlReporter.config().settestViewChartLocation(ChartLocation.TOP);
 htmlReporter.config().setTheme(Theme.STANDARD);
 htmlReporter.config().setTimeStampFormat("EEEE, MMMM DD, YYYY, hh:mm:a '('zzz')'");

  }
  @Test(priority=3)
  public void testCart() {
	  test=extent.createTest("Tc_03","AddToCart");
 driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("headphone");
 driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
 String Avlproduct=driver.findElement(By.xpath("//h4[text()='Headphone']")).getText();
 Assert.assertEquals("Headphone",Avlproduct);
 driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
  }
  @Test(priority=2)
  public void testLogin() {
 test=extent.createTest("Tc_02","login");
//	 driver.findElement(By.linkText("SignIn")).click();
driver.findElement(By.name("userName")).sendKeys("vvvcvvbnas");
driver.findElement(By.name("password")).sendKeys("akella123");
driver.findElement(By.name("Login")).click();
//String LoginVal = driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).getText();
String Loginval = "Home";
String Verify = driver.getTitle();
//System.out.println(Verify);
Assert.assertEquals(Verify,Loginval);

  }
  @Test(priority=4)
  public void testPayment() throws InterruptedException {
 test=extent.createTest("Tc_04","pn");
 driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
 driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
 driver.findElement(By.xpath("//textarea[@name='ShippingAdd']")).sendKeys("akellaertgg");
 driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
 driver.findElement(By.xpath("//a[text()='Continue']")).click();
 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
 driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
 driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).sendKeys("Trans@456");
 driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
 String E_title = driver.getTitle();
 String A_title ="Order Details";
 Assert.assertEquals( A_title,E_title);
 driver.close();
  }
  @Test(priority=1)
  public void testRegistration() throws InterruptedException {
 test=extent.createTest("Tc_01","REgistratiopn");
 driver = Webdrivers.getDriver("chrome");
 driver.get("http://10.232.237.143:443/TestMeApp");
 driver.manage().window().maximize();
 driver.findElement(By.linkText("SignUp")).click();
 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("vvvcvvbnas");
 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("akella");
 driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("akella");
 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("akella123");
 driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("akella123");
 driver.findElement(By.xpath("//input[@value='Male']")).click();
 driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("akella@gmail.com");
 driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("1234567890");
 driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("19/05/1991");
 driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("akellaertgg");
 Thread.sleep(5000);
 String verify1 = "Available";
 String verify2 = driver.findElement(By.xpath("//span[text()='Available']")).getText();
 Assert.assertEquals(verify1,verify2);
 driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).click();
//	 
  }

}


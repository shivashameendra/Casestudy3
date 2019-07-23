package Casestudy3.Casestudy3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Webdrivers {
  @Test
  public static  WebDriver getDriver(String browser) {
 if (browser.equals("chrome"))
 {
 System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
 return new ChromeDriver();
 
 }
 else if (browser.equals("ie"))
 {
 System.setProperty("webdriver.ie.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
 return new InternetExplorerDriver();
 }
 else if (browser.equals("ff"))
 {
 System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
 return new FirefoxDriver();
 }
 else
 return null;
  }
}
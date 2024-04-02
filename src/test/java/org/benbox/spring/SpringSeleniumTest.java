package org.benbox.spring;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SpringSeleniumTest {

  WebDriver driver;

  public SpringSeleniumTest() {

    System.setProperty("webdriver.chrome.driver",
        "/opt/homebrew/Caskroom/chromedriver/123.0.6312.86/chromedriver-mac-arm64/chromedriver");
    driver = new ChromeDriver();

    driver.get("http://localhost:8081/");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    System.out.println("Titel: " + driver.getTitle());
    assert driver.getTitle().equals("Getting Started: Serving Web Content");
    System.out.println("URL: " + driver.getCurrentUrl());
    assert driver.getCurrentUrl().equals("http://localhost:8081/");
  }

  public static void main(String[] args) {

    SpringSeleniumTest seleniumTest = new SpringSeleniumTest();
    //seleniumTest.test_02_01();
    //seleniumTest.test_02_02();
    //seleniumTest.test_02_03();
    //seleniumTest.test_02_04();
    //seleniumTest.test_02_05();
    seleniumTest.test_02_06();
    seleniumTest.tearDown();
  }

  private void tearDown() {
    wait5sec();
    driver.close();
    driver.quit();
  }

  private void test_02_01() {
    wait5sec();

    // Betätige den Link
    driver.findElement(By.linkText("here")).click();
  }

  private void test_02_02() {
    wait5sec();
    driver.navigate().to("http://localhost:8081/");

    wait5sec();
    driver.navigate().back();

    wait5sec();
    driver.navigate().forward();
    assert driver.getTitle().equals("Getting Started: Serving Web Content");
    assert driver.getCurrentUrl().equals("http://localhost:8081/");
  }

  private void test_02_03() {
    wait5sec();
    driver.navigate().to("http://localhost:8081/page2.html");

    WebElement webElementUser1 = driver.findElement(By.id("user_1"));
    System.out.println("User 1: " + webElementUser1.getText());

    List<WebElement> webElementUsers = driver.findElements(By.className("man"));
    for (WebElement webElement : webElementUsers) {
      System.out.println("User: " + webElement.getText());
    }
  }

  private void test_02_04() {
    wait5sec();
    driver.navigate().to("http://localhost:8081/page3.html");

    driver.findElement(By.id("name")).sendKeys("Max Mustermann");
    driver.findElement(By.id("yes")).click();
    driver.findElement(By.id("python")).click();
    List<WebElement> skillsWebElement = driver.findElements(By.name("skills"));
    for (WebElement skillWebElement : skillsWebElement) {
      System.out.println("Skill: " + skillWebElement.getAttribute("value"));
    }
  }

  private void test_02_05() {
    wait5sec();
    driver.navigate().to("http://localhost:8081/page3.html");

    Select weekdaysSelect = new Select(driver.findElement(By.id("weekdays")));
    weekdaysSelect.selectByIndex(0);
    wait5sec();
    weekdaysSelect.selectByValue("tuesday");
    wait5sec();
    weekdaysSelect.selectByVisibleText("Wednesday");
    assert !weekdaysSelect.getAllSelectedOptions().isEmpty();
  }

  private void test_02_06() {
    wait5sec();
    driver.navigate().to("http://localhost:8081/page3.html");
    driver.findElement(By.xpath("//*[@value='Save']")).click();
    assert driver.switchTo().alert().getText().equals("Saved");
    wait5sec();
    driver.quit();
  }

  private void wait5sec() {
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

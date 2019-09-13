package testcases.sign_up;

import HelperService.UIServiceFossil;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class By_Email extends UIServiceFossil {
    public AndroidDriver<MobileElement> driver;
    public String email_OTP = "auto.test01@mailinator.com";
    public String pwd_email = "Abc@123";
    public String linkMailWeb = "https://www.mailinator.com/v3/index.jsp?zone=public&query=auto.test01#/#inboxpane";
    @BeforeTest
    public void setup() throws MalformedURLException {

        String appiumserverurl = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("flatformVersion", "9.0");
        cap.setCapability("app", "/Users/pqtuan/Downloads/Portfolio Application/Portfolio Builds/Android Build/FossilQ_4_0-23406.apk");
        cap.setCapability("deviceName", "ce03171320ed983c02");
        cap.setCapability("automationame", "UiAutomator2");

        driver = new AndroidDriver<MobileElement>(new URL(appiumserverurl), cap);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;

    }

    @Test
    public void signup_email() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);

        MobileElement getStared_Button = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"GET STARTED\")");
        wait.until(ExpectedConditions.visibilityOf(getStared_Button));
        getStared_Button.click();




        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Email\")").sendKeys(email_OTP);
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Password\")").sendKeys(pwd_email);
        sleepIn(3);
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"CONTINUE\")").click();







//        WebDriver driver1;
//        driver1 = new ChromeDriver();
//        driver1.get(linkMailWeb);

    }

    ;


    public void tearDown() {
        driver.quit();
    }
}

package testcases.sign_up;

import Common.ElementDeclaration;
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

public class VerifySignUpButton extends UIServiceFossil {
    public AndroidDriver<MobileElement> driver;




    @BeforeTest
    public void setup() throws MalformedURLException {

        String appiumserverurl = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("flatformVersion", "9.0");
        cap.setCapability("app", "/Users/pqtuan/Downloads/Portfolio Application/Portfolio Builds/Android Build/FossilQ_4_0-23457.apk");
        cap.setCapability("deviceName", "ce03171320ed983c02");
        cap.setCapability("automationame", "UiAutomator2");

        driver = new AndroidDriver<MobileElement>(new URL(appiumserverurl), cap);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;

    }

    @Test
    public void verifysignupbutton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);

        MobileElement getStared_Button = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"GET STARTED\")");
        wait.until(ExpectedConditions.visibilityOf(getStared_Button));

        Boolean checkGetStarted = getStared_Button.isEnabled();
        if (checkGetStarted==false){
            System.out.print("Getting failed");
        }
        else { System.out.print("Get Started is displayed as expected ");
            getStared_Button.click();}



        MobileElement login_button = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"LOG IN\")");
        login_button.click();



        MobileElement email_login = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Email\")");
        email_login.sendKeys("ABC");


        sleepIn (2);

        MobileElement password_login = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Password\")");
        password_login.sendKeys("Abc");



        Boolean check_login_button = email_login.isEnabled();
        if (check_login_button== false){
            System.out.print(" Login Button got disabled -> Testcase passed");
        } else
        { System.out.print("Button got enabled");
        email_login.click();};



















//        WebDriver driver1;
//        driver1 = new ChromeDriver();
//        driver1.get(linkMailWeb);

    }




    public void tearDown() {
        driver.quit();
    }
}

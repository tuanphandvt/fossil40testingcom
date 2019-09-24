package testcases.sign_up;

import Common.ElementDeclaration;
import HelperService.UIServiceFossil;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
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

import static org.openqa.selenium.By.*;

public class ForgotPW extends UIServiceFossil {
    public AndroidDriver<MobileElement> driver;




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

        Boolean checkGetStarted = getStared_Button.isEnabled();
        if (checkGetStarted==false){
            System.out.print("Getting failed");
        } else {getStared_Button.click();}

        getStared_Button.click();

        sleepIn(5);

        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"LOG IN\")").click();

        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Email\")").sendKeys("ryan911fs@gmail.com");

        sleepIn (2);
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Password\")").sendKeys("Abc@123");



        driver.findElement(id("com.fossil.wearables.fossil.staging:id/bt_continue")).click();

        sleepIn (3);


      //  driver.findElement(By.name("Profile")).click();
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Profile\")").click();

        driver.findElement(xpath("//android.widget.TextView[@text='Set Goals']")).click();
        sleepIn (2);

        driver.findElement(xpath("//[@id='com.fossil.wearables.fossil.staging:id/fet_goals_value']")).clear();


        driver.findElement(id("com.fossil.wearables.fossil.staging:id/fet_goals_value")).sendKeys("7000");


        driver.findElement(id("com.fossil.wearables.fossil.staging:id/iv_back")).click();

        driver.findElement(id("com.fossil.wearables.fossil.staging:id/tv_ok")).click();

       // driver.findElement(id(ElementDeclaration.CLOSE_SIGNUP_SCREEN));








//        WebDriver driver1;
//        driver1 = new ChromeDriver();
//        driver1.get(linkMailWeb);

    }

    ;


    public void tearDown() {
        driver.quit();
    }
}

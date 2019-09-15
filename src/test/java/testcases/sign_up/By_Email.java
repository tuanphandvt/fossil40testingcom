package testcases.sign_up;

import HelperService.UIServiceFossil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class By_Email extends UIServiceFossil {
    public AndroidDriver<MobileElement> driver;
    public String email_OTP = "auto.test01@mailinator.com";
    public String pwd_email = "Abc@123";
    public String linkMailWeb = "https://www.mailinator.com/v3/index.jsp?zone=public&query=auto.test01#/#inboxpane";

    @BeforeClass
    public void setup() throws MalformedURLException {
        String appiumserverurl = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("flatformVersion", "9.0");
        cap.setCapability("app", "/Users/pqtuan/Downloads/Portfolio Application/Portfolio Builds/Android Build/FossilQ_4_0-23406.apk");
        cap.setCapability("deviceName", "ce03171320ed983c02");
        cap.setCapability("automationame", "UiAutomator2");

        driver = new AndroidDriver<MobileElement>(new URL(appiumserverurl), cap);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void signup_email() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,5);
        MobileElement getStared_Button = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"GET STARTED\")");
        wait.until(ExpectedConditions.visibilityOf(getStared_Button));
        getStared_Button.click();


        MobileElement email = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Email\")");
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(email_OTP);

        MobileElement password = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Password\")");
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pwd_email);
        sleepIn(3);


        MobileElement continueButton = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"CONTINUE\")");
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"CONTINUE\")").click();

        //get OTP from mailinator

        WebDriver webDriver = new ChromeDriver();
        webDriver.get(linkMailWeb);

        WebElement mail_OTP = webDriver.findElement(By.xpath("//a[contains(text(),'Fossil Smartwatches Verification Code')]"));
        mail_OTP.click();
        sleepIn(2);

        WebElement msg_body_iframe = webDriver.findElement(By.id("msg_body"));
        webDriver.switchTo().frame(msg_body_iframe);


        List<WebElement> listElement = webDriver.findElements(By.xpath("//div[text()='Your verification code']//ancestor::div//following-sibling::div//th"));
        List<String> OTP = new ArrayList<String>();
        int i;
        for (i=0;i<listElement.size(); i++){
            if (listElement.get(i).getText() != null  & !listElement.get(i).getText().equals(" ")) {
                OTP.add(listElement.get(i).getText());
            }
        }

        System.out.println(OTP);
        webDriver.quit();

        MobileElement OTP_First = driver.findElementByAndroidUIAutomator("new UiSelector()." +
                "resourceId(\"com.fossil.wearables.fossil.staging:id/et_first_code\")");
        wait.until(ExpectedConditions.visibilityOf(OTP_First));
        OTP_First.sendKeys(OTP.get(0));
        sleepIn(3);


        MobileElement OTP_Second = driver.findElementByAndroidUIAutomator("new UiSelector()." +
                "resourceId(\"com.fossil.wearables.fossil.staging:id/et_second_code\")");
        wait.until(ExpectedConditions.visibilityOf(OTP_Second));
        sleepIn(3);
        OTP_Second.click();
        System.out.println(OTP.get(1));
        OTP_Second.sendKeys(OTP.get(2));


        MobileElement OTP_Third = driver.findElementByAndroidUIAutomator("new UiSelector()." +
                "resourceId(\"com.fossil.wearables.fossil.staging:id/et_third_code\")");
        wait.until(ExpectedConditions.visibilityOf(OTP_Third));
        OTP_Third.sendKeys(OTP.get(4));

        MobileElement OTP_Fourth = driver.findElementByAndroidUIAutomator("new UiSelector()." +
                "resourceId(\"com.fossil.wearables.fossil.staging:id/et_fourth_code\")");
        wait.until(ExpectedConditions.visibilityOf(OTP_Fourth));
        OTP_Fourth.sendKeys(OTP.get(6));


        MobileElement Continue_Signup = driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"CONTINUE\")");
        wait.until(ExpectedConditions.visibilityOf(Continue_Signup));
        Continue_Signup.isEnabled();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Applicationhelper {
    public static AppiumDriver<MobileElement> driver = null ;

    public static void launchApp () throws Exception {
        try {
            System.out.print("Launching the application...");
            String AppiumServerURL = "http://127.0.0.1:4723/wd/hub";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, ElementDeclaration.DEVICE_NAME);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ElementDeclaration.PLATFORM);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ElementDeclaration.OS_VERSION);
            caps.setCapability(MobileCapabilityType.APP, ElementDeclaration.APP);
            driver = new AndroidDriver<MobileElement>(new URL(AppiumServerURL), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.setLogLevel(Level.INFO);
            System.out.print("Launched the application successfully");
        } catch (Exception e)
        {
         e.printStackTrace();
         throw new Exception("Cannot launch app !!",e);
        }

    //Quit App
        }
    public static void quitApp () throws Exception{
        try{
            System.out.print("Prepare for quiting the application ...");
            driver.quit();
            System.out.print("App got quited successfully !");
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new Exception("Cannot quit app !!", e);
        }

    }
    //Check Element is enabled
    public static void checkElenmentisEnable (MobileElement mobileElement) throws Exception {
        try{
            System.out.print("Checking if the element is enable ....");
            Assert.assertTrue(mobileElement.isEnabled());
            System.out.print("The element is enabled ");
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("The element is disabled",e);
        }

    }
    //Tap Button

    public static void tapButton (MobileElement mobileElement) throws Exception{
        checkElenmentisEnable(mobileElement);
        mobileElement.click();

    }
    //Get the element by ID
    public static MobileElement getElementbyID (String strElement) throws NoSuchElementException {
        {
            return driver.findElement(By.id(strElement));
        }

    }


}

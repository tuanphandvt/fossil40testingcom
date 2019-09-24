package testcases.sign_up;

import Common.Applicationhelper;
import Common.ElementDeclaration;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Click_Getstarted {

    @BeforeClass
    public void beforeTest() throws Exception {
        //Launching the application
    step.launchApp();

    }

    @AfterClass
    public void afterTest() throws Exception{
        step.quitApp();
    }

    @Test(priority = 1)
    public void openSignUpScreen() throws Exception {



        //Get Started button on the screen


        //Tap on Get Started button


        step.openSignUpScreen();

       // step.verifySignUpScreenIsDisplayed();
    }

    class Step {
        public void launchApp () throws Exception {
            try {
                Applicationhelper.launchApp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void quitApp() throws Exception {
            try {
                Applicationhelper.quitApp();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void openSignUpScreen() throws Exception {
            MobileElement me = Applicationhelper.getElementbyID(ElementDeclaration.GET_STARTED_BUTTON_WL);
            try {
                Applicationhelper.tapButton(me);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    Step step = new Step();
}

package Credentials;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import com.edureka.project.ObjectRepo.LoginPage;
import com.edureka.project.genericLib.BaseClass;

public class InvalidLogin {

    @Listeners(com.edureka.project.genericLib.ListenerImpClass.class)
    public class ValidateCredentialsTest extends BaseClass {
        Logger log = Logger.getLogger(ValidateCredentialsTest.class);

        @Test
        public void InvalidcredentialTest() {
            LoginPage login = PageFactory.initElements(driver, LoginPage.class);
            log.debug("Home Page is Displayed");
            String expText = "Login Failed!";
            log.info("Expected Text when login is incorrect is " + expText);
            String actText = login.getFailedMSG().getText();
            
            AssertJUnit.assertEquals(actText, expText);
            if (expText.equals(actText)) {
                log.info("Title is matching");
            } else {
                log.error("Title is not matching");
            }
        }
    }
}

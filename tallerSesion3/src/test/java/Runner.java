import io.appium.java_client.AppiumDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;

@RunWith(Cucumber.class)
public class Runner {
    // HOOKS

    public static AppiumDriver driver;
    @Before
    public void beforeScenario() throws MalformedURLException {

    }

    @After
    public void afterScenario(){
        System.out.println("*************  After Scenario Cucumber *************");
        driver.quit();
    }

}
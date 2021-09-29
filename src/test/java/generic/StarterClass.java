package generic;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import utill.Common;
import webPages.AmazonHomePage;
import java.io.IOException;
import java.util.Properties;


public  class StarterClass extends Common {
    public static AmazonHomePage amazonHomePage;
    String PropertiesFilePath = "config.properties";
    public static Properties prop;
    {
        try {
            prop = loadProperties(PropertiesFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    String testingEnvironment= prop.getProperty("TestingEnvironment");
    Boolean useCloudEnv= Boolean.parseBoolean(prop.getProperty("UseCloudEnv")) ;
    String cloudEnvName= prop.getProperty("CloudEnvName");
    String os= prop.getProperty("Os");
    String os_version = prop.getProperty("Os_version");
    String browserName = prop.getProperty("BrowserName");
    String browserVersion = prop.getProperty("BrowserVersion");
    String url = prop.getProperty("Url");
    long implicitlyWaitTime=Long.parseLong(prop.getProperty("ImplicitlyWaitTime").trim());
    //long implicitlyWaitTime= implicitlywaitTime.longValue();

    // Read properties from propertie file

    public static void Init() {
        amazonHomePage = PageFactory.initElements(driver,AmazonHomePage.class);
    }

    @Before
    public void setUp_Init() throws IOException {
        System.out.println("The Testing Environment is: "+ testingEnvironment);
        System.out.println("Use Cloud Environment? "+useCloudEnv);
        System.out.println("The Cloud Environment Name is: "+cloudEnvName);
        System.out.println("The os is: "+os);
        System.out.println("The os_version is: "+os_version);
        System.out.println("The browser Version is: "+browserVersion);
        System.out.println("The browser Name is: "+browserName);
        System.out.println("The url is: "+url);
        System.out.println("The implicitly Wait Time is: "+implicitlyWaitTime);
        setUp( useCloudEnv,  cloudEnvName,
                os,  os_version,  browserName,
                browserVersion, url,implicitlyWaitTime);
        Init();
    }
    //ScreenShot method
    @After
    public void tearDown(Scenario scenario) throws IOException {
        screenShot(scenario);
        driver.quit();

    }
}